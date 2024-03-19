package Model.AnimalClasses.Predators;

import java.time.LocalDate;

/**
 * Класс Shark, наследует {@link Predator}.
 *
 * @author Бугаков Данил
 * @version 1.0
 */
public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Shark() {
    }
}
