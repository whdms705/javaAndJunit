package main.ch12;

public class TddCriterion implements TddScoreable{
    private TddWeight weight;
    private TddAnswer answer;
    private int score;

    public TddCriterion(TddAnswer answer, TddWeight weight) {
        this.answer = answer;
        this.weight = weight;
    }

    public TddAnswer getAnswer() { return answer; }
    public TddWeight getWeight() { return weight; }

    public void setScore(int score) { this.score = score; }
    public int getScore() { return score; }

    public boolean matches(TddAnswer answer) {
        return getWeight() == TddWeight.DontCare ||
                answer.match(getAnswer());
    }
}
