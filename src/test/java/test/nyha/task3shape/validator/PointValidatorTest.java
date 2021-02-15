package test.nyha.task3shape.validator;

import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.validator.PointValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PointValidatorTest {
    PointValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new PointValidator();
    }

    @AfterClass
    public void tearDown() {
        validator = null;
    }

    @Test
    public void isPointsFromEllipsePositiveTest() {
        CustomPoint2d beginPoint = new CustomPoint2d(1,1);
        CustomPoint2d endPoint = new CustomPoint2d(2,2);
        boolean result = validator.isPointsFromEllipse(beginPoint, endPoint);
        assertTrue(result);
    }

    @Test
    public void isPointsFromEllipseNegativeTest() {
        CustomPoint2d beginPoint = new CustomPoint2d(1,1);
        CustomPoint2d endPoint = new CustomPoint2d(1,2);
        boolean result = validator.isPointsFromEllipse(beginPoint, endPoint);
        assertFalse(result);
    }
}
