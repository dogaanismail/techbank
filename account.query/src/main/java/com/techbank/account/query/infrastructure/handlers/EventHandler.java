package com.techbank.account.query.infrastructure.handlers;

import com.techbank.account.common.events.AccountCloseEvent;
import com.techbank.account.common.events.AccountOpenedEvent;
import com.techbank.account.common.events.FundsDepositedEvent;
import com.techbank.account.common.events.FundsWithDrawnEvent;

public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithDrawnEvent event);
    void on(AccountCloseEvent event);
}
