package test;

import main.ScoreCollection;
import org.junit.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ScoreCollectionTest {
    @Test
    public void answersArithmeticMeanOfTwoNumbers() {
        // Arrange
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // Act
        int actualResult = collection.arithmeticMean();

        // Assert
        assertThat(actualResult, equalTo(5));
    }
}
