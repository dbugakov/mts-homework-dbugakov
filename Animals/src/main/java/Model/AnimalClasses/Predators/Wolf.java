package Model.AnimalClasses.Predators;

import java.time.LocalDate;

/**
 * Класс Wolf, наследует {@link Predator}.
 *
 * @author Бугаков Данил
 * @version 1.0
 */
public class Wolf extends Predator {
    public Wolf(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Wolf() {
    }
}
