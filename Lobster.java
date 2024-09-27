import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    private int turnSpeed = 0;
    
    private double orientation = 0;

    
    
    public void act()
    {
        lobsterOrientation();//orient the lobster
        lobsterMovement();//acclerate the lobster
        lobsterCollision();//collision
    }
    
        //orient the lobster to the direction of the crab
        private void lobsterOrientation()
       {
           //how
       }
        
        
        
        //accelerate the lobster towards the crab
        private void lobsterMovement()
        {
            //to be implemented
        }
        
        //stop the lobster when colliding with the boundary
        private void lobsterCollision()
        {
            //to be implemented
        }
}
