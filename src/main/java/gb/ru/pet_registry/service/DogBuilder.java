package gb.ru.pet_registry.service;

import gb.ru.pet_registry.data.Dog;
import gb.ru.pet_registry.data.Pet;

public class DogBuilder extends PetBuilder {

    private String dogBreed;

    private String dogBreedClassification;

    public Pet buildDogs(){
        return new Dog(buildPets(), dogBreed, dogBreedClassification);
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public void setDogBreedClassification(String dogBreedClassification) {
        this.dogBreedClassification = dogBreedClassification;
    }
}
