package main.ch12;

public class TddBooleanQuestion extends TddQuestion {
    public TddBooleanQuestion(int id, String text) {
        super(id, text, new String[] { "No", "Yes" });
    }

    @Override
    public boolean match(int expected, int actual) {

        return expected == actual;
    }
}
