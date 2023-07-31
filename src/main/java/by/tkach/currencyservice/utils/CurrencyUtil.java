package by.tkach.currencyservice.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class CurrencyUtil {
    public static final String URI_CURRENCY_LIST = "https://api.nbrb.by/exrates/currencies";
    public static final String URI_DYNAMICS_CURRENCY = "https://api.nbrb.by/exrates/rates/dynamics/%s?startDate=%s&endDate=%s";
}
