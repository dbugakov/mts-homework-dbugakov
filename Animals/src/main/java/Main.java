import Service.CreateAnimalServiceImpl;
import Service.Interface.CreateAnimalService;

/**
 * Класс Main, запускает программу.
 */
public class Main {

    /**
     * Функция запуска программы.
     * Ничего не возвращает, выводит результат на экран
     */
    public static void main(String[] args) {

        CreateAnimalService createAnimalService = new CreateAnimalService() {
            @Override
            public void createAnimals() {
                CreateAnimalService.super.createAnimals();
            }
        };
        createAnimalService.createAnimals();
        new CreateAnimalServiceImpl().createAnimals();
        new CreateAnimalServiceImpl().createAnimals(5);
    }
}