package by.tkach.currencyservice.controllers;

import by.tkach.currencyservice.dto.response.CurrencyShort;
import by.tkach.currencyservice.dto.response.DynamicsCurrency;
import by.tkach.currencyservice.dto.request.CurrencyFormRequest;
import by.tkach.currencyservice.dto.response.CurrencyDataForm;
import by.tkach.currencyservice.services.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/currency")
@AllArgsConstructor
public class CurrencyController {

    public final CurrencyService currencyService;

    @ModelAttribute("currencyForm")
    public CurrencyFormRequest getCurrencyFormRequest() {
        return CurrencyFormRequest.builder().build();
    }

    @GetMapping
    public String getCurrencyPage(Model model) {
        Set<String> currencyCountries = currencyService.getCurrencyCountries();
        CurrencyDataForm currencyDataForm = CurrencyDataForm.builder().currencyCountries(currencyCountries).build();
        model.addAttribute("data", currencyDataForm);
        return "currency";
    }

    @PostMapping("/byPeriod")
    public String getCurrencyByPeriod(@ModelAttribute("currencyForm")  @Valid CurrencyFormRequest currencyFormRequest,
                                      BindingResult bindingResult,
                                      Model model) {
        System.out.println("Request here");

        if (bindingResult.hasErrors()) {
            Set<String> currencyCountries = currencyService.getCurrencyCountries();
            CurrencyDataForm currencyDataForm = CurrencyDataForm.builder().currencyCountries(currencyCountries).build();
            model.addAttribute("data", currencyDataForm);
            return "currency";
        }
        List<CurrencyShort> dynamicsCurrency = currencyService
                .getDynamicsCurrency(currencyFormRequest.getCountryName(),
                        currencyFormRequest.getStartDate(),
                        currencyFormRequest.getEndDate());

        Set<String> currencyCountries = currencyService.getCurrencyCountries();
        CurrencyDataForm currencyDataForm = CurrencyDataForm.builder().currencyCountries(currencyCountries).build();

        model.addAttribute("currencyForm", currencyFormRequest);
        model.addAttribute("data", currencyDataForm);
        model.addAttribute("dynamicsCurrency", DynamicsCurrency.builder()
                .currencyList(dynamicsCurrency)
                .build());
        return "currency";
    }
}
