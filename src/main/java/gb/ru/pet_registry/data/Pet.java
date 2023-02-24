package gb.ru.pet_registry.data;

import java.util.List;

public class Pet implements Commandable{
    private final String name;
    private final String sexOfPet;
    private final List<String> commands;

    public Pet(String name, String sexOfPet, List<String> commands) {
        this.name = name;
        this.sexOfPet = sexOfPet;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getSexOfPet() {
        return sexOfPet;
    }

    public List<String> getCommands() {
        return commands;
    }

    @Override
    public void addCommand(String command) {
            commands.add(command);
    }
}
