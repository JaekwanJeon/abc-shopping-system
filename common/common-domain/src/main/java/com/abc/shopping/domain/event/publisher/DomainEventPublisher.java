package com.abc.shopping.domain.event.publisher;

import com.abc.shopping.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
