package test.ch07;

import main.ch07.*;

import static org.junit.Assert.*;
import java.util.*;

import main.ch2.Bool;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;

// CORECT : Ordering(순서)

public class ProfilePoolTest {
    private ProfilePool pool;
    private Profile langrsoft;
    private Profile smeltInc;
    private BooleanQuestion doTheyReimburseTuition;

    @Before
    public void create() {
        pool = new ProfilePool();
        langrsoft = new Profile("Langrsoft");
        smeltInc = new Profile("Smelt Inc.");
        doTheyReimburseTuition = new BooleanQuestion(1, "Reimburses tuition?");
    }

    @Test
    public void scoresProfileInPool() {
        langrsoft.add(new Answer(doTheyReimburseTuition, Bool.TRUE));
        pool.add(langrsoft);

        pool.score(soleNeed(doTheyReimburseTuition, Bool.TRUE, Weight.Important));

        assertThat(langrsoft.score(), equalTo(Weight.Important.getValue()));
    }

    private Criteria soleNeed(Question question, int value, Weight weight) {
        Criteria criteria = new Criteria();
        criteria.add(new Criterion(new Answer(question, value), weight));
        return criteria;
    }


    @Ignore
    @Test
    public void answersResultsInScoredOrder() {
        smeltInc.add(new Answer(doTheyReimburseTuition, Bool.FALSE));
        pool.add(smeltInc);
        langrsoft.add(new Answer(doTheyReimburseTuition, Bool.TRUE));
        pool.add(langrsoft);

        pool.score(soleNeed(doTheyReimburseTuition, Bool.TRUE, Weight.Important));
        List<Profile> ranked = pool.ranked();

        assertThat(ranked.toArray(), equalTo(new Profile[]{ langrsoft,smeltInc }));
    }
}
