package animals.homeAnimals;

public class Dog extends HomeAnimals {
    private final String type = "Собака";
    public Dog(String name, String dataBirth) {
        super(name, dataBirth);
    }

    public Dog() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
