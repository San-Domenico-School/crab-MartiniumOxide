import greenfoot.*;

/**
 * This class constructs the player, a crab and behaviors to
     * provide gameplay including user input, moving, turning, changing speed
     * and changing turning speed.
     * the crab eats the worms and win when eaten all the worms
     * the crab dies when being eaten by the lobster
     * author: Martin, Bryce, Leo, Brittney
     * version: Sep 26, 2024
*/
public class Crab extends Actor
{
    // 
      //crab fields
           private boolean keyPress; //key press true or false
           
           private int speed = 0;
           
           private int turnSpeed = 0;
           
           
    // After the fields place the behaviors
    
    public void act()
    {
        crabMovement();
        turn();
        changeSpeed();
        changeTurnSpeed();
    }
    
    
           /*will change x and y position of crab at magnitude = to speed on key press and stop movement 
             when keypress = false.
           */
           private void crabMovement()
           {
               if(Greenfoot.isKeyDown("up")){
               move(speed);
            }
           }
           
           
           /*will trigger the turn motion of the crab if atCorner = true.
           */
           private void turn()
           {
               //set initial orientation
               
               //turn left
               if(Greenfoot.isKeyDown("left"))
               {    
                   turn(turnSpeed);
                }
                
                //turn right
               if(Greenfoot.isKeyDown("right"))
               {
                   turn(-turnSpeed);
                   
                }
           }
           
           private void changeSpeed()
           {
               if(Greenfoot.isKeyDown("w"))
               {
                   speed += 3;
                }
               if(Greenfoot.isKeyDown("s"))
               {
                   speed -= 3;
                }
           }
           
           private void changeTurnSpeed()
           {
               if(Greenfoot.isKeyDown("a")){
                   turnSpeed -= 1;
            }
               if(Greenfoot.isKeyDown("d")){
                   turnSpeed += 1;
            }
           }
}


