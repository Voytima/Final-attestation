package animals.packAnimals;

import animals.Animals;

abstract class PackAnimals extends Animals implements IPackAnimals {
    protected PackAnimals(String name, String dataBirth) {
        super(name, dataBirth);
    }
    protected PackAnimals() {
        super();
    }
}
