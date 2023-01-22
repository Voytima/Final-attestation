package animals.homeAnimals;

import animals.Animals;

abstract class HomeAnimals extends Animals implements IHomeAnimals {
    protected HomeAnimals(String name, String dataBirth) {
        super(name, dataBirth);
    }
    protected HomeAnimals() {
        super();
    }
}
