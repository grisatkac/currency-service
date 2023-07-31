package by.tkach.currencyservice.services.impl;

import by.tkach.currencyservice.dto.Currency;
import by.tkach.currencyservice.dto.response.CurrencyShort;
import by.tkach.currencyservice.repository.currency.CurrencyRepository;
import by.tkach.currencyservice.services.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    public final CurrencyRepository currencyRepository;

    @Override
    public Set<String> getCurrencyCountries() {
        List<Currency> listOfCurrencies = currencyRepository.getAll();

        Set<String> uniqueCountries = new TreeSet<>(listOfCurrencies.stream().
                map(Currency::getCur_Name).
                collect(Collectors.toList()));

        return uniqueCountries;
    }

    @Override
    public List<CurrencyShort> getDynamicsCurrency(String curName, LocalDate startDate, LocalDate endDate) {
        List<Currency> allCurrencies = currencyRepository.getAll();
        List<Currency> currenciesByName = allCurrencies.stream()
                .filter(currency -> currency.getCur_Name().equals(curName))
                .collect(Collectors.toList());
        List<CurrencyShort> resultList = new ArrayList<>();
        LocalDate iterationDate = startDate;

        while (iterationDate.isBefore(endDate) || iterationDate.equals(endDate)) {
            for (Currency currency: currenciesByName) {
                if (iterationDate.isAfter(currency.getCur_DateEnd())) {
                    continue;
                }

                if (iterationDate.plusYears(1).isAfter(currency.getCur_DateEnd())) {
                    resultList.addAll(currencyRepository.getCurrencyDynamics(currency.getCur_ID(), iterationDate, currency.getCur_DateEnd()));
                    iterationDate = currency.getCur_DateEnd();
                } else {
                    resultList.addAll(currencyRepository.getCurrencyDynamics(currency.getCur_ID(), iterationDate, endDate));
                    iterationDate = iterationDate.plusYears(1);
                }
            }
        }

        return resultList;
    }
}
