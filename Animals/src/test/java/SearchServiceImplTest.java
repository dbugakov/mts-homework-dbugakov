import Model.AnimalClasses.Pets.Cat;
import Model.AnimalClasses.Pets.Dog;
import Model.AnimalClasses.Predators.Wolf;
import Model.Interface.Animal;
import Service.Exception.InvalidAnimalBirthDateException;
import Service.Exception.InvalidAnimalException;
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

    @DisplayName("Кейс, когда год у животного високостный")
    @Test
    void checkLeapYearAnimalPositive() throws InvalidAnimalBirthDateException {
        String result = searchService.checkLeapYearAnimal(dog);
        assertEquals(result, dog.getName() + " был рожден в високосный год");
    }

    @DisplayName("Кейс, когда год у животного не високостный")
    @Test
    void checkLeapYearAnimalNegative() throws InvalidAnimalBirthDateException {
        String result = searchService.checkLeapYearAnimal(wolf);
        assertEquals(result, wolf.getName() + " не был рожден в високосный год");
    }

    @DisplayName("Кейс, когда в checkLeapYearAnimal передаём null")
    @Test
    void checkLeapYearInvalidAnimalException() {
        assertThrows(InvalidAnimalException.class, () -> {
            searchService.checkLeapYearAnimal(null);
        });
    }

    @DisplayName("Кейс, когда в checkLeapYearAnimal передаём животное без даты рождения")
    @Test
    void checkLeapYearInvalidAnimalBirthDateException() {
        assertThrows(InvalidAnimalBirthDateException.class, () -> {
            searchService.checkLeapYearAnimal(cat);
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