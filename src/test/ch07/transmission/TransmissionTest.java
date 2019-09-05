package test.ch07.transmission;

import main.ch07.transmission.Car;
import main.ch07.transmission.Gear;
import main.ch07.transmission.Transmission;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TransmissionTest {
    private Transmission transmission;
    private Car car;

    @Before
    public void create(){
        car = new Car();
        transmission = new Transmission(car);
    }

    @Test
    public void 시동을키고_기어가_DRIVE인지() {
        transmission.shift(Gear.DRIVE);
        car.accelerateTo(35);
        assertThat(transmission.getGear(),equalTo(Gear.DRIVE));
    }

    @Test
    public void 차가정지하지않고_기어를_PARK으로_변경하는경우(){
        transmission.shift(Gear.DRIVE);
        car.accelerateTo(80);

        transmission.shift(Gear.PARK);
        assertThat(transmission.getGear(),equalTo(Gear.DRIVE));
    }

    @Test
    public void 차를_정지하고자_기어를_PARK으로_변경하는경우(){
        transmission.shift(Gear.DRIVE);
        car.accelerateTo(80);

        car.brakeToStop();
        transmission.shift(Gear.PARK);
        assertThat(transmission.getGear(),equalTo(Gear.PARK));
    }

    @Test
    public void 차를_정지하고자_기어를_PARK으로_변경하는경우_기어가_DRIVE면(){
        transmission.shift(Gear.DRIVE);
        car.accelerateTo(80);

        car.brakeToStop();
        transmission.shift(Gear.PARK);
        assertThat(transmission.getGear(),equalTo(Gear.DRIVE));
    }

}
