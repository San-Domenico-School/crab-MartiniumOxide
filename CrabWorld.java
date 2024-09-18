import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    
    public CrabWorld() 
    {
        super(560, 560, 1);
        prepareScene();
    }
    
    private void prepareScene()
    {
        // instantiate new objects
        Crab crab = new Crab();
    
    
        // add them to the world
        addObject(crab, 250,250);
        // Fruit experiment
        Fruit fruit = new Fruit( );
        addObject(fruit, 100, 100);
        addObject(fruit, 200, 100);
        Fruit fruit2 = new Fruit( );
        addObject(fruit2, 300, 100);
        Fruit fruit3 = new Fruit("Strawberry");
        Fruit fruit4 = new Fruit("Banana");
        addObject(fruit3, 100, 200);
        addObject(fruit4, 200, 200);
        Fruit fruit5 = new Fruit("Cherry", 30, 1000, 1000);
        addObject(fruit5, 100, 500);


    }
}