package gb.ru.pet_registry.data;


public class Hamster extends Pet {

    private final Kind kind;

    public Hamster(Pet pet, Kind kind) {
        super(pet.getName(), pet.getSexOfPet(), pet.getCommands());
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Хомяк, " +
                "имя: " + getName() +
                ", порода: " + kind;
    }
}
