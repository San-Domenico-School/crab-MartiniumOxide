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
    /*prepare the world for the start the of the program
     * 
     */
    private void prepareScene()
    {
        
    }

    //adds player into the scene
    private void addPlayer()
    {
        //instantiate new objects
        Crab crab= new Crab();
        
        //add it to the world
        addObject(crab, 470,100);
        
        Crab crab2 = new Crab();
        addObject(crab2, 100, 50);
        crab2.faceDown();
    }
    
    //adds food into the scene for the player to eat
    private void addFood()
    {
        System.out.println("Food added");//for debugging
    }
    
    //adds enemy into the scene
    private void addEnemy()
    {
        System.out.println("Enemy added");//for debugging
    }
    

}