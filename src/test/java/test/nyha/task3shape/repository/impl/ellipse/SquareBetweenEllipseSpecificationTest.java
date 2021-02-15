package test.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.impl.ellipse.SquareBetweenEllipseSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SquareBetweenEllipseSpecificationTest {
    @Test
    public void SquareBetweenEllipseSpecificationPositiveTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new SquareBetweenEllipseSpecification(0,1).specify(ellipse);
        assertTrue(result);
    }

    @Test
    public void SquareBetweenEllipseSpecificationNegativeTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new SquareBetweenEllipseSpecification(1,2).specify(ellipse);
        assertFalse(result);
    }
}
