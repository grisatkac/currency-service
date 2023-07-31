package by.tkach.currencyservice.services;


import by.tkach.currencyservice.dto.response.CurrencyShort;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CurrencyService {

    Set<String> getCurrencyCountries();

    List<CurrencyShort> getDynamicsCurrency(String curName, LocalDate startDate, LocalDate endDate);
}
