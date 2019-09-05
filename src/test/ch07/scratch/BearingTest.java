package test.ch07.scratch;

import main.ch05.iloveyouboss.domain.BearingOutOfRangeException;
import main.ch07.scratch.Bearing;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BearingTest {

    Bearing bearing = null;

    @Before
    public void Bearing_초기세팅(){
        new Bearing(10);
    }

    //@Test(expected=BearingOutOfRangeException.class)
    @Test(expected=NullPointerException.class)
    public void throwsOnNegativeNumber() {
        new Bearing(-1);
    }

    @Test(expected=BearingOutOfRangeException.class)
    public void throwsWhenBearingTooLarge() {
        new Bearing(Bearing.MAX + 1);
    }

    @Test
    public void answersValidBearing() {
        assertThat(new Bearing(Bearing.MAX).value(), equalTo(Bearing.MAX));
    }

    @Test
    public void answersAngleBetweenItAndAnotherBearing() {
        assertThat(new Bearing(15).angleBetween(new Bearing(12)), equalTo(3));
    }

    @Test
    public void angleBetweenIsNegativeWhenThisBearingSmaller() {
        assertThat(new Bearing(12).angleBetween(new Bearing(15)), equalTo(-3));
    }

    @Test
    public void angleBetween값이_양수인지(){
        Bearing bearing2 = new Bearing(200);
        bearing.angleBetween(bearing2);
        assertTrue(bearing.angleBetween(bearing2) >= 0);

    }
}
