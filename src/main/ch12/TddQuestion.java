package main.ch12;

public abstract class TddQuestion {
    private String text;
    private String[] answerChoices;
    private int id;

    public TddQuestion(int id, String text, String[] answerChoices) {
        this.id = id;
        this.text = text;
        this.answerChoices = answerChoices;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAnswerChoice(int i) {
        return answerChoices[i];
    }

    public boolean match(TddAnswer answer) {
        return false;
    }

    abstract public boolean match(int expected, int actual);

    public int indexOf(String matchingAnswerChoice) {
        for (int i = 0; i < answerChoices.length; i++)
            if (answerChoices[i].equals(matchingAnswerChoice))
                return i;
        return -1;
    }
}
