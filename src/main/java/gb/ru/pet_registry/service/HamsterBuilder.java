package gb.ru.pet_registry.service;

import gb.ru.pet_registry.data.Hamster;
import gb.ru.pet_registry.data.Kind;
import gb.ru.pet_registry.data.Pet;

public class HamsterBuilder extends PetBuilder {

    private Kind kind;

    public Pet buildHamster(){
        return new Hamster(buildPets(), kind);
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }
}
