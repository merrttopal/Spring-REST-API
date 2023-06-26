package com.works.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class XmlCurrency {


    private String currencyName;
    private String forexBuying;
    private String forexSelling;
    private String banknoteBuying;
    private String banknoteSelling;

}
