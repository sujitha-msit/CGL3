/***
 * These are the few packages needed for Creating an ArrayList
 * Scanner object is used to read input from the console and importing the necessary packages.
 */
import java.util.ArrayList;
import java.util.Scanner;

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
 * @version 0.02	2020-12-24	created a object for the Game with live cells in the arrayList and dimensions
 * @version 0.03	
 */
/***
 * This is the class having main method where the execution starts for any application.
 * We are creating an object for Game class and reading the input from console so 
 * as to send those live cells ArrayList and dimensions into the Game object.
 */
public class TestClass {
    public static void main(String[] args) {//This  is the point where execution starts.
        Scanner scan=new Scanner(System.in);//Creating an object of the scanner.
        ArrayList<Cell> liveCells=new ArrayList<Cell>();//Creating an ArrayList 
        System.out.println("Please enter the dimensions of the array");
        int dimensions=scan.nextInt();//Taking input from the console
       Cell c1=new Cell(2,3);
        liveCells.add(c1);//adding cells to the ArrayList ..Indicating these are the live cells of the current board.
        liveCells.add(new Cell(3,3));

        liveCells.add(new Cell(4,3));
        liveCells.add(new Cell(4,4));
        liveCells.add(new Cell(2,4));
        liveCells.add(new Cell(3,4));
        Game game=new Game(liveCells,dimensions);//Creating an object for the game with Live cells and dimensions of the board.
        
        game.startGame();//calling the method startGame withe the game object.
        scan.close();//Closing the scanner object.

    }
}
