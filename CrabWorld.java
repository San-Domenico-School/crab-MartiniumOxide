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
        addPlayer();
        addWorm();
        addLobster();
    }
    /*prepare the world for the start the of the program
     * 
     */
    private void prepareScene()
    {
        System.out.println("Scene prepared");
    }

    //adds player into the scene
    private void addPlayer()
    {
        //instantiate new objects
        Crab crab = new Crab();
        
        //add it to the world
        addObject(crab, 280,280);
        

    }   
    
    private void addWorm()
    {
        //instantiate new worms
        Worm[] worms = new Worm[10];
        //randomize their spawning location
        
        for (int i = 0; i < 10; i++)
        {
            int xCoordinate = (int)(Math.random() * getWidth());
            int yCoordinate = (int)(Math.random() * getHeight());
            worms[i] = new Worm();
            addObject(worms[i], xCoordinate, yCoordinate);
        //associate each random x and y coordinates to each new worm
        }
        
                //add it to the world
        
    }     

    private void addLobster()
    {
        //new lobster
    }


//new methods
}