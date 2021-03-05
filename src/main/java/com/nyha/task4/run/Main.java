package com.nyha.task4.run;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.exception.CustomException;
import com.nyha.task4.parser.TextParser;
import com.nyha.task4.reader.CustomFileReader;
import com.nyha.task4.service.CompositeService;
import com.nyha.task4.service.impl.CompositeServiceImpl;

public class Main {
    public static void main(String[] args) throws CustomException {
        CustomFileReader reader = new CustomFileReader();
        TextParser parser = new TextParser();
        CompositeText compositeText = parser.parse(reader.read("data/data.txt"));
        CompositeService service = new CompositeServiceImpl();
        System.out.println(service.findNumberOfVowels(compositeText));
        System.out.println(service.findNumberOfConsonants(compositeText));

//        service.removeSentencesBySpecificValue(compositeText, 30);
//        int i = 0;
//        System.out.println(compositeText);
//        System.out.println(compositeText.countSymbol());
    }
}
