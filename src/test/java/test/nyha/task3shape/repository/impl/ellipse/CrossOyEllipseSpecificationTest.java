package test.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.impl.ellipse.CrossOyEllipseSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CrossOyEllipseSpecificationTest {
    @Test
    public void CrossOyEllipseSpecificationPositiveTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(-1, 1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new CrossOyEllipseSpecification().specify(ellipse);
        assertTrue(result);
    }

    @Test
    public void CrossOyEllipseSpecificationNegativeTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(5, 5),
                new CustomPoint2d(10, 1)
        );
        boolean result = new CrossOyEllipseSpecification().specify(ellipse);
        assertFalse(result);
    }
}
