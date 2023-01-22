package animals.packAnimals;

public class Mule extends PackAnimals {
    private final String type = "Мюл";
    public Mule(String name, String dataBirth) {
        super(name, dataBirth);
    }

    public Mule() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
