package menu;

import animals.homeAnimals.Cat;
import animals.homeAnimals.Dog;
import animals.homeAnimals.Hamster;
import registerHomeAnimals.RegisterHomeAnimals;
import registerHomeAnimals.counter.Counter;

public class Navigation {
    RegisterHomeAnimals registerHomeAnimals = new RegisterHomeAnimals();
    int temp;

    public Navigation() {
        hello();
        mainMenu();
    }

    private void hello() {
        System.out.println("Привет! Это реест домашних животных \nЧтобы двигаться по меню - выбирайте нужные пункты\n");
    }

    private void mainMenu() {
        while (true) {
            System.out.println("Всего животных - " + Counter.getCount() + "\n" +
                    "Показать всех животных - 1 \n" +
                    "Добавить животное - 2 \n" +
                    "Выбрать животное - 3 \n" +
                    "Выйти из меню - 4");

            temp = Integer.parseInt(Sc.sc());
            if (temp == 1) {
                viewAll();
            } else if (temp == 2) {
                addAnimals();
            } else if (temp == 3) {
                selectAnimal();
            } else if (temp == 4) {
                return;
            } else {
                System.out.println("Неправильно выбран пункт, попробуйте снова\n");
            }
        }
    }

    private void addAnimals() {
        String type;
        String name;
        String dataBirth;

        System.out.println("Какое домашнее животное вы хотите добавить? \n" +
                "Кот, Собака, Хомяк");
        type = Sc.sc();
        switch (type) {
            case "Кот" -> {
                System.out.println("Как назовем кота?");
                name = Sc.sc();
                System.out.println("Когда родился кот?");
                dataBirth = Sc.sc();
                registerHomeAnimals.addAnimals(new Cat(name, dataBirth));
            }
            case "Собака" -> {
                System.out.println("Как назовем собаку");
                name = Sc.sc();
                System.out.println("Когда родилась собака?");
                dataBirth = Sc.sc();
                registerHomeAnimals.addAnimals(new Dog(name, dataBirth));
            }
            case "Хомяк" -> {
                System.out.println("Как назовем хомяка?");
                name = Sc.sc();
                System.out.println("Когда родился хомяк?");
                dataBirth = Sc.sc();
                registerHomeAnimals.addAnimals(new Hamster(name, dataBirth));
            }
            default -> System.out.println("Нельзя занести в реестр такое животное\n");
        }
    }

    private void selectAnimal() {
        if (registerHomeAnimals.checkFill()) {
            int select;
            System.out.println("Выберите животное из спика по его номеру:");
            viewAll();
            System.out.println("");
            while (true) {
                select = Integer.parseInt(Sc.sc());
                if (select <= registerHomeAnimals.sizaArrayAnimals()) {
                    registerHomeAnimals.selectAnimals(select);
                    break;
                } else {
                    System.out.println("Номер такого животного в списке отсутствует, введите номер заново");
                }
            }

            System.out.println("Что хотите сделать с этим животным?");
            System.out.println("""
                    1 - Выучить новую команду\s
                    2 - Посмотреть выученные команды\s
                    3 - Выгнать животное""");
            temp = Integer.parseInt(Sc.sc());
            if (temp == 1) {
                System.out.println("Какую команду изучит животное?");
                teech(Sc.sc());
            } else if (temp == 2) {
                getCommand();
            } else if (temp == 3) {
                delete();
            }
        } else {
            System.out.println("В реестре нет животных\n");
        }
    }

    private void getCommand() {
        registerHomeAnimals.getCommand();
    }
    private void teech(String command) {
        registerHomeAnimals.teachComand(command);
    }

    private void delete() {
        registerHomeAnimals.deleteAnimals();
    }

    private void viewAll() {
        registerHomeAnimals.info();
    }
}