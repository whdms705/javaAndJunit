package main.ch12;

public class TddAnswer {
    private int i;
    private TddQuestion question;

    public TddAnswer(TddQuestion question, int i) {
        this.question = question;
        this.i = i;
    }

    public TddAnswer(TddQuestion question, String matchingValue) {
        this.question = question;
        this.i = question.indexOf(matchingValue);
    }

    public String getQuestionText() {
        return question.getText();
    }

    @Override
    public String toString() {
        return String.format("%s %s", question.getText(), question.getAnswerChoice(i));
    }

    public boolean match(int expected) {
        return question.match(expected, i);
    }

    public boolean match(TddAnswer otherAnswer) {
        if(otherAnswer == null) return  false;
        return question.match(i, otherAnswer.i);
    }

    public TddQuestion getQuestion() {
        return question;
    }
}
