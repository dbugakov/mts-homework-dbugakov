package Model.AnimalClasses.Pets;

import Model.Asbtract.AbstractAnimal;

import java.time.LocalDate;

/**
 * Класс Pet, наследует {@link AbstractAnimal}.
 *
 * @author Бугаков Данил
 * @version 1.0
 */
public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Pet() {

    }
}
