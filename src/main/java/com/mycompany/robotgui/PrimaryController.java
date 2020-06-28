package com.mycompany.robotgui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/** PrimaryController.java
 * 
 * Controls the primary.fxml file.
 * 
 * @author Ryan Veitenheimer
 */

public class PrimaryController {

    //Creates a grid and a robot.
    Grid grid = new Grid(25, 25);
    Robot robot = new Robot("Mr. Roboto", 0, 0, ' ');

    //Shows the grid.
    @FXML
    private TextArea GridScreen;

    //Shows the location of the robot.
    @FXML
    private TextArea Messages;
    
    /** initialize()
     * 
     * Starting state of app.
     * 
     */
    
    public void initialize()
    {
        robot.useGrid(grid);
        grid.setValueAt(9, 9, 'H');
        grid.setValueAt(0, 0, 'P');
        GridScreen.setText(grid.print2D());
        Messages.setText(robot.print());
    }
    
    /** DropOff()
     * 
     * Robot drops off a character.
     * 
     * @param event 
     */
    
    @FXML
    void dropOff(MouseEvent event) {
            
        robot.dropOff(robot.getX(), robot.getY());
        GridScreen.setText(grid.print2D());
        Messages.setText(robot.print());
        
    }

    /** moveDown()
     * 
     * Robot moves down on grid.
     * 
     * @param event 
     */
    
    @FXML
    void moveDown(MouseEvent event) {
        robot.moveDown();
        Messages.setText(robot.print());
    }

    /** moveLeft()
     * 
     * Robot moves left on grid.
     * 
     * @param event 
     */
    
    @FXML
    void moveLeft(MouseEvent event) {
        
        robot.moveLeft();
        Messages.setText(robot.print()); 
    }

    /** moveRight()
     * 
     * Robot moves right on grid.
     * 
     * @param event 
     */
    
    @FXML
    void moveRight(MouseEvent event) {
        
        robot.moveRight();
        Messages.setText(robot.print());
    }

    /** moveUp()
     * 
     * Robot moves up on grid.
     * 
     * @param event 
     */
    
    @FXML
    void moveUp(MouseEvent event) {
        
        robot.moveUp();
        Messages.setText(robot.print());
    }

    /** pickUp()
     * 
     * Robot picks up character.
     * 
     * @param event 
     */
    
    @FXML
    void pickUp(MouseEvent event) {
        robot.pickUp(robot.getX(), robot.getY());
        GridScreen.setText(grid.print2D());
        Messages.setText(robot.print());
    }
}