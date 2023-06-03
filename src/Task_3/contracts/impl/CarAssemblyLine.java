package Task_3.contracts.impl;

import Task_3.contracts.IAssemblyLine;
import Task_3.contracts.ILineStep;
import Task_3.contracts.IProduct;
import Task_3.contracts.IProductPart;

import java.util.ArrayList;
import java.util.List;

public class CarAssemblyLine implements IAssemblyLine {
    private final List<ILineStep> lineSteps;

    public CarAssemblyLine(List<ILineStep> lineSteps) {
        this.lineSteps = new ArrayList<>(lineSteps);
    }


    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("Car assembling...");
        IProductPart firstPart = lineSteps.get(0).buildProductPart();
        IProductPart secondPart = lineSteps.get(1).buildProductPart();
        IProductPart thirdPart = lineSteps.get(2).buildProductPart();

        product.installFirstPart(firstPart);
        product.installSecondPart(secondPart);
        product.installThirdPart(thirdPart);

        System.out.println("Car assembled.");
        return product;
    }
}
