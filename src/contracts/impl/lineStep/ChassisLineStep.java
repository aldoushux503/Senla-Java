package Task_3.contracts.impl.lineStep;

import Task_3.contracts.ILineStep;
import Task_3.contracts.IProductPart;
import Task_3.contracts.impl.part.Chassis;

public class ChassisLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Chassis created");
        return new Chassis();
    }
}
