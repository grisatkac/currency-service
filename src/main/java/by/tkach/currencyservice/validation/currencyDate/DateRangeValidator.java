package by.tkach.currencyservice.validation.currencyDate;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Date;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String startDateField;
    private String endDateField;


    @Override
    public void initialize(DateRange constraintAnnotation) {
        startDateField = constraintAnnotation.startDateField();
        endDateField = constraintAnnotation.endDateField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
            LocalDate startDate = (LocalDate) beanWrapper.getPropertyValue(startDateField);
            LocalDate endDate = (LocalDate) beanWrapper.getPropertyValue(endDateField);
            boolean isValid = startDate == null || endDate == null || !startDate.isAfter(endDate);
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode( "startDate" ).addConstraintViolation();
            return isValid;
        } catch (Exception e) {
            return false;
        }
    }
}
