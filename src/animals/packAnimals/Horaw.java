package animals.packAnimals;

public class Horaw extends PackAnimals {
    private final String type = "Лошадь";
    public Horaw(String name, String dataBirth) {
        super(name, dataBirth);
    }

    public Horaw() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
