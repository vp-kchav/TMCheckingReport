package mum.edu.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudentIdValidaor.class)
public @interface DuplicatedStudentId {

	String message() default " This student ID already in used";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};

}
