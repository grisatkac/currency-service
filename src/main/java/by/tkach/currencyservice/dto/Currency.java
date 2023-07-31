package by.tkach.currencyservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Currency {
    @JsonProperty("Cur_ID")
    private Long cur_ID;

    @JsonProperty("Cur_ParentID")
    private Long cur_ParentID;

    @JsonProperty("Cur_Code")
    private Long cur_Code;

    @JsonProperty("Cur_Abbreviation")
    private String cur_Abbreviation;

    @JsonProperty("Cur_Name")
    private String cur_Name;

    @JsonProperty("Cur_Name_Bel")
    private String cur_Name_Bel;

    @JsonProperty("Cur_Name_Eng")
    private String cur_Name_Eng;

    @JsonProperty("Cur_QuotName")
    private String cur_QuotName;

    @JsonProperty("Cur_QuotName_Bel")
    private String cur_QuotName_Bel;

    @JsonProperty("Cur_QuotName_Eng")
    private String cur_QuotName_Eng;

    @JsonProperty("Cur_NameMulti")
    private String cur_NameMulti;

    @JsonProperty("Cur_Name_BelMulti")
    private String cur_Name_BelMulti;

    @JsonProperty("Cur_Name_EngMulti")
    private String cur_Name_EngMulti;

    @JsonProperty("Cur_Scale")
    private String cur_Scale;

    @JsonProperty("Cur_Periodicity")
    private String cur_Periodicity;

    @JsonProperty("Cur_DateStart")
    private LocalDate cur_DateStart;

    @JsonProperty("Cur_DateEnd")
    private LocalDate cur_DateEnd;
}
