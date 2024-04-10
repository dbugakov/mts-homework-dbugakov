package Model;

import Api.Model.Animal;
import Util.FileUtil;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 * Класс AbstractAnimal, реализует {@link Animal}.
 *
 * @author Бугаков Данил
 * @version 1.1
 */
public abstract class AbstractAnimal implements Animal {

    /**
     * Поле порода
     */
    protected String breed = getClass().getSimpleName();

    /**
     * Поле имя
     */
    protected String name;

    /**
     * Поле цена
     */
    protected Double cost;

    /**
     * Поле характер
     */
    protected String character;

    /**
     * Поле день рождения животного, в формате dd-MM-yyyy
     */
    protected LocalDate birthDate;

    public String secretInformation = FileUtil.getRandomLineFromFile("Animals/src/main/resources/secretStore/secretInformation.txt");

    public AbstractAnimal(String name, Double cost, String character, LocalDate birthDate) {
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public AbstractAnimal() {

    }

    /**
     * Функция получения значения поля {@link AbstractAnimal#breed}.
     * Переопределён из {@link Animal}
     *
     * @return возвращает название породы
     */
    @Override
    public String getBreed() {
        return breed;
    }

    /**
     * Функция получения значения поля {@link AbstractAnimal#name}.
     * Переопределён из {@link Animal}
     *
     * @return возвращает название
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Функция получения значения поля {@link AbstractAnimal#cost}.
     * Переопределён из {@link Animal}
     *
     * @return возвращает цену
     */
    @Override
    public Double getCost() {
        return cost;
    }

    /**
     * Функция получения значения поля {@link AbstractAnimal#character}
     *
     * @return возвращает характер
     */
    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String getSecretInformation() {
        return secretInformation;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSecretInformation(String secretInformation) {
        this.secretInformation = secretInformation;
    }

    /**
     * Функция получения рандомного животного.
     * Ничего не возвращает, печатает результат на экран
     */
    public static Animal getRandomAnimal() {
        Random random = new Random();
        Animal animal = null;

        switch (random.nextInt(4)) {
            case 0:
                animal = new Cat();
                break;
            case 1:
                animal = new Dog();
                break;
            case 2:
                animal = new Shark();
                break;
            case 3:
                animal = new Wolf();
                break;
        }
        System.out.println(animal);
        return animal;
    }

    /**
     * Переопределение функции toString из {@link Object}.
     */
    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate +
                ", secretInformation='" + secretInformation + '\'' +
                '}';
    }

    /**
     * Реализация функции compareTo {@link Comparable}.
     */
    @Override
    public int compareTo(Animal o) {
        return getBirthDate().compareTo(o.getBirthDate());
    }

    /**
     * Переопределение функции equals из {@link Object}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Переопределение функции hashCode из {@link Object}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }
}
