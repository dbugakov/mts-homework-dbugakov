package Model.Asbtract;

import Model.AnimalClasses.Pets.Cat;
import Model.AnimalClasses.Pets.Dog;
import Model.AnimalClasses.Predators.Shark;
import Model.AnimalClasses.Predators.Wolf;
import Model.Interface.Animal;

public abstract class AbstractAnimal implements Animal {
    protected String breed; // порода
    protected String name; // имя
    protected Double cost; // цена в магазине
    protected String character; // характер

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    public static void getRandomAnimal() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                System.out.println(new Cat().toString());
                break;
            case 1:
                System.out.println(new Dog().toString());
                break;
            case 2:
                System.out.println(new Shark().toString());
                break;
            case 3:
                System.out.println(new Wolf().toString());
                break;
        }
    }
}
