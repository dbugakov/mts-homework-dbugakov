import Service.CreateAnimalServiceImpl;

public class Main {
    public static void main(String[] args) {
        new CreateAnimalServiceImpl().createAnimals();
        new CreateAnimalServiceImpl().createAnimals(5);
    }
}