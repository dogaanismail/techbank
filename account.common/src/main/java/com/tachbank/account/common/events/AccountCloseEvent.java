package com.tachbank.account.common.events;

import com.tachbank.cqrs.core.events.BaseEvent;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AccountCloseEvent extends BaseEvent {
}
