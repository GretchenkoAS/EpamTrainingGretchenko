package test.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.impl.ellipse.FirstQuadrantEllipseSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FirstQuadrantEllipseSpecificationTest {
    @Test
    public void FirstQuadrantEllipseSpecificationPositiveTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new FirstQuadrantEllipseSpecification().specify(ellipse);
        assertTrue(result);
    }

    @Test
    public void FirstQuadrantEllipseSpecificationNegativeTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(-1, 1),
                new CustomPoint2d(2, 2)
        );
        boolean result = new FirstQuadrantEllipseSpecification().specify(ellipse);
        assertFalse(result);
    }
}