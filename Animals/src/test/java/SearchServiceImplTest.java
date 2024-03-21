import Api.Model.Animal;
import Exception.InvalidAnimalBirthDateException;
import Exception.InvalidAnimalException;
import Model.AnimalClasses.Pets.Cat;
import Model.AnimalClasses.Pets.Dog;
import Model.AnimalClasses.Predators.Wolf;
import Service.SearchServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {

    Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
    Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
    Cat cat = new Cat();
    SearchServiceImpl searchService = new SearchServiceImpl();
    boolean result;

    @DisplayName("Кейс, когда год у животного високостный")
    @Test
    void checkLeapYearAnimalPositive() {

        try {
            result = searchService.checkLeapYearAnimal(dog);
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException(e);
        }
        assertTrue(result);
    }

    @DisplayName("Кейс, когда год у животного не високостный")
    @Test
    void checkLeapYearAnimalNegative() {
        try {
            result = searchService.checkLeapYearAnimal(wolf);
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @DisplayName("Кейс, когда в checkLeapYearAnimal передаём null")
    @Test
    void checkLeapYearInvalidAnimalException() {
        assertThrows(InvalidAnimalException.class, () -> {
            try {
                searchService.checkLeapYearAnimal(null);
            } catch (InvalidAnimalBirthDateException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @DisplayName("Кейс, когда в checkLeapYearAnimal передаём животное без даты рождения")
    @Test
    void checkLeapYearInvalidAnimalBirthDateException() {
        assertThrows(InvalidAnimalBirthDateException.class, () -> {
            try {
                searchService.checkLeapYearAnimal(cat);
            } catch (InvalidAnimalBirthDateException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @ParameterizedTest(name = "{index} - {0} is not null")
    @MethodSource("argsProviderFactory")
    void checkParameterizedTest(Animal argument) {
        assertNotNull(argument);
    }

    static Stream<Animal> argsProviderFactory() {
        Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
        Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        Cat cat = new Cat();
        return Stream.of(dog, wolf, cat);
    }
}