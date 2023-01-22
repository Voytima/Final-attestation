package animals.homeAnimals;

public class Cat extends HomeAnimals {
    private final String type = "Кот";
    public Cat(String name, String dataBirth) {
        super(name, dataBirth);
    }

    public Cat() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
