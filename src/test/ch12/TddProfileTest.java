package test.ch12;

import main.ch12.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TddProfileTest {

    TddProfile profile = null;
    TddQuestion question = null;
    TddAnswer answer = null;

    @Before
    public void ProfileBefore(){
        profile = new TddProfile();
    }

    @Before
    public void 질문과답변_설정(){
        question = new TddBooleanQuestion(1,"Relocation package?");

        answer = new TddAnswer(question, TddBool.TRUE);
    }


    @Test
    public void Profile이_텅빈경우_매칭이되면안되는_테스트() {

       TddCriterion criterion = new TddCriterion(answer,TddWeight.DontCare);

       boolean result = profile.mathces(criterion);

       assertFalse(result);

    }

    @Test
    public void 프로파일에_매칭되는_답변이_포함된경우(){
        profile.add(answer);
        TddCriterion criterion = new TddCriterion(answer,TddWeight.Important);

        boolean result = profile.mathces(criterion);
        //assertFalse(result);
    }

    /*
    테스트가 통과하려면 matches()메서드는 Profile객체가 들고 있는 단일 Answer객체가 Criterion객체에
    저장된 응답과 매칭되는지 정해야 합니다.
     */
    @Test
    public void Profile인스턴스가_매칭되는_Answer객체가없는경우(){
        TddAnswer answerThereIsNot = new TddAnswer(question,TddBool.FALSE);
        profile.add(answerThereIsNot);

        TddCriterion criterion = new TddCriterion(answer,TddWeight.Important);

        boolean result = profile.mathces(criterion);

        assertFalse(result);
    }

}
