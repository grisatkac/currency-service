package by.tkach.currencyservice.repository.currency;

import by.tkach.currencyservice.dto.Currency;
import by.tkach.currencyservice.dto.response.CurrencyShort;
import by.tkach.currencyservice.utils.CurrencyUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
@AllArgsConstructor
public class CurrencyRepositoryImpl implements CurrencyRepository {

    public final RestTemplate restTemplate;

    @Override
    public List<Currency> getAll() {
        return Arrays.asList(restTemplate.getForObject(CurrencyUtil.URI_CURRENCY_LIST, Currency[].class));
    }

    @Override
    public List<CurrencyShort> getCurrencyDynamics(Long curId, LocalDate startDate, LocalDate endDate) {
        List<CurrencyShort> currencies = Arrays.asList(restTemplate.getForObject(
                String.format(CurrencyUtil.URI_DYNAMICS_CURRENCY, curId, startDate, endDate),
                CurrencyShort[].class));
        return currencies;
    }
}
