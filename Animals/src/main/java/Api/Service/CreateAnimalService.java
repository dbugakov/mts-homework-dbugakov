package Api.Service;

import Api.Model.Animal;
import Model.Asbtract.AbstractAnimal;
import Service.CreateAnimalServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CreateAnimalService, реализован в {@link CreateAnimalServiceImpl}.
 */
public interface CreateAnimalService {

    default Map<String, List<Animal>> createAnimals() {
        System.out.println("createAnimals - while");
        Map<String, List<Animal>> resultMap = new HashMap<>();
        Animal animal;
        int i = 0;
        while (i < 10) {
            animal = AbstractAnimal.getRandomAnimal();
            if (resultMap.containsKey(animal.getClass().getSimpleName())) {
                resultMap.get(animal.getClass().getSimpleName()).add(animal);
            } else {
                resultMap.put(animal.getClass().getSimpleName(), new ArrayList<>());
                resultMap.get(animal.getClass().getSimpleName()).add(animal);
            }
            i++;
        }
        System.out.println(resultMap);
        return resultMap;
    }
}
