import Api.Model.Animal;
import Api.Service.CreateAnimalService;
import Service.CreateAnimalServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreateAnimalServiceImplTest {

    CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();

    @DisplayName("Кейс создания Map циклом while")
    @Test
    void createAnimalsWhile() {
        assertFalse(createAnimalService.createAnimals().isEmpty());
    }

    @DisplayName("Кейс, когда год у животного не високостный")
    @Test
    void createAnimalsFor() {
        assertFalse(createAnimalServiceImpl.createAnimals().isEmpty());
    }

    @DisplayName("Кейс, когда год у животного не високостный")
    @Test
    void createAnimalsDoWhile() {
        int resultSize = 0;
        Map<String, List<Animal>> animalMap = createAnimalServiceImpl.createAnimals(5);
        for (List<Animal> list : animalMap.values()) {
            resultSize += list.size();
        }
        assertEquals(resultSize, 5);
    }

    CreateAnimalService createAnimalService = new CreateAnimalService() {
        @Override
        public Map<String, List<Animal>> createAnimals() {
            return CreateAnimalService.super.createAnimals();
        }
    };
}
