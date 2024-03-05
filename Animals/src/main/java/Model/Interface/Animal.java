package Model.Interface;

import Model.Asbtract.AbstractAnimal;

/**
 * Animal, реализован в {@link AbstractAnimal}.
 */
public interface Animal {

    /**
     * Функция получения строки.
     *
     * @return возвращает строку
     */
    public String getBreed();

    /**
     * Функция получения строки.
     *
     * @return возвращает строку
     */
    public String getName();

    /**
     * Функция получения значения с плавающей точкой.
     *
     * @return возвращает значение с плавающей точкой
     */
    public Double getCost();

    /**
     * Функция получения строки.
     *
     * @return возвращает строку
     */
    public String getCharacter();

}
