package by.tkach.currencyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class CurrencyDataForm {
    private Set<String> currencyCountries;
}
