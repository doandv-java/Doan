package haui.doan.stores.validate.annotations;

import haui.doan.stores.framework.Constants;
import haui.doan.stores.validate.validators.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {DateValidator.class})
@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface DatePattern {

    String datePattern() default Constants.DATE_FORMAT.YYYY_MM_DD;

    String message() default "must have date in pattern {datePattern}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
