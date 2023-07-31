package by.tkach.currencyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class DynamicsCurrency {

    private List<CurrencyShort> currencyList;
}
