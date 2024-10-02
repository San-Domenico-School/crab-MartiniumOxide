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
    private Crab crab;
    
    
    
    public Lobster(Crab crab)
    {
        this.crab = crab;
    }
    
    
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
            //get the list of crabs
            List<Crab> crabs = getWorld().getObjects(Crab.class);
            //orient the lobster when its speed is less or equal to max speed
            if (speed <=maxSpeedTurn && !crabs.isEmpty() )
            {
                    turnTowards(crab.getX(), crab.getY());
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
                Crab collidingCrab = (Crab) getOneIntersectingObject(Crab.class); 
                // remove the crab when colliding with it
                if(collidingCrab != null)
                {
                    System.out.println("You Lost...");
                    Greenfoot.playSound("au.wav");
                    speed = 0; // Stop the lobster upon collision
                    getWorld().removeObject(crab);
                }
                
                
                
            }
        
        //update the maximum speeds when the player has eaten one more worm
        private void updateMax()
        {
            //get the list of crabs
            List<Crab> crabs = getWorld().getObjects(Crab.class);
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
