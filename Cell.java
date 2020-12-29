/**
 * <p> Title: Cell. </p>
 * 
 * <p> Description: A component of the Conveys Game application </p>
 * 
 * <p> Copyright: Sujitha J © 2020 </p>
 * 
 * @author Sujitha J
 * 
 * @version 0.01	2020-12-22	Initial baseline where created only dummy methods
 * @version 0.02	2020-12-23	the Cell is intialized with the constructor.and getter and setter methods.
 * @version 0.03	
 * 
 * 
 */
/*************
 * This class has row and column and will be intialized with the help of constructor.
 */
public class Cell {
    private int row; //indicated  the row position of a cell in the board.
    private int column;//indicateds the coloumn position of a cell in the board.
    //Constructor of the class
    public Cell(int row,int column)
    {
        this.row=row;
        this.column=column;
    }

    public int getRow()//These are the getter method as the row is private .Can't be accessed directly
    {
        return this.row;
    }
    
    public int getColumn()//These are the getter method ofa varible where private variables can't be accessed directly.
    {
        return this.column;
    }

    
}
