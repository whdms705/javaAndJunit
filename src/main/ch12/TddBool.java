package main.ch12;

public enum TddBool {
    False(0),
    True(1);
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    private int value;
    private TddBool(int value) { this.value = value; }
    public int getValue() { return value; }
}
