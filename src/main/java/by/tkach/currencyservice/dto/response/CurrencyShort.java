package by.tkach.currencyservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CurrencyShort {

    @JsonProperty("Cur_ID")
    private Long cur_ID;

    @JsonProperty("Date")
    private LocalDate date;

    @JsonProperty("Cur_OfficialRate")
    private Double Cur_OfficialRate;
}
