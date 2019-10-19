package main.ch12;

import java.util.*;

public class TddProfile {
    //private TddAnswer answer;

    //다수의 응답을 등록
    public Map<String,TddAnswer> answers = new HashMap<>();

    public TddAnswer getMatchingProfileAnswer(TddCriterion criterion) {
        return answers.get(criterion.getAnswer().getQuestionText());
    }

    public boolean mathces(TddCriterion criterion){
        //return false;
        TddAnswer answer = getMatchingProfileAnswer(criterion);
        return answer.match(criterion.getAnswer());
    }

    public void add(TddAnswer answer){
        //this.answer = answer;

        // 다수의 응답을 추가할 수 있게
        answers.put(answer.getQuestionText(), answer);
    }
}
