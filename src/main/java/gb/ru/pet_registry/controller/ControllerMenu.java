package gb.ru.pet_registry.controller;

import gb.ru.pet_registry.data.Counter;
import gb.ru.pet_registry.data.Kind;
import gb.ru.pet_registry.data.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerMenu {

    private final ControllerPet controllerPet;

    Scanner input = new Scanner(System.in);

    public ControllerMenu() {
        this.controllerPet = new ControllerPet();
    }

    public void menu() {
        List<Pet> pets = new ArrayList<>();
        Pet pet;
        try (Counter counter = new Counter()) {
            while (true) {

                String getPet = "1. Завести новое животное. \n2. Посмотреть список животных.\n" +
                        "3. Посмотреть список команд, которое выполняет животное.\n4. Обучить животное новой команде.\n" +
                        "5. Выйти.\nВведите 1, 2, 3, 4 или 5.\n";
                int answer = inputNumber(getPet, 5);

                switch (answer) {
                    case 1:
                        pets.add(addPet(counter));
                        System.out.println("=".repeat(50) + "\n");
                        break;
                    case 2:
                        if (checkingForThePresenceOfPets(pets)) break;
                        System.out.println("=".repeat(50) + "\n");
                        break;
                    case 3:
                        if (checkingForThePresenceOfPets(pets)) break;
                        System.out.println("Введите имя животного, список команд которого хотите увидеть.");
                        String namePet = input.next();
                        pet = controllerPet.findPetName(pets, namePet);
                        if (checkingNameForNull(pet)) break;
                        printCommand(pet.getCommands());
                        System.out.println("=".repeat(50) + "\n");
                        break;
                    case 4:
                        if (checkingForThePresenceOfPets(pets)) break;
                        System.out.println("Введите имя животного, которому хотите добавить команду.");
                        String namePetAddCommand = input.next();
                        System.out.println("Введите команду.");
                        String command = input.next();
                        pet = controllerPet.findPetName(pets, namePetAddCommand);
                        if (checkingNameForNull(pet)) break;
                        pet.addCommand(command);
                        System.out.println("Команда \"" + command + "\" для " + pet.getName() + " добавлена.");
                        System.out.println("=".repeat(50) + "\n");
                        break;
                    case 5:
                        System.out.println("Всего Вам хорошего!");
                        input.close();
                        return;
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private Pet addPet(Counter counter) {
        String name, sexOfPet, breed, breedClassification, command;
        Kind[] kind = Kind.values();
        Pet pet;

        try {
            String str = "Кого вы хотите завести:\n1. Кошку.\n2. Собаку.\n3. Хомяка.\nВведите 1, 2 или 3.\n";
            int answer = inputNumber(str, 3);

            switch (answer) {
                case 1:
                    System.out.println("Введите имя: ");
                    name = input.next();

                    System.out.println("Введите пол: ");
                    sexOfPet = input.next();

                    System.out.println("Введите породу: ");
                    breed = input.next();

                    System.out.println("Введите команду: ");
                    command = input.next();

                    if (!name.isEmpty() && !sexOfPet.isEmpty() && !breed.isEmpty() && !command.isEmpty()) {
                        counter.add();
                    }

                    pet = controllerPet.getPet(name, sexOfPet, breed, command);
                    System.out.println("Вы завели " + pet.toString());
                    return pet;
                case 2:
                    System.out.println("Введите имя: ");
                    name = input.next();

                    System.out.println("Введите пол: ");
                    sexOfPet = input.next();

                    System.out.println("Введите породу: ");
                    breed = input.next();

                    System.out.println("Введите классификацию породы согласно FCI: ");
                    breedClassification = input.next();

                    System.out.println("Введите команду: ");
                    command = input.next();

                    if (!name.isEmpty() && !sexOfPet.isEmpty() && !breed.isEmpty() && !breedClassification.isEmpty() &&
                            !command.isEmpty()) {
                        counter.add();
                    }

                    pet = controllerPet.getPet(name, sexOfPet, breed, breedClassification, command);
                    System.out.println("Вы завели " + pet.toString());
                    return pet;
                case 3:
                    System.out.println("Введите имя: ");
                    name = input.next();

                    System.out.println("Введите пол: ");
                    sexOfPet = input.next();

                    String strKind = "Введите название вида:\n1. " + kind[0].toString() +
                            ".\n2. " + kind[1].toString() + ".\n3. " + kind[2].toString() + ".\nВведите 1, 2 или 3.\n";
                    int kindNumber = inputNumber(strKind, 3);

                    System.out.println("Введите команду: ");
                    command = input.next();

                    if (!name.isEmpty() && !sexOfPet.isEmpty() && (kind != null || kind.length != 0) && !command.isEmpty()) {
                        counter.add();
                    }

                    pet = controllerPet.getPet(name, sexOfPet, kind[kindNumber - 1], command);
                    System.out.println("Вы завели " + pet.toString());
                    return pet;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    private int inputNumber(String str, int number) {
        System.out.print(str);
        int num;
        if (input.hasNextInt()) {
            num = input.nextInt();
            if (num < 0 || num > number) {
                System.out.println("Ошибка ввода.");
                num = inputNumber(str, number);
            }
        } else {
            System.out.println("Ошибка ввода.");
            input.next();
            num = inputNumber(str, number);
        }
        return num;
    }

    private void printPets(List<Pet> pets) {
        int number = 1;
        for (Pet i : pets) {
            System.out.printf("%d. %s\n", number++, i);
        }
    }

    private void printCommand(List<String> str) {
        int number = 1;
        for (String i : str) {
            System.out.printf("%d. %s\n", number++, i);
        }
    }

    private boolean checkingForThePresenceOfPets(List<Pet> pets) {
        if (pets.size() != 0) {
            printPets(pets);
        } else {
            System.out.println("У Вас пока нет животных.\n");
            System.out.println("=".repeat(50) + "\n");
            return true;
        }
        return false;
    }

    private boolean checkingNameForNull(Pet pet) {
        if (pet == null) {
            System.out.println("Животного с таким именем нет.");
            System.out.println("=".repeat(50) + "\n");
            return true;
        }
        return false;
    }
}
