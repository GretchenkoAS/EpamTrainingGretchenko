package test.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.impl.ellipse.CrossOxEllipseSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CrossOxEllipseSpecificationTest {
    @Test
    public void CrossOxEllipseSpecificationPositiveTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(1, -1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new CrossOxEllipseSpecification().specify(ellipse);
        assertTrue(result);
    }

    @Test
    public void CrossOxEllipseSpecificationNegativeTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(5, 5),
                new CustomPoint2d(10, 1)
        );
        boolean result = new CrossOxEllipseSpecification().specify(ellipse);
        assertFalse(result);
    }
}
