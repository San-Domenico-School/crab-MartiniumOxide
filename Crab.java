import greenfoot.*;
import java.util.List;
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
           private boolean keyPress; 
           //key press true or false           
           private int speed = 10;
           //initial speed of player
           private int turnSpeed = 3;
           //initial turn speed of player
           public int wormsEaten = 0;
           //worms eaten
           private int maxSpeed = 11;
           //maximum speed of player
    
    //the action
    public void act()
    {
        crabMovement();//forward and backward
        turn();//left and right rotation
        changeSpeed();//change of speed
        changeTurnSpeed();//change of turn speed
        eatWorms();//interact with the worms class
        win();//celebration
    }
    
    
           /*will change x and y position of crab at magnitude = to speed on key press and stop movement 
             when keypress = false.
           */
           private void crabMovement()
           {
               if(Greenfoot.isKeyDown("up"))
               {
               move(speed);
                }   
                if(Greenfoot.isKeyDown("down"))
                {
                    move(-speed);
                }
           }
           
           
           /*will trigger the turn motion of the crab if "left" or "right" is
            * being pressed
           */
           private void turn()
           {
               //set initial orientation
               
               //turn left
               if(Greenfoot.isKeyDown("left"))
               {    
                   turn(-turnSpeed);
                }
                
                //turn right
               if(Greenfoot.isKeyDown("right"))
               {
                   turn(turnSpeed);
                   
                }
           }
           
           //will change the speed when pressing "w" or "s"
           private void changeSpeed()
           {
               if (speed <= maxSpeed)
               {
                   if(Greenfoot.isKeyDown("w"))
                   {
                       speed += 1;
                    }
                   if(Greenfoot.isKeyDown("s"))
                   {
                       speed -= 1;
                    }
                }
            }
            
            /*will change the turning speed when key "a" or "d" is 
             * being pressed
             * 
             */
           private void changeTurnSpeed()
           {
               if(Greenfoot.isKeyDown("a"))
               {
                   turnSpeed -= 1;
                }
               if(Greenfoot.isKeyDown("d"))
               {
                   turnSpeed += 1;
                }
           }
           
           //will eat the worms when they collide
           private void eatWorms()
           {
            //get all of the worms
            List<Worm> worms = getIntersectingObjects(Worm.class); 
            /*remove the worm, increase max speed and print the number
             * of worms eaten on the console screen
             */
            for (Worm worm : worms)
            {
                // Example action: Remove the crab
                getWorld().removeObject(worm);
                wormsEaten ++;
                maxSpeed ++;
                System.out.println("worms eaten: " + wormsEaten);
                Greenfoot.playSound("slurp.wav");
            }
            
           }
           
           //win when eaten all the worms
           private void win()
           {
               if (wormsEaten == 10)
            {
                System.out.println("You won! " + "\uD83D\uDE00");
                Greenfoot.playSound("fanfare.wav");
                getWorld().showText("You Won", getWorld().getWidth()/2,
                                               getWorld().getHeight()/2);
                wormsEaten ++;
            }
           }
}


