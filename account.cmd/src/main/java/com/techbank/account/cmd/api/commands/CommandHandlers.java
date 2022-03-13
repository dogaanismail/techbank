package com.techbank.account.cmd.api.commands;

public interface CommandHandlers {
    void handle(OpenAccountCommand command);
    void handle(DepositFundsCommand command);
    void handle(WithDrawFundsCommand command);
    void handle(CloseAccountCommand command);
}
