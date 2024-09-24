import greenfoot.*;

/**
 * This class constructs the player, a crab and behaviors to
     * provide gameplay including user input, moving and colliding
     * 
     * author: Martin, Bryce, Leo, Brittney
     * version: Sep 16, 2024
*/
public class Crab extends Actor
{
    // 
      //crab fields
           private boolean keyPress; //key press true or false
           
           private int yPosition; //position of crab y

           private int xPosition; //position of crab x
           
           private int speed = 0;
           
           private int turnSpeed = 0;
    // After the fields place the behaviors
    public void act()
    {
        movement();
    }
    
    private void movement()
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
               if(Greenfoot.isKeyDown("left"))
               {    
                   turn(turnSpeed);
                }
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


