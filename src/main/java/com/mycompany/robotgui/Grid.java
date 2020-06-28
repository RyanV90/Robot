package com.mycompany.robotgui;

/** Grid.java
 * 
 * Creates a grid for a robot to move on.
 *
 * @author Ryan Veitenheimer
 */

public class Grid {
    
    private char[][] grid;
    private final int numberOfRows;
    private final int numberOfColumns; 

    /** Grid()
     * 
     * Default grid constructor.
     * 
     */
    
    public Grid() {
        
        numberOfRows = 25;
        numberOfColumns = 25;
        initializeGrid();
    }
   
    /** Grid()
     * 
     * Parameter Grid constructor.
     * 
     * @param numberOfRows
     * @param numberOfColumns 
     */
    
    public Grid(int numberOfRows, int numberOfColumns) {
        
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        initializeGrid();
    }

    /** getNumberOfRows()
     * 
     * @return number of rows.
     */
    
    public int getNumberOfRows() {
        
        return numberOfRows;
    }

    /** getNumberOfColumns()
     * 
     * @return number of columns.
     */
    
    public int getNumberOfColumns() {
        
        return numberOfColumns;
    }

    /** initializeGrid()
     * 
     * Sets all elements of the grid to blank characters.
     * 
     */
    
    private void initializeGrid() {
        
        grid = new char[numberOfRows][numberOfColumns];
        
        //Loops through each row of grid.
        for (int row = 0; row < numberOfRows; row++) {
            //Loops through each column of each row.
            for (int column = 0; column < numberOfColumns; column++) {
                
                grid[row][column] = ' ';
            }
        }
    }

    /** getValueAt()
     * 
     * Returns the grid element at the requested location.
     * 
     * @param row
     * @param column
     * @return 
     */
    
    public char getValueAt(int row, int column)
    {
        return grid[row][column];
    }
    
    /** setValueAt()
     * 
     * Sets the grid element at the requested location.
     * 
     * @param row
     * @param column
     * @param newValueAtLocation 
     */
    
    public void setValueAt(int row, int column, char newValueAtLocation) {
        
        grid[row][column] = newValueAtLocation;
    }

    /** print2D()
    * 
    * Prints the grid as a String.
    *
    * @return grid.
    */
    
    public String print2D() {
        
        String output = " ";
        
        //Loops through each row of grid.
        for (int row = 0; row < numberOfRows; row++) {
            //Loops through each column of each row.
            for (int column = 0; column < numberOfColumns; column++) {
                
                output += String.format("%c \t", grid[column][row]);
            }
            output += "\n";
        }
        
    return output;
    }
}