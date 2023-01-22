package animals.packAnimals;

public class Camel extends PackAnimals {
    private final String type = "Верблюд";
    public Camel(String name, String dataBirth) {
        super(name, dataBirth);
    }

    public Camel() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
