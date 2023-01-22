package animals.homeAnimals;

public class Hamster extends HomeAnimals {
    private final String type = "Хомяк";
    public Hamster(String name, String dataBirth) {
        super(name, dataBirth);
    }

    public Hamster() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
