package test.nyha.task3shape.validator;

import com.nyha.task3shape.validator.EllipseValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EllipseValidatorTest {
    private EllipseValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new EllipseValidator();
    }

    @AfterClass
    public void tearDown() {
        validator = null;
    }

    @Test
    public void isEllipseDataPositiveTest() {
        boolean result = validator.isEllipseData("Ellipse: 2 10 -10 -2");
        assertTrue(result);
    }

    @Test
    public void isEllipseDataNegativeTest() {
        boolean result = validator.isEllipseData("Eldlipse: 2d 10 -10 -2");
        assertFalse(result);
    }
}
