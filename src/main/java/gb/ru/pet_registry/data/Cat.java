package gb.ru.pet_registry.data;

public class Cat extends Pet {
    private final String catBreed;

    public Cat(Pet pet, String catBreed) {
        super(pet.getName(), pet.getSexOfPet(), pet.getCommands());
        this.catBreed = catBreed;
    }

    @Override
    public String toString() {
        return "Кошка, " +
                "имя: " + getName() +
                ", порода: " + catBreed;
    }
}
