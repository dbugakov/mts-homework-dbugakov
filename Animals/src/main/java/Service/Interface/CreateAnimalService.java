package Service.Interface;

import Model.Asbtract.AbstractAnimal;
import Service.CreateAnimalServiceImpl;

/**
 * CreateAnimalService, реализован в {@link CreateAnimalServiceImpl}.
 */
public interface CreateAnimalService {
    default void createAnimals() {
        System.out.println("createAnimals - while");
        int i = 0;
        while (i < 10) {
            AbstractAnimal.getRandomAnimal();
            i++;
        }
    }
}
