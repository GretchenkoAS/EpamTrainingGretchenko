package test.nyha.task2xml.builder;

import com.nyha.task2xml.builder.AbstractPapersBuilder;
import com.nyha.task2xml.entity.Paper;
import com.nyha.task2xml.exeption.ParserException;
import com.nyha.task2xml.factory.PaperBuilderFactory;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class PapersStaxBuilderTest {
    @Test
    public void buildPlanesPositiveTest() throws ParserException {
        String type = "stax";
        AbstractPapersBuilder builder = PaperBuilderFactory.createPaperBuilder(type);
        builder.buildSetPapers("src/test/resources/periodicalTest.xml");
        Set<Paper> actual = builder.getPapers();
        Set<Paper> expected = PaperData.getPapers();
        assertEquals(actual, expected);
    }

    @Test
    public void buildPlanesNegativeTest() throws ParserException {
        String type = "stax";
        AbstractPapersBuilder builder = PaperBuilderFactory.createPaperBuilder(type);
        builder.buildSetPapers("src/test/resources/periodicalTest.xml");
        Set<Paper> actual = builder.getPapers();
        Set<Paper> expected = new HashSet<>();
        assertNotEquals(actual, expected);
    }
}
