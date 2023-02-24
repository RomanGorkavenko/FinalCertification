package gb.ru.pet_registry.data;

public class Dog extends Pet {

    private final String dogBreed;

    private String dogBreedClassification;

    public Dog(Pet pet, String dogBreed, String dogBreedClassification) {
        super(pet.getName(), pet.getSexOfPet(), pet.getCommands());
        this.dogBreed = dogBreed;
        this.dogBreedClassification = dogBreedClassification;
    }

    @Override
    public String toString() {
        return "Собака, " +
                "имя: " + getName() +
                ", порода: " + dogBreed;
    }
}
