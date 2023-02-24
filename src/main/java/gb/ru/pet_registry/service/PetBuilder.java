package gb.ru.pet_registry.service;

import gb.ru.pet_registry.data.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetBuilder {

    private String name;
    private String sexOfPet;
    private List<String> commands;

    public Pet buildPets() {
        return new Pet(name, sexOfPet, commands);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSexOfPet(String sexOfPet) {
        this.sexOfPet = sexOfPet;
    }

    public void setCommands(String command) {
        List<String> list = new ArrayList<>();
        list.add(command);
        this.commands = list;
    }
}
