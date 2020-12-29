/*These are few packages we import as part of our program
* as we are using ArrayList we import the ArrayList from utility package.
*/
import java.util.ArrayList;
import java.util.List;
/**
 * <p> Title: Board. </p>
 * 
 * <p> Description: A component of the Conveys Game application </p>
 * 
 * <p> Copyright: Sujitha J © 2020 </p>
 * 
 * @author Sujitha J
 * 
 * @version 0.01	2020-12-22	Initial baseline where created only dummy methods
 * @version 0.02	2020-12-23	Generated create and Generate methods with arrays
 * @version 0.03	2020-08-24	Generated generateBoard with ArrayList
 * @version 0.04	2020-08-    Yet to be developed with graphics
 * 
 */
/**********
	 * This class defines the boolean board with 2d-array with given dimensions
	 * In the constructor will be passing an ArrayList of live cells in the board represents with  
	 * String "*" .we create a board and calculate the count of live cells around it.
	 * For a live Cell "*" to be alive in the next generation it should have either 2 or 3
     *  live cells around it 
	 * If the count of livecells around the livecell is less than 2 it will die
       with under population condition.
     * If the count of livecells around the livecell is greater than 3 it will die with
       over population condition.
     * For a dead cell which is represented as "." in the board will be alive if the livecells
       around it is exactly 3.
     * we will print the board with the help of toString method.
     * once generating the nextgeneration board,it will pass the  nextgeneration board 
       as the input for the upcoming generation board.
     * 
	 * 
	 * 
	 */


public class Board {

    //	The following are the class attributes that define the Board
    public boolean[][] board;
    public List<Cell> liveCells;
    public int dimensions;
    /*This is the constructor of the board with ArrayList of live cells
    and the dimension are given.
    */
    public Board(ArrayList<Cell> liveCells,int dimensions)
    {   this.dimensions=dimensions;
        this.board=new boolean[this.dimensions][this.dimensions];
        this.liveCells=liveCells;
    }
    /*This is the to String method of a class 
    * where we overwrite to print the board in
    * 2-d array with  given dimensions
    * with *-represents the live cell
    * with .-represensts the dead cell
    */
    public String toString()
    {
        String s="";
        for(int i=0;i<dimensions;i++)
        {
            for(int j=0;j<dimensions;j++)
            {
                if(board[i][j])//checking if the value in the board is true 
                {
                    s+="*";//appending a * if it is live cell
                }else{
                    s+=".";//appending a . if it is a dead cell
                }
            }s+="\n";//after every line we are inserting a new line in to the string
        }s.strip();//Removing or trailing the white spaces at the end of the string.
        return s;
    }
    /*This method will create a board at the current generation.
    * This is an input for the board to start the game.
    */
    public void createBoard()
    {
        for(int i=0;i<this.liveCells.size();i++)
            board[liveCells.get(i).getRow()][liveCells.get(i).getColumn()]=true;//this livecells is an ArrayList and we get the index and access the cell
                                                                                

    }
    /*This method will generate the  nextGeneration board with local variables
    * nextboard and we will save the nextGeneration live cells in the nextCells ArrayList
    */
    public void generateBoard()
    {
        int count=0;
        boolean[][] nextboard=new boolean[this.dimensions][this.dimensions];
        List<Cell> nextCells=new ArrayList<Cell>();
        //If we are encountering the first cell it will not have border cells.It might throw an Exception
            
            for(int i=0;i<liveCells.size();i++)
                {
                    count=liveCountAround(this.liveCells.get(i).getRow(),this.liveCells.get(i).getColumn());
                    if(count<2 || count>3)//if the liveCountAround of the live cells is less than 2 or greater than 3.In the next generation it will die
                        nextboard[this.liveCells.get(i).getRow()][this.liveCells.get(i).getColumn()]=false;
                    else if(count==2 || count==3)//if the livecountAround of the live cells is either 2 or3 it will be alive in the next generation.
                    {
                        nextboard[this.liveCells.get(i).getRow()][this.liveCells.get(i).getColumn()]=true;
                        nextCells.add(new Cell(this.liveCells.get(i).getRow(),this.liveCells.get(i).getColumn()));//whenever we encounter a true value cell in the next generation we will add it to the ArrayList.
                    }
                    for(int k=-1;k<=1;k++)
                        for(int j=-1;j<=1;j++)
                        if((this.liveCells.get(i).getRow()+k)>=0 && (this.liveCells.get(i).getRow()+k)<dimensions && (this.liveCells.get(i).getColumn()+j)>=0 && (this.liveCells.get(i).getColumn()+j)<dimensions)
                        {   
                            if(!board[this.liveCells.get(i).getRow()+k][this.liveCells.get(i).getColumn()+j])//checking for the dead cells which will be alive in the next generation.
                            {
                                count=liveCountAround(this.liveCells.get(i).getRow()+k,this.liveCells.get(i).getColumn()+j);
                                if(count==3)//if the dead cell has 3 live cells around it .It will be alive in the next generation.
                                {
                                nextboard[this.liveCells.get(i).getRow()+k][this.liveCells.get(i).getColumn()+j]=true;
                                nextCells.add(new Cell(this.liveCells.get(i).getRow()+k,this.liveCells.get(i).getColumn()+j));
                                }
                            }    
                        }else{}
                }
           
                this.board=nextboard;//we assigning the nextgeneration to board so this will be the input for the next upcoming board.
                this.liveCells=nextCells;//These are the live Cells in the next generation board.
            
    }
/*This method will return the number of live cells around it.
*/
    public int liveCountAround(int i,int j)
    {
        int county=0;
        if(i<board.length-1)
        {
        if(board[i+1][j])
        county++;
        }
        if(i>0)
        {
        if(board[i-1][j])
        county++;
        }
        if(j>0)
        {
        if(board[i][j-1])
        county++;
        }
        if(j<board.length-1)
        {
        if(board[i][j+1])
        county++;
        }
        if(i<board.length-1 & j>0)
        {
        if(board[i+1][j-1])
        county++;
        }
        if(i<board.length-1 & j<board.length-1)
        {
        if(board[i+1][j+1])
        county++;
        }
        if(i>0 &j>0)
        {
        if(board[i-1][j-1])
        county++;
        }
        if(i>0 & j<board.length-1)
        {
        if(board[i-1][j+1])
        county++;
        }
        return county;
    }
}
