package com.notrew.springexceptionhandler.domain.module.product;

import com.notrew.springexceptionhandler.domain.shared.contracts.Identifier;

import java.util.UUID;

public class ProductId extends Identifier {
    @Override
    public String getValue() {
        return UUID.randomUUID().toString();
    }
}
