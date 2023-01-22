package registerHomeAnimals;

import animals.Animals;
import animals.homeAnimals.IHomeAnimals;
import registerHomeAnimals.counter.Counter;
import registerHomeAnimals.exception.AnimalsException;

import java.util.ArrayList;
import java.util.List;

public class RegisterHomeAnimals {
    private final List<Animals> homeAnimals = new ArrayList<>();
    private int selectAnimals;

    public void addAnimals(Animals animals) {
        if (animals instanceof IHomeAnimals) {
            try (Counter counter = new Counter()) {
                if (counter.addCount(animals)) {
                    homeAnimals.add(animals);
                }
                System.out.println("Животное добавлено в архив\n");
            } catch (AnimalsException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("В реестр можно добавлять только домашних животных\n");
        }
    }

    public void deleteAnimals() {
        Counter counter = new Counter();
        homeAnimals.remove(selectAnimals);
        counter.removeCount();
        System.out.println("Животное удалено из реестра\n");
    }

    public void teachComand(String command) {
        homeAnimals.get(selectAnimals).teachCommand(command);
        System.out.println("Животное выучило новую команду\n");
    }

    public void getCommand() {
        if (homeAnimals.get(selectAnimals).getSizeCommand() != 0) {
            homeAnimals.get(selectAnimals).getCommand();
        } else {
            System.out.println("Изученных команд нет\n");
        }
    }

    public void selectAnimals(int select) {
        this.selectAnimals = select;
    }

    public void info() {
        if (homeAnimals.size() != 0) {
            int countAnimal = 0;
            for (Animals homeAnimals : homeAnimals) {
                System.out.println(countAnimal + " - " + homeAnimals.type() + " Имя: " + homeAnimals.getName() + " Дата рождения: " + homeAnimals.getDataBirth());
                countAnimal++;
            }
        } else {
            System.out.println("Животных в реестре нет\n");
        }
    }

    public boolean checkFill() {
        return homeAnimals.size() != 0;
    }

    public int sizaArrayAnimals() {
        return homeAnimals.size();
    }
}
