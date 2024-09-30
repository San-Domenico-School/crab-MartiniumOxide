import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This class constructs the enemy, lobster, which will swim and
 * accelerate towards the crab after colliding with the wall
 * it will stop when it collide with the wall again
 * it will not change direction during the movement
 * it only changes direction after it stops
 * @author Martin Peng
 * @version Sep 26, 2024
 */
public class Lobster extends Actor
{
    //Lobster fields
    private int speed = 0;
    //speed of lobster
    private double acceleration = 1.0;
    //acceleration of lobster
    private double maxSpeedTurn = 2;
    //maximum speed that it can turn
    private double maxSpeed = 2;
    //its maximum speed
    private int deltaMS;
    //change in maximum(turn) speed
    
    //actions
    public void act()
    {
        lobsterOrientation();
        //orient the lobster
        lobsterMovement();
        //accleration and collision
        updateMax();
        //updating the new maxSpeed and maxSpeedTurn
    }
    
        //orient the lobster to the direction of the crab
        private void lobsterOrientation()
       {
           // Get the current world
            CrabWorld world = (CrabWorld) getWorld(); 
            //orient the lobster when its speed is less or equal to max speed
            if (speed <=maxSpeedTurn)
            {
                // Retrieve the list of Crab objects in the world
                List<Crab> crabs = world.getObjects(Crab.class);
                //check if there is any crabs
                if (!crabs.isEmpty()) 
                {
                    Crab closestCrab = crabs.get(0); 
                    // Get the first crab
                    
                    // Get the crab's coordinates
                    int crabX = closestCrab.getX();
                    int crabY = closestCrab.getY();
                    //orient the lobster
                    turnTowards(crabX, crabY);
                }
            }
            
        }
        
        //accelerate the lobster towards the crab
        private void lobsterMovement()
        {
            move(speed);
            //always moving with this speed variable
            if (getX() <= 10||
                getWorld().getWidth()-10 <= getX()||
                getY() <= 10||
                getWorld().getHeight()-10 <= getY()
            )//set boundary of collision
            {
                speed = -1;//reset speed
                lobsterAcceleration();//re-accelerate
            }
            
            lobsterAcceleration();//accelerate when not colliding with wall
            
            lobsterCollision();//collision with crab
        }
            
            //accelerate the crab
            private void lobsterAcceleration()
            {
                if (speed <= maxSpeed)
                {
                    speed += acceleration;//set acceleration of the lobster
                }
            }
            
            //collision with the crab
            private void lobsterCollision()
            {
                
                // Get all crabs currently touching the lobster
                List<Crab> crabs = getIntersectingObjects(Crab.class); 
                for (Crab crab : crabs) 
                {
                    // remove the crab when colliding with it
                    getWorld().removeObject(crab);
                    speed = -1; // Stop the lobster upon collision
                }
            }
        
        //update the maximum speeds when the player has eaten one more worm
        private void updateMax()
        {
            //get the world
            CrabWorld world = (CrabWorld) getWorld(); 
            //get the list of crabs
            List<Crab> crabs = world.getObjects(Crab.class);
            //get the wormsEaten data from the crab class
            if(!crabs.isEmpty())
            {
                Crab crab = crabs.get(0);
                deltaMS = crab.wormsEaten;
            }
            //update the fields in the lobster class
            maxSpeed = deltaMS;
            maxSpeedTurn = deltaMS*3/4;
            acceleration -= deltaMS/10;
        }
}
