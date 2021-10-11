package com.alpha.peoplesbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {
    private String name;
    private String date;
    private String amount;
    private int status;
}
