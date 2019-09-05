package test.ch2;

import main.ch2.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void matches가_false인경우() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got bonuses?");
        Answer profileAnswer = new Answer(question, Bool.FALSE);// 기대하는 정답
        profile.add(profileAnswer);

        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }

    @Test
    public void matches가_참인경우() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got milk?");
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);

        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }


}
