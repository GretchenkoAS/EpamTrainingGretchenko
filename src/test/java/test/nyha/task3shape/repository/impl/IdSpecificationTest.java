package test.nyha.task3shape.repository.impl;

import com.nyha.task3shape.action.impl.EllipseServiceImpl;
import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.impl.IdSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IdSpecificationTest {
    @Test
    public void IdSpecificationPositiveTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(5, 5),
                new CustomPoint2d(10, 1)
        );
        boolean result = new IdSpecification(1).specify(ellipse);
        assertTrue(result);
    }

    @Test
    public void IdSpecificationNegativeTest() {
        Ellipse ellipse = new Ellipse(
                new CustomPoint2d(5, 5),
                new CustomPoint2d(10, 1)
        );
        boolean result = new IdSpecification(-1).specify(ellipse);
        assertFalse(result);
    }
}
