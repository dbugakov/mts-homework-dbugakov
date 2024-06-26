import Api.Model.Animal;
import Exception.InvalidAnimalBirthDateException;
import Model.Cat;
import Model.Dog;
import Model.Shark;
import Model.Wolf;
import Repository.AnimalRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalRepositoryImplTest {
    List<Animal> animalList;
    AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

    @DisplayName("Кейс, когда хотя бы у одного из животных год рождения високостный")
    @Test
    void findLeapYearNamesPositive() throws InvalidAnimalBirthDateException {
        Dog dog = new Dog( "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
        Wolf wolf = new Wolf("Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertFalse(animalRepository.findLeapYearNames(animalList).isEmpty());
    }

    @DisplayName("Кейс, когда ни у кого из животных год рождения не високостный")
    @Test
    void findLeapYearNamesNegative() throws InvalidAnimalBirthDateException {
        Dog dog = new Dog("Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2017, 10, 6));
        Wolf wolf = new Wolf("Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertTrue(animalRepository.findLeapYearNames(animalList).isEmpty());
    }

    @DisplayName("Кейс, когда найдены животные старше указанного года")
    @Test
    void findOlderAnimalPositive() throws IOException {
        Dog dog = new Dog("Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
        Wolf grayWolf = new Wolf("Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        Wolf whiteWolf = new Wolf("Шарик", 777.77, "Замыкает стаю", LocalDate.of(2023, 3, 17));
        animalList.add(dog);
        animalList.add(grayWolf);
        animalList.add(whiteWolf);
        assertEquals(2, animalRepository.findOlderAnimal(animalList, 2).size());
    }

    @DisplayName("Кейс, когда найдены животные старше указанного года, выводится самый старший")
    @Test
    void findOlderAnimalNegative() throws IOException {
        Dog dog = new Dog("Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2017, 10, 6));
        Wolf wolf = new Wolf("Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertEquals(Period.between(dog.getBirthDate(), LocalDate.now()).getYears(), animalRepository.findOlderAnimal(animalList, 10).get(dog));
    }

    @DisplayName("Кейс, когда в списке животных имеются дубликаты")
    @Test
    void findDuplicatePositive() {
        Cat cat = new Cat("Киса");
        Cat cat1 = new Cat("Киса");
        Cat cat2 = new Cat("Багира");
        Cat cat3 = new Cat("Багира");
        Cat cat4 = new Cat("Багира");
        Shark shark = new Shark("Зубастик");
        animalList.add(shark);
        animalList.add(cat3);
        animalList.add(cat2);
        animalList.add(cat1);
        animalList.add(cat);
        animalList.add(cat4);
        assertFalse(animalRepository.findDuplicate(animalList).isEmpty());
    }

    @DisplayName("Кейс, когда в списке животных нет дубликатов")
    @Test
    void findDuplicateNegative() {
        Dog dog = new Dog("Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2017, 10, 6));
        Wolf wolf = new Wolf("Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertTrue(animalRepository.findDuplicate(animalList).isEmpty());
    }

    @BeforeEach
    public void initList() {
        animalList = new ArrayList<>();
    }
}
