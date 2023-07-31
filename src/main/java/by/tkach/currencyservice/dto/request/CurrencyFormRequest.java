package by.tkach.currencyservice.dto.request;

import by.tkach.currencyservice.validation.currencyDate.DateRange;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@DateRange(startDateField = "startDate", endDateField = "endDate", message = "Start date can't be after second date")
public class CurrencyFormRequest {
    @NotEmpty(message = "Name of currency country can't be empty")
    private String countryName;

    @NotNull(message = "Date can't empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "Date can't empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
