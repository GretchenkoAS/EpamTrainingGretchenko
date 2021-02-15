package test.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.impl.ellipse.PerimeterBetweenEllipseSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PerimeterBetweenEllipseSpecificationTest {
    @Test
    public void PerimeterBetweenEllipseSpecificationPositiveTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new PerimeterBetweenEllipseSpecification(1,8).specify(ellipse);
        assertTrue(result);
    }

    @Test
    public void PerimeterBetweenEllipseSpecificationNegativeTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new PerimeterBetweenEllipseSpecification(1,2).specify(ellipse);
        assertFalse(result);
    }
}
