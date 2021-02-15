package test.nyha.task3shape.repository;

import com.nyha.task3shape.comparator.EllipseComparatorType;
import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.Shape;
import com.nyha.task3shape.repository.ShapeRepository;
import com.nyha.task3shape.repository.Specification;
import com.nyha.task3shape.repository.impl.IdSpecification;
import com.nyha.task3shape.repository.impl.ellipse.FirstQuadrantEllipseSpecification;
import com.nyha.task3shape.repository.impl.ellipse.PerimeterBetweenEllipseSpecification;
import com.nyha.task3shape.repository.impl.ellipse.SquareBetweenEllipseSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ShapeRepositoryTest {
    private ShapeRepository repository;
    @BeforeClass
    public void setUp() {
        repository = new ShapeRepository();
        repository.addShape(new Ellipse(new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)));
        repository.addShape(new Ellipse(new CustomPoint2d(-1, -1),
                new CustomPoint2d(2, 2)));
        repository.addShape(new Ellipse(new CustomPoint2d(10, 10),
                new CustomPoint2d(20, 20)));
        repository.addShape(new Ellipse(new CustomPoint2d(-1, 1),
                new CustomPoint2d(3, -3)));
    }

    @AfterClass
    public void tearDown() {
        repository = null;
    }

    @DataProvider(name = "dataSpecificationAndResultValid")
    public Object[][] createDataSpecificationValid() {
        List<Ellipse> quadrantSpecification = new ArrayList<>();
        Ellipse ellipse1 = new Ellipse(new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2));
        quadrantSpecification.add(ellipse1);
        Ellipse ellipse2 = new Ellipse(new CustomPoint2d(10, 10),
                new CustomPoint2d(20, 20));
        quadrantSpecification.add(ellipse2);

        List<Ellipse> idSpecification = new ArrayList<>();
        idSpecification.add(ellipse1);

        List<Ellipse> perimeterSpecification = new ArrayList<>();
        perimeterSpecification.add(ellipse1);

        List<Ellipse> squareSpecification = new ArrayList<>();
        squareSpecification.add(ellipse1);

        return new Object[][]{
                {new FirstQuadrantEllipseSpecification(), quadrantSpecification},
                {new IdSpecification(1), idSpecification},
                {new PerimeterBetweenEllipseSpecification(3, 3.2), perimeterSpecification},
                {new SquareBetweenEllipseSpecification(0.5, 0.8), squareSpecification},
        };
    }

    @DataProvider(name = "dataSpecificationAndResultInvalid")
    public Object[][] createDataSpecificationInvalid() {
        List<Ellipse> quadrantSpecification = new ArrayList<>();
        Ellipse ellipse1 = new Ellipse(new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2));
        quadrantSpecification.add(ellipse1);

        Ellipse ellipse2 = new Ellipse(new CustomPoint2d(10, 10),
                new CustomPoint2d(20, 20));

        List<Ellipse> idSpecification = new ArrayList<>();
        idSpecification.add(ellipse1);
        idSpecification.add(ellipse2);

        List<Ellipse> perimeterSpecification = new ArrayList<>();
        perimeterSpecification.add(ellipse1);
        perimeterSpecification.add(ellipse2);

        List<Ellipse> squareSpecification = new ArrayList<>();
        squareSpecification.add(ellipse1);
        squareSpecification.add(ellipse2);

        return new Object[][]{
                {new FirstQuadrantEllipseSpecification(), quadrantSpecification},
                {new IdSpecification(2), idSpecification},
                {new PerimeterBetweenEllipseSpecification(3, 3.2), perimeterSpecification},
                {new SquareBetweenEllipseSpecification(0.5, 0.8), squareSpecification},
        };
    }

    @Test(dataProvider = "dataSpecificationAndResultValid")
    public void queryTestValid(Specification specification, List<Ellipse> expected) {
        List<Ellipse> actual;
        actual = repository.query(specification);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataSpecificationAndResultInvalid")
    public void queryTestInvalid(Specification specification, List<Ellipse> expected) {
        List<Ellipse> actual;
        actual = repository.query(specification);
        assertNotEquals(expected, actual);
    }

    @Test
    public void sortPositiveTest() {
        List<Shape> expected = new ArrayList<>();
        expected.add(new Ellipse(new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)));
        expected.add(new Ellipse(new CustomPoint2d(-1, -1),
                new CustomPoint2d(2, 2)));
        expected.add(new Ellipse(new CustomPoint2d(-1, 1),
                new CustomPoint2d(3, -3)));
        expected.add(new Ellipse(new CustomPoint2d(10, 10),
                new CustomPoint2d(20, 20)));
        Comparator<Shape> comparator = EllipseComparatorType.PERIMETER.getComparator();
        List<Shape> actual = repository.sort(comparator);
        assertEquals(expected, actual);
    }

    @Test
    public void sortNegativeTest() {
        List<Shape> expected = new ArrayList<>();
        expected.add(new Ellipse(new CustomPoint2d(1, 1),
                new CustomPoint2d(2, 2)));
        expected.add(new Ellipse(new CustomPoint2d(-1, -1),
                new CustomPoint2d(2, 2)));
        expected.add(new Ellipse(new CustomPoint2d(-1, 1),
                new CustomPoint2d(3, -3)));
        expected.add(new Ellipse(new CustomPoint2d(10, 10),
                new CustomPoint2d(20, 20)));
        Comparator<Shape> comparator = EllipseComparatorType.ID.getComparator();
        List<Shape> actual = repository.sort(comparator);
        assertNotEquals(expected, actual);
    }

}
