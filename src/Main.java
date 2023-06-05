package Task_3;

import Task_3.contracts.*;
import Task_3.contracts.impl.Car;
import Task_3.contracts.impl.CarAssemblyLine;
import Task_3.contracts.impl.CarLineStep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create line steps
        List<ILineStep> lineSteps = new ArrayList<>();
        lineSteps.add(new CarLineStep()); // Body
        lineSteps.add(new CarLineStep()); // Chassis
        lineSteps.add(new CarLineStep()); // Engine

        // Create assembly line
        IAssemblyLine assemblyLine = new CarAssemblyLine(lineSteps);

        // Create product
        IProduct car = new Car();

        // Assemble the car
        IProduct assembledCar = assemblyLine.assembleProduct(car);
    }
}
