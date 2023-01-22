package registerHomeAnimals.counter;

import animals.Animals;
import registerHomeAnimals.exception.AnimalsException;

public class Counter implements AutoCloseable {
    private boolean resouces = true;
    private static int count = 0;

    public boolean addCount(Animals animals) {
        if (!animals.getName().equals("") && !animals.getDataBirth().equals("")) {
            count++;
            resouces = false;
            return true;
        }
        return false;
    }

    public void removeCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void close() throws AnimalsException {
        if (resouces) throw new AnimalsException("Ресурс остался открыт, не все поля животного заполнены");
    }
}
