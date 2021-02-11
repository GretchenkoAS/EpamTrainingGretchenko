package test.nyha.task3shape.service;

import com.nyha.task3shape.action.impl.EllipseServiceImpl;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.Point2d;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseServiceImplTest {
    EllipseServiceImpl service;

    @BeforeClass
    public void setUp() {
        service = new EllipseServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        service = null;
    }

    @Test
    public void calculatePerimeterPositiveTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        double expected = 25.13274122;
        double actual = service.calculatePerimeter(ellipse);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void calculatePerimeterNegativeTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        double expected = 22;
        double actual = service.calculatePerimeter(ellipse);
        assertNotEquals(expected, actual, 0.00001);
    }

    @Test
    public void calculateSquarePositiveTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        double expected = 50.265482457;
        double actual = service.calculateSquare(ellipse);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void calculateSquareNegativeTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        double expected = 22;
        double actual = service.calculateSquare(ellipse);
        assertNotEquals(expected, actual, 0.00001);
    }

    @Test
    public void isCrossOxPositiveTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, -2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean result = service.isCrossOx(ellipse);
        assertTrue(result);
    }

    @Test
    public void isCrossOxNegativeTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean result = service.isCrossOx(ellipse);
        assertFalse(result);
    }

    @Test
    public void isCrossOyPositiveTest() {
        Point2d begin = new Point2d(-2, 10);
        Point2d end = new Point2d(10, -2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean result = service.isCrossOy(ellipse);
        assertTrue(result);
    }

    @Test
    public void isCrossOyNegativeTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean result = service.isCrossOy(ellipse);
        assertFalse(result);
    }

    @Test
    public void isCirclePositiveTest() {
        Point2d begin = new Point2d(2, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean result = service.isCircle(ellipse);
        assertTrue(result);
    }

    @Test
    public void isCircleNegativeTest() {
        Point2d begin = new Point2d(3, 10);
        Point2d end = new Point2d(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean result = service.isCircle(ellipse);
        assertFalse(result);
    }
}
