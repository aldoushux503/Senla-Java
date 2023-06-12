package Task_3.contracts.impl.lineStep;

import Task_3.contracts.ILineStep;
import Task_3.contracts.IProductPart;
import Task_3.contracts.impl.part.Body;

public class BodyLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Body created");
        return new Body();
    }
}