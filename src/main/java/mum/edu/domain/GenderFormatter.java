package mum.edu.domain;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class GenderFormatter implements Formatter<Gender> {
    @Override
    public Gender parse(String s, Locale locale) throws ParseException {
        if (Gender.MALE.value().equals(s)){
            return Gender.MALE;
        }else if(Gender.FEMALE.value().equals(s)){
            return Gender.FEMALE;
        }
        throw  new IllegalArgumentException("Invalid gender format. Please use M or F");
    }

    @Override
    public String print(Gender gender, Locale locale) {
        return gender.value();
    }
}
