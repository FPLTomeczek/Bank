package pl.javaskills.creditapp.core.model;

public enum MaritalStatus {
    SINGLE(0),
    MARRIED(100),
    DIVORCED(0),
    WIDOWED(0),
    SEPARATED(100);

    private int value;
    MaritalStatus(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
