package test.nyha.task2xml.builder;

import com.nyha.task2xml.entity.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

class PaperData {
    private static Set<Paper> papers;

    static {
        papers = new HashSet<>();
    }

    private PaperData() {
    }

    public static Set<Paper> getPapers() {

        ArtPaper paper1 = new ArtPaper();
        paper1.setId("a1");
        paper1.setLanguage("eng");
        paper1.setTitle("Shrek");
        paper1.setType(PaperType.MAGAZINE);
        paper1.setReleaseDate(LocalDate.parse("2015-01-01"));
        paper1.setMonthly(true);
        Chars chars1 = new Chars();
        chars1.setColored(true);
        chars1.setPages(14);
        chars1.setGlossy(true);
        chars1.setSubscribeIndex(83472);
        paper1.setChars(chars1);
        paper1.setAssigment(Assigment.FOR_KIDS);
        papers.add(paper1);

        SciencePaper paper2 = new SciencePaper();
        paper2.setId("s1");
        paper2.setLanguage("rus");
        paper2.setTitle("Квант");
        paper2.setType(PaperType.MAGAZINE);
        paper2.setReleaseDate(LocalDate.parse("1970-02-23"));
        paper2.setMonthly(true);
        Chars chars2 = new Chars();
        chars2.setColored(true);
        chars2.setPages(24);
        chars2.setGlossy(true);
        chars2.setSubscribeIndex(34738);
        paper2.setChars(chars2);
        paper2.setAttestationOrganization("ВАК");
        papers.add(paper2);

        return papers;
    }
}
