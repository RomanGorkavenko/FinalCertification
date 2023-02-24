package gb.ru.pet_registry.service;

import gb.ru.pet_registry.data.Cat;
import gb.ru.pet_registry.data.Pet;

public class CatBuilder extends PetBuilder {

    private String catBreed;
    public Pet buildCats(){
        return new Cat(buildPets(), catBreed);
    }
    public void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }
}
