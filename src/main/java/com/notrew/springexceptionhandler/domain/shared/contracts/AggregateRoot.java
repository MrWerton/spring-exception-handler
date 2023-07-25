package com.notrew.springexceptionhandler.domain.shared.contracts;


public abstract class AggregateRoot<Id extends Identifier> extends Entity<Id>{

    protected AggregateRoot(Id id) {
        super(id);
    }
}
