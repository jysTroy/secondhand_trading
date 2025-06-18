package org.koreait.survey.diabetes.constants;

public enum SmokingHistory {
    NO_INFO(0), // 정보 없음
    CURRENT(1), // 현재 흡연 중
    EVER(2), // 항상 흡연 중
    FORMER(3), // 과거 피웠지만 현재 안핌
    NEVER(4), // 흡연 경험 없음
    NOT_CURRENT(5); // 현재 안핌

    private final int num;

    SmokingHistory(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
