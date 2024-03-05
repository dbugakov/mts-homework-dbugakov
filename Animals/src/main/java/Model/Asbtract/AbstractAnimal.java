package Model.Asbtract;

import Model.AnimalClasses.Pets.Cat;
import Model.AnimalClasses.Pets.Dog;
import Model.AnimalClasses.Predators.Shark;
import Model.AnimalClasses.Predators.Wolf;
import Model.Interface.Animal;

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
    protected String breed;

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

    /**
     * Функция получения рандомного животного.
     * Ничего не возвращает, печатает результат на экран
     */
    public static void getRandomAnimal() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                System.out.println(new Cat());
                break;
            case 1:
                System.out.println(new Dog());
                break;
            case 2:
                System.out.println(new Shark());
                break;
            case 3:
                System.out.println(new Wolf());
                break;
        }
    }

    /**
     * Переопределение функции toString из {@link Object}.
     */
    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "class='" + getClass().getSimpleName() + '\'' +
                '}';
    }
}
