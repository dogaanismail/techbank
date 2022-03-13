package com.tachbank.account.cmd.api.commands;

import com.tachbank.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class WithDrawFundsCommand extends BaseCommand {
    private double amount;
}
