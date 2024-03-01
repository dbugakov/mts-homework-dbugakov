package Service;
import Model.Asbtract.AbstractAnimal;
import Service.Interface.CreateAnimalService;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public void createAnimals() {
        CreateAnimalService.super.createAnimals();
        System.out.println("createAnimals - do while");
        int i = 0;
        do  {
            AbstractAnimal.getRandomAnimal();
            i++;
        } while (i < 10);
    }

    public void createAnimals(int AnimalCount) {
        System.out.println("createAnimals - for");
        for (int i = 0; i < AnimalCount; i++) {
            AbstractAnimal.getRandomAnimal();
        }
    }
}
