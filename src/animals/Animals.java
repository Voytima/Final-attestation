package animals;

import java.util.ArrayList;
import java.util.List;

public abstract class Animals {
    private String name;
    private String dataBirth;
    private final List<String> command = new ArrayList<>();

    protected Animals(String name, String dataBirth) {
        this.name = name;
        this.dataBirth = dataBirth;
    }

    protected Animals() {}

    public void teachCommand(String command) {
        this.command.add(command);
    }

    public void getCommand() {
        for (String command : command) {
            System.out.print(command + ", ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public String getDataBirth() {
        return dataBirth;
    }

    public abstract String type();

    public int getSizeCommand() {
        return command.size();
    }
}
