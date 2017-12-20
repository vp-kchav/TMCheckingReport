package mum.edu.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.domain.Student;
import mum.edu.service.StudentService;

public class StudentIdValidaor implements ConstraintValidator<DuplicatedStudentId, String> {

	@Autowired
	private StudentService studentService;

	@Override
	public void initialize(DuplicatedStudentId arg0) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    Student student = null;
		try {
		    student = studentService.getByStudentId(value);
		} catch (Exception e) {
			System.out.println("Couldn't find user...");
		}
		return student == null ? true : false;
	}

}
