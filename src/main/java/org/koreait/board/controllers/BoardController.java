package org.koreait.board.controllers;

import lombok.RequiredArgsConstructor;
import org.koreait.global.annotations.ApplyCommonController;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ApplyCommonController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final Utils utils;

    @GetMapping("/list/{bid}")
    public String list(@PathVariable("bid") String bid, Model model) {
        return utils.tpl("board/list");
    }

    @GetMapping("/write/{bid}")
    public String write(@PathVariable("bid") String bid, Model model) {

        return utils.tpl("board/write");
    }

    public void commonProcess() {

    }
}
