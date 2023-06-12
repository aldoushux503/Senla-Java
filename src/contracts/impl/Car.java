package Task_3.contracts.impl;

import Task_3.contracts.IProduct;
import Task_3.contracts.IProductPart;

public class Car implements IProduct {
    private IProductPart body;
    private IProductPart chassis;
    private IProductPart engine;

    @Override
    public void installFirstPart(IProductPart productPart) {
        this.body = productPart;
        System.out.println("Car body installed");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        this.chassis = productPart;
        System.out.println("Car chassis installed");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        this.engine = productPart;
        System.out.println("Car engine installed");
    }
}
