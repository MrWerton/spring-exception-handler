package com.notrew.springexceptionhandler.application.product;

import com.notrew.springexceptionhandler.application.shared.interfaces.UseCase;
import com.notrew.springexceptionhandler.domain.module.product.Product;
import com.notrew.springexceptionhandler.domain.module.product.ProductGateway;

import java.util.List;

public class GetProductsUseCase implements UseCase<Void, List<Product>> {
    private final ProductGateway productGateway;

    public GetProductsUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<Product> call(Void input) {
        return productGateway.findAll();
    }
}
