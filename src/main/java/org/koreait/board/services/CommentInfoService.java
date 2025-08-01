package org.koreait.board.services;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.koreait.board.controllers.RequestComment;
import org.koreait.board.entities.Comment;
import org.koreait.board.entities.QComment;
import org.koreait.board.exceptions.CommentNotFoundException;
import org.koreait.board.repositories.CommentRepository;
import org.koreait.member.entities.Member;
import org.koreait.member.libs.MemberUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Lazy
@Service
@Transactional
@RequiredArgsConstructor
public class CommentInfoService {
    private final CommentRepository commentRepository;
    private final HttpSession session;
    private final JPAQueryFactory queryFactory;
    private final MemberUtil memberUtil;
    private final ModelMapper mapper;

    /**
     * 댓글 한 개 조회
     * @param seq
     * @return
     */
    public Comment get(Long seq) {
        Comment item = commentRepository.findById(seq).orElseThrow(CommentNotFoundException::new);

        addInfo(item); // 추가 정보 처리

        return item;
    }

    public RequestComment getForm(Long seq) {
        return mapper.map(get(seq), RequestComment.class);
    }

    /**
     * 게시글별 댓글 목록
     * @param boardDataSeq : 게시글 번호
     * @return
     */
    public List<Comment> getList(Long boardDataSeq) {
        QComment comment = QComment.comment;

        List<Comment> items = queryFactory.selectFrom(comment)
                .leftJoin(comment.member)
                .fetchJoin()
                .where(comment.item.seq.eq(boardDataSeq))
                .orderBy(comment.createdAt.asc())
                .fetch();

        // 추가 정보 처리
        items.forEach(this::addInfo);

        return items;
    }

    /**
     * 추가 정보 처리
     * @param item
     */
    private void addInfo(Comment item) {
        boolean editable = true, guest = false;

        /**
         * 직접 작성한 게시글 여부
         * 1. 회원
         *      - 댓글을 작성한 회원 번호와 로그인한 회원의 회원번호가 일치하는지
         * 2. 비회원
         *      - 세션값에 comment_seq_댓글번호가 존재하면 비회원 인증 완료
         */
        Member commentMember = item.getMember();
        Member member = memberUtil.getMember();

        if (commentMember == null) { // 비회원이 작성한 댓글
            item.setMine(session.getAttribute("comment_seq_" + item.getSeq()) != null); // 비회원 인증 여부
            guest = true;
        } else { // 회원이 작성한 댓글
            item.setMine(memberUtil.isLogin() && member.getSeq().equals(commentMember.getSeq()));
            if (!memberUtil.isAdmin()) {
                editable = item.isMine();
            }
        }

        item.setEditable(editable);
        item.setGuest(guest); // 비회원 댓글 여부
    }
}
