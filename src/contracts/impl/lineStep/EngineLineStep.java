package Task_3.contracts.impl.lineStep;

import Task_3.contracts.ILineStep;
import Task_3.contracts.IProductPart;
import Task_3.contracts.impl.part.Engine;

public class EngineLineStep implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Engine created");
        return new Engine();
    }
}
