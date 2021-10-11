package com.alpha.peoplesbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillPayment {

    private String name;
    private String date;
    private String amount;


}
