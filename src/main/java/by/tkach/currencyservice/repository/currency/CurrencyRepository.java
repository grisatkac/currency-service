package by.tkach.currencyservice.repository.currency;

import by.tkach.currencyservice.dto.Currency;
import by.tkach.currencyservice.dto.response.CurrencyShort;
import by.tkach.currencyservice.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency> {

    List<CurrencyShort> getCurrencyDynamics(Long Id, LocalDate startDate, LocalDate endDate);
}
