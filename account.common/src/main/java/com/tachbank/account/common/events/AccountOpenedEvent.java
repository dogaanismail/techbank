package com.tachbank.account.common.events;

import com.tachbank.account.common.dto.AccountType;
import com.tachbank.cqrs.core.events.BaseEvent;

import java.util.Date;

public class AccountOpenedEvent extends BaseEvent {
    private String accountHolder;
    private AccountType accountType;
    private Date createdDate;
    private double openingBalance;
}
