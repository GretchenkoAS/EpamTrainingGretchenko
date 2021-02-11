package test.nyha.task3shape.parser;

import com.nyha.task3shape.exeption.ShapeException;
import com.nyha.task3shape.parser.EllipseParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class EllipseParserTest {
    EllipseParser ellipseParser;
    List<String> lines;

    @BeforeClass
    public void setUp() {
        ellipseParser = new EllipseParser();
        lines = new ArrayList<>();
        lines.add("Ellipse: 5 -2 7 -9");
        lines.add("Triangle: 12 1 7");
        lines.add("Ellipse: 0.0 0.0");
        lines.add("Ellipse: 17 22 72 -19");
    }

    @AfterClass
    public void tearDown() {
        ellipseParser = null;
        lines = null;
    }

    @Test
    public void parseLineToEllipsePositiveTest() throws ShapeException {
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(-2);
        list1.add(7);
        list1.add(-9);
        expected.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(17);
        list2.add(22);
        list2.add(72);
        list2.add(-19);
        expected.add(list2);
        List<List<Integer>> actual = ellipseParser.parseLineToEllipse(lines);
        assertEquals(expected, actual);
    }

    @Test
    public void parseLineToEllipseNegativeTest() throws ShapeException {
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(-2);
        list1.add(4);
        list1.add(-9);
        expected.add(list1);
        List<List<Integer>> actual = ellipseParser.parseLineToEllipse(lines);
        assertNotEquals(expected, actual);
    }
}
