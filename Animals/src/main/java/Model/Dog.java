package Model;

import java.time.LocalDate;

/**
 * Класс Dog, наследует {@link Pet}.
 *
 * @author Бугаков Данил
 * @version 1.0
 */
public class Dog extends Pet {
    public Dog(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Dog() {
    }
}
