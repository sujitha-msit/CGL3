/****
 * Importing the required packages for the class Game.
 */
import java.util.ArrayList;
/**
 * <p> Title: Game. </p>
 * 
 * <p> Description: A component of the Conveys Game application </p>
 * 
 * <p> Copyright: Sujitha J © 2020 </p>
 * 
 * @author Sujitha J
 * 
 * @version 0.01	2020-12-22	Initial baseline where created only dummy methods
 * @version 0.02	2020-12-24	created a object for the Board with live cells and dimensions
 * @version 0.03	
 * 
 * 
 */
/*************
 * This class will generate a board object and generate the current generation with the given input 
 * from the console and generate the next generations boards..
 * 
 */

public class Game {
    //These are the attributes of the Game Class
    public Board b;
    public ArrayList<Cell> liveCells;
    public int dimensions;
    //Constructor will intialise the board with livecells and dimensions 
    public Game(ArrayList<Cell> liveCells,int dimensions)
    {
        this.liveCells=liveCells;
        this.dimensions=dimensions;
        b=new Board(this.liveCells,this.dimensions);
    }
    //This method will start the Game with current livecells as input and generate next Generation boards.
    public void startGame()
    {
      
        System.out.println("************This is the current Board*********************");
        b.createBoard();//Call to create a board with Board object.
        System.out.println(b);
        int i=1;//Intialising the i value
        while(i<=4)//Generating next four generations of the current board.
        {
            System.out.println("************This is  Generation "+i+"*********************");
            b.generateBoard();//This is the call to generate the nextBoard 
            i++;//incrementing the count 
            System.out.println(b);//Printing the board
        }

    }
    
}
