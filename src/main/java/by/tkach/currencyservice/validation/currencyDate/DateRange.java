package by.tkach.currencyservice.validation.currencyDate;

import org.springframework.cglib.core.Local;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.time.LocalDate;
import java.util.Date;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateRangeValidator.class)
public @interface DateRange {
    String startDateField();

    String endDateField();

    String message() default "Invalid date range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
