package Task_2;

public class Rose extends  Flower {
    public Rose() {
        super("Rose", 2.5);
    }

    @Override
    public String getDescription() {
        return "A red rose.";
    }
}
