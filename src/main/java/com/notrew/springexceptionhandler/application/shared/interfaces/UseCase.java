package com.notrew.springexceptionhandler.application.product.shared.interfaces;

public interface UseCase<I, O> {
    public O call(I input);
}
