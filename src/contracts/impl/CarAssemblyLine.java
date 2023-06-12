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

        List<IProductPart> parts = new ArrayList<>();
        for (ILineStep lineStep : lineSteps) {
            parts.add(lineStep.buildProductPart());

        }

        product.installFirstPart(parts.get(0));
        product.installSecondPart(parts.get(1));
        product.installThirdPart(parts.get(2));

        System.out.println("Car assembled.");
        return product;
    }
}
