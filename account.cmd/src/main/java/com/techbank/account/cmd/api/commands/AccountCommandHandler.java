package com.techbank.account.cmd.api.commands;

import com.techbank.account.cmd.domain.AccountAggregate;
import com.techbank.cqrs.core.handlers.EventSourcingHandlers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandHandler implements CommandHandlers{
    @Autowired
    private EventSourcingHandlers<AccountAggregate> eventSourcingHandlers;

    @Override
    public void handle(OpenAccountCommand command) {
        var aggregate = new AccountAggregate(command);
        eventSourcingHandlers.save(aggregate);
    }

    @Override
    public void handle(DepositFundsCommand command) {
        var aggregate = eventSourcingHandlers.getById(command.getId());
        aggregate.depositFunds(command.getAmount());
        eventSourcingHandlers.save(aggregate);
    }

    @Override
    public void handle(WithDrawFundsCommand command) {
        var aggregate = eventSourcingHandlers.getById(command.getId());
        if(command.getAmount() > aggregate.getBalance()){
            throw new IllegalStateException("Withdrawal declined, insufficient funds!");
        }

        aggregate.withDrawFunds(command.getAmount());
        eventSourcingHandlers.save(aggregate);
    }

    @Override
    public void handle(CloseAccountCommand command) {
        var aggregate = eventSourcingHandlers.getById(command.getId());
        aggregate.closeAccount();
        eventSourcingHandlers.save((aggregate));
    }
}
