package test.ch07.scratch;

import main.ch07.scratch.Point;
import main.ch07.scratch.Rectangle;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static test.ch07.scratch.ConstrainsSidesTo.constrainsSidesTo;


public class RectangleTest {
    private Rectangle rectangle;


    @After
    public void ensureInvariant() {
        System.out.println(constrainsSidesTo(100));
        assertThat(rectangle, constrainsSidesTo(100));
    }

    @Test
    public void answersArea() {
        rectangle = new Rectangle(new Point(5, 5), new Point (15, 10));
        assertThat(rectangle.area(), equalTo(50));
    }

    @Ignore
    @ExpectToFail
    @Test
    public void allowsDynamicallyChangingSize() {
        rectangle = new Rectangle(new Point(5, 5));
        rectangle.setOppositeCorner(new Point(130, 130));
        assertThat(rectangle.area(), equalTo(15625));
    }
}
