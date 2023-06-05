package Task_3.contracts.impl;

import Task_3.contracts.CarPart;
import Task_3.contracts.ILineStep;
import Task_3.contracts.IProductPart;

public class CarLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Part of the car created");
        return new CarPart();
    }
}
