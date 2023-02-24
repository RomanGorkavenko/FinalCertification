package gb.ru.pet_registry.controller;

import gb.ru.pet_registry.data.Kind;
import gb.ru.pet_registry.data.Pet;
import gb.ru.pet_registry.service.CatBuilder;
import gb.ru.pet_registry.service.DogBuilder;
import gb.ru.pet_registry.service.HamsterBuilder;

import java.util.List;

public class ControllerPet {

    private final CatBuilder catBuilder;

    private final DogBuilder dogBuilder;

    private final HamsterBuilder hamsterBuilder;

    public ControllerPet() {
        this.catBuilder = new CatBuilder();
        this.dogBuilder = new DogBuilder();
        this.hamsterBuilder = new HamsterBuilder();
    }

    public Pet getPet(String name, String sexOfPet, String catBreed, String command){
        catBuilder.setName(name);
        catBuilder.setSexOfPet(sexOfPet);
        catBuilder.setCatBreed(catBreed);
        catBuilder.setCommands(command);

        return catBuilder.buildCats();
    }

    public Pet getPet(String name, String sexOfPet, String dogBreed, String dogBreedClassification, String command){
        dogBuilder.setName(name);
        dogBuilder.setSexOfPet(sexOfPet);
        dogBuilder.setDogBreed(dogBreed);
        dogBuilder.setDogBreedClassification(dogBreedClassification);
        dogBuilder.setCommands(command);

        return dogBuilder.buildDogs();
    }

    public Pet getPet(String name, String sexOfPet, Kind kind, String command){
        hamsterBuilder.setName(name);
        hamsterBuilder.setSexOfPet(sexOfPet);
        hamsterBuilder.setKind(kind);
        hamsterBuilder.setCommands(command);

        return hamsterBuilder.buildHamster();
    }

    public Pet findPetName(List<Pet> pet, String name){
        for (Pet i: pet) {
            if (i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
}
