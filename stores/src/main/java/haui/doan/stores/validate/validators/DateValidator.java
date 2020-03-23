package haui.doan.stores.validate.validators;

import haui.doan.stores.validate.annotations.DatePattern;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements ConstraintValidator<DatePattern, String> {

    String datePattern;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        value = StringUtils.trimToEmpty(value);
        if (StringUtils.isBlank(value)) {
            return true;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            try {
                Date date = sdf.parse(value);
                return true;
            } catch (ParseException e) {
                //ignore
                return false;
            }
        }
    }

    @Override
    public void initialize(DatePattern constraintAnnotation) {
        datePattern = constraintAnnotation.datePattern();
    }
}
