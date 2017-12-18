package mum.edu.domain;

import org.springframework.core.convert.converter.Converter;

public class StringToEGenderConverter implements Converter<String,Gender>{

	@Override
	public Gender convert(String source) {
		// TODO Auto-generated method stub
		String value=source.trim();
		if("MALE".equalsIgnoreCase(value)) {
			return Gender.MALE;
		}
		return Gender.FEMALE;
	}

	

}
