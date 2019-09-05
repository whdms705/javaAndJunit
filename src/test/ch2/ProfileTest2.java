package test.ch2;

import main.ch2.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ProfileTest2 {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create() {
        profile = new Profile("Bull Hockey, Inc.");
        System.out.println("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(
                new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        boolean matches = profile.matches(criteria);

        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(
                new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }

    @Test
    public void answer객체가_null인경우(){
        criteria.add(
                new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
        boolean matches = profile.matches(criteria);

        assertFalse(matches);
    }

    @Test
    public void criterion_getAnswer혹은_criterion_getAnswer_getQuestion_text의_반환값이_NULL인_테스트(){
        criteria.add(
                new Criterion(null, Weight.DontCare));
        boolean matches = profile.matches(criteria);

        assertFalse(matches);
    }
}
