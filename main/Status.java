package main;

// 用于标识每一个Label 所呈现的图片
public enum Status {
    NONE(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    BUTTON(9), FLAG(10), BOOM(11), DOUBT(12), FAILED(13), FAILFLAG(14), PROMPT(15);

    private final int value;

    Status(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static Status getStatus(int v) {
        return Status.values()[v];
    }
}
