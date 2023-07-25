package com.notrew.springexceptionhandler.domain.module.product;
import com.notrew.springexceptionhandler.domain.shared.contracts.AggregateRoot;
import com.notrew.springexceptionhandler.domain.shared.exceptions.NotificationException;
import com.notrew.springexceptionhandler.domain.shared.validations.Notification;
import com.notrew.springexceptionhandler.domain.shared.validations.ValidationHandler;

public class Product  extends AggregateRoot<ProductId> {
    private final String name;
    protected Product(ProductId productId, String name) {
        super(productId);
        this.name = name;
        selfValidation();
    }

    public static Product create(String name){
        final var id = new ProductId();
       return new Product(id, name);
    }

    @Override
    public void validate(ValidationHandler validationHandler) {
        new ProductValidator(validationHandler, this).validate();
    }

    private void selfValidation(){
        final var notification = Notification.create();

        validate(notification);


        if(notification.hasError()){
            throw new NotificationException("failed in create product",notification);
        }
    }

    public String getName() {
        return name;
    }
}
