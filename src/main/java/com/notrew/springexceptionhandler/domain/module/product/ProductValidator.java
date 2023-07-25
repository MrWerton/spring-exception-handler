package com.notrew.springexceptionhandler.domain.module.product;

import com.notrew.springexceptionhandler.domain.shared.validations.ValidationHandler;
import com.notrew.springexceptionhandler.domain.shared.validations.Validator;
import com.notrew.springexceptionhandler.domain.shared.exceptions.Error;

public class ProductValidator extends Validator {
    private final Product product;
    protected ProductValidator(ValidationHandler handler, Product product) {
        super(handler);
        this.product = product;
    }

    @Override
    public void validate() {
        final var name = product.getName();
        if(name == null ){
            this.validationHandler().append(new Error("Name should be not null"));
            return;
        }
        if(name.trim().isBlank() ){
            this.validationHandler().append(new Error("Name should be not empty"));
            return;
        }

        if(name.length() < 11){
            this.validationHandler().append(new Error("Name not can be less that 11"));
        }
    }
}
