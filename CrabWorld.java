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
            addObject(crab, 10,10);
            
    
        }   
        
        private void addWorm()
        {
            //instantiate new worms
            Worm[] worms = new Worm[10];//creating ten new empty slots
            
            //randomize their spawning location
            for (int i = 0; i < 10; i++)//loop for each new worm
            {
                int xCoordinate = (int)(Math.random() * getWidth());
                //random x coordinate
                int yCoordinate = (int)(Math.random() * getHeight());
                //random y coordinate
                worms[i] = new Worm();
                //setting the new worm into a new empty slot
                addObject(worms[i], xCoordinate, yCoordinate);
                /*associate each random x and y coordinates to each new worm
                and add it to the CrabWorld
                 */
            }
            
            
        }     
    
        private void addLobster()
        {
            //instantiate new lobsters
            Lobster lobster = new Lobster();
            
            
            //setits spawning location 
            addObject(lobster, getWidth()-10, getHeight()-10);
        }
    
//new methods
}