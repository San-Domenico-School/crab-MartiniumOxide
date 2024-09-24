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
           
           private int speed; //magnitude of speed
         
           private boolean collision; //is true if collision with fruit

           private boolean isAtCorner; //is true if crab is colliding with corner

           private int yPosition; //position of crab y

           private int xPosition; //position of crab x
           
    // After the fields place the behaviors
    
           /*will change x and y position of crab at magnitude = to speed on key press and stop movement 
             when keypress = false.
           */
           private void crabMovement()
           {
               //to be implemented
           }
           
           /*will trigger the turn motion of the crab if atCorner = true.
           */
           private void turnAtCorner()
           {
               //to be implemented
           }

           /*will determine if collision is true or false using x/y position relative to fruit.
           */
           private void collision()
           {
               //to be implemented
           }

           public void act()
           {
               move(3);
           }
           
           public void faceDown()
           {
               turn(90);
           }
}


