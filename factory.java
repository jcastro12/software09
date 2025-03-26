// interface
interface IAnimal
{
    void speak();
}

// dog class implementation
class Dog implements IAnimal
{
    @Override
    public void speak()
    {
        System.out.println("Woof");
    }
}

// cat class implementation
class Cat implements IAnimal
{
    @Override
    public void speak()
    {
        System.out.println("Meow");
    }
}

// factory class
class AnimalFactory
{
    // create animal method where the user will pass in the desired animal type
    public static IAnimal createAnimal(String type)
    {
        // dog
        if (type.equalsIgnoreCase("Dog"))
        {
            return new Dog();
        }
        // cat
        else if (type.equalsIgnoreCase("Cat"))
        {
            return new Cat();
        }
        else{
            System.out.println("Invalid animal provided");
            System.exit(0);
            return null;
        }
        // can easily add new animal types
    }
}

// main method to show factory in use
public class factory
{
    public static void main(String[] args)
    {
        IAnimal dog = AnimalFactory.createAnimal("Dog");
        IAnimal cat = AnimalFactory.createAnimal("Cat");

        dog.speak();
        cat.speak();
    }
}
