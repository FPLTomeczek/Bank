package pl.javaskills.creditapp.core.model;

public enum Education {
    NONE(-200),
    PRIMARY(-100),
    MIDDLE(0),
    SECONDARY(0),
    POST_SECONDARY(0),
    TERTIARY(100);

    private int value;
    Education(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
