package com.notrew.springexceptionhandler;

import com.notrew.springexceptionhandler.domain.module.product.Product;
import com.notrew.springexceptionhandler.domain.shared.contracts.Identifier;
import com.notrew.springexceptionhandler.domain.shared.exceptions.NotificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void shouldBeInitializedCorrectly(){
        final String name  = "hello hoohle";
        final var sut = Product.create(name);
        Assertions.assertEquals(sut.getName(), name);
        Assertions.assertTrue(sut.getId() instanceof Identifier);



    }
    @Test
    public void testNullName(){
        final String name  = null;
        final String notificationError = "failed in create product";
        final String msgError = "Name should be not null";
        final var actualException = Assertions.assertThrows(NotificationException.class, ()->{
            Product.create(name);
        });
        Assertions.assertEquals(1, actualException.getErrors().size());
        Assertions.assertEquals(notificationError, actualException.getMessage());
        Assertions.assertEquals(msgError, actualException.getErrors().get(0).msg());

    }
    @Test
    public void testEmptyName(){
        final String name  = "";
        final String msgError = "Name should be not empty";
        final var actualException = Assertions.assertThrows(NotificationException.class, ()->{
            Product.create(name);
        });
        Assertions.assertEquals(1, actualException.getErrors().size());
        Assertions.assertEquals(msgError, actualException.getErrors().get(0).msg());

    }
    @Test
    public void testEmptyLessThatEleven(){
        final String name  = "hello";
        final String msgError = "Name not can be less that 11";
        final var actualException = Assertions.assertThrows(NotificationException.class, ()->{
            Product.create(name);
        });
        Assertions.assertEquals(1, actualException.getErrors().size());
        Assertions.assertEquals(msgError, actualException.getErrors().get(0).msg());

    }
}
