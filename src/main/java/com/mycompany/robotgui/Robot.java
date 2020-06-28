package com.mycompany.robotgui;

/** Robot.java
 *
 * Creates a robot that moves around characters on a grid.
 * 
 * @author Ryan Veitenheimer
 */

public class Robot {

    private String nameOfRobot;
    private int x;
    private int y;
    private char payload;
    private Grid grid;

    /** Robot()
     * 
     * Default constructor.
     * 
     */
    
    public Robot() {
        
        nameOfRobot = "Unnamed Robot";
        x = 0;
        y = 0;
        payload = ' ';
    }
    
    /** Robot()
     * 
     * Parameter constructor.
     * 
     * @param nameOfRobot : what is the robot called?
     * @param x : starting x location.
     * @param y : starting y location.
     * @param payload : starting character load.
     */
    
    public Robot(String nameOfRobot, int x, int y, char payload) {
        
        this.nameOfRobot = nameOfRobot;
        this.x = x;
        this.y = y;
        this.payload = payload;
    }
    
    /** setNameOfRobot()
     * 
     * Changes the robot name.
     * 
     * @param nameOfRobot 
     */
    
    public void setNameOfRobot(String nameOfRobot) {
        
        this.nameOfRobot = nameOfRobot;
    }
    
    /** SetX()
     * 
     * Changes the x location of the robot.
     * 
     * @param x 
     */
    
    public void setX(int x) {
        
        this.x = x;
    }

    /** setY()
     * 
     * Changes the y location of the robot.
     * 
     * @param y 
     */
    
    public void setY(int y) {
        
        this.y = y;
    }

    /** setPayload()
     * 
     * Changes the payload of the robot.
     * 
     * @param payload 
     */
    
    public void setPayload(char payload) {
        
        this.payload = payload;
    }

    /** getNameOfRobot()
     * 
     * @return name of robot
     */
    
    public String getNameOfRobot() {
        
        return nameOfRobot;
    }
    
    /** getX()
     * 
     * @return x location
     */
    
    public int getX() {
        
        return x;
    }

    /** getY()
     * 
     * @return y location.
     */
    
    public int getY() {
        
        return y;
    }

    /** getPayload()
     * 
     * @return payload
     */
    
    public char getPayload() {
        
        return payload;
    }
    
    /** Print()
     * 
     * Prints the robot information
     * 
     * @return string
     */
    
    public String print() {
        
        return String.format("%s is at location (%d, %d) with a payload of %c%n", 
                getNameOfRobot(), getX(), getY(), getPayload());
    }
    
    /** robotIsAtLocation()
     * 
     * Checks if robot is at a specified location.
     * 
     * @param lx : requested x location
     * @param ly : requested y location
     * @return boolean
     */
    
    private boolean robotIsAtLocation(int lx, int ly)
    {
        boolean robotIsAtLocation = false;
        
        //
        if((x == lx) && (y == ly))
        {
            robotIsAtLocation = true;
        }
        
        return robotIsAtLocation;
    }
    
    /** pickUp()
     * 
     * Robot picks up a character.
     * 
     * @param lx
     * @param ly
     * @return boolean
     */
    
    public boolean pickUp(int lx, int ly) {
        
        boolean loadIsPickedUp = false;
        
        //Checks if location contains a character.
        if(grid.getValueAt(lx, ly) == ' ')
        {
            System.out.println("No load at this location");
        }
        
        //Checks if robot is at requested location.
        if(robotIsAtLocation(lx, ly))
        {
            //Checks if grid element is not blank.
            if(grid.getValueAt(lx, ly) != ' ')
            {
                //Checks if payload is not blank.
                if(getPayload() == ' ')
                {
                    //Robot takes new payload. Grid location replaced with blank.
                    setPayload(grid.getValueAt(lx, ly));
                    loadIsPickedUp = true;
                    grid.setValueAt(lx, ly, ' ');
                }
            }
        }
        //Outputs if robot is not at requested location.
        else
        {
            System.out.printf("Not at (%d, %d)%n", lx, ly);
        }
        
        return loadIsPickedUp;
    }

    /** dropOff()
     * 
     * Robot drops off a character.
     * 
     * @param lx
     * @param ly
     * @return boolean
     */
    
    public boolean dropOff(int lx, int ly) {
        
        boolean loadIsDroppedOff = false;
        
        //Checks if robot is at requested location.
        if(robotIsAtLocation(lx, ly))
        {
            //Checks if payload is not empty and that grid location is empty.
            if((getPayload() != ' ') && (grid.getValueAt(lx, ly) == ' '))
            {
                //Sets the grid location to the robot's payload.
                grid.setValueAt(lx, ly, getPayload());
                setPayload(' ');
                loadIsDroppedOff = true;
            }
        }
        //Outputs if robot is not at requested location.
        else
        {
            System.out.printf("Not at (%d, %d)%n", lx, ly);
        }
        
        return loadIsDroppedOff;
    }

    /** moveRight()
     * 
     * Move the robot right 1 unit.
     * 
     */
    
    public void moveRight() {
        
        //Checks if the robot is located within the gird boundary.
        if(x != grid.getNumberOfColumns() - 1)
        {
            x++;
        }
        //Advises user that grid boundary is reached.
        else
        {
            System.out.println("Right boundary reached");
        }
    }

    /** moveLeft()
     * 
     * Move the robot left 1 unit.
     * 
     */
    
    public void moveLeft() {
        
        //Checks if the robot is located within the gird boundary.
        if(x != 0)
        {
            x--;
        }
        //Advises user that grid boundary is reached.
        else
        {
            System.out.println("Left boundary reached");
        }
    }

    /** moveUp()
     * 
     * Move the robot up 1 unit.
     * 
     */
    
    public void moveUp() {
        
        //Checks if the robot is located within the gird boundary.
        if(y != 0)
        {
            y--;
        }
        //Advises user that grid boundary is reached.
        else
        {
            System.out.println("Top boundary reached");
        }
    }

    /** moveDown()
     * 
     * Move the robot down 1 unit.
     * 
     */
    
    public void moveDown() {
        
        //Checks if the robot is located within the gird boundary.
        if(y != grid.getNumberOfRows() - 1)
        {
            y++;
        }
        //Advises user that grid boundary is reached.
        else
        {
            System.out.println("Bottom boundary reached");
        }
    }

    /** moveTO()
     * 
     * Moves robot to an requested location.
     * Moves one unit at a time.
     * 
     * @param lx
     * @param ly
     * @return 
     */
    
    public boolean moveTo(int lx, int ly) {
        
        boolean robotHasMovedToLocation  = false;
        
        //Checks if x location is within grid boundary.
        if((x < grid.getNumberOfColumns()) && (x >= 0))
        {
            //Checks if the y location is within the grid boundary.
            if((y < grid.getNumberOfRows()) && (y >= 0))
            {
                //Loops until current x is at requested x.
                while(x != lx)
                {
                    //Moves right if current x is less than requested x.
                    if(x < lx)
                    {
                        moveRight();
                    }
                    //Moves left if greater than requested x.
                    else
                    {
                        moveLeft();
                    }
                }
                
                //Loops until current y is at requested y.
                while(y != ly)
                {
                    //Moves right if current y is less than requested y.
                    if(y < ly)
                    {
                        moveDown();
                    }
                    //Moves up if greater than requested y.
                    else
                    {
                        moveUp();
                    }
                }
                robotHasMovedToLocation = true;
            }
        }
        
        return robotHasMovedToLocation;
    }

    /** useGrid()
     * 
     * Chooses a grid for the robot to move on.
     * 
     * @param grid 
     */
    
    public void useGrid(Grid grid) {
        
        this.grid = grid;
    }
}