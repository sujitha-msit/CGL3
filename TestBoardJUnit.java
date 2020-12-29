/**
 * 
 */
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * @author Sujitha
 *
 */
public class TestBoardJUnit {
	
	@Test
	public void testCreateBoard()
	{
		int dimensions=5;
		ArrayList<Cell> livecells =new ArrayList<Cell>();
		livecells.add(new Cell(2,3));
		livecells.add(new Cell(3,3));
		livecells.add(new Cell(4,4));
		Board b=new Board(livecells,dimensions);
		System.out.println("########### First Test Case Passed###########");
		b.createBoard();
		assertEquals(".....\n.....\n...*.\n...*.\n....*",b.toString());
	
	}
	@Test
	public void generateBoard()
	{
		int dimensions=5;
		ArrayList<Cell> livecells =new ArrayList<Cell>();
		livecells.add(new Cell(2,3));
		livecells.add(new Cell(3,3));
		livecells.add(new Cell(4,4));
		livecells.add(new Cell(4,3));
		Board b=new Board(livecells,dimensions);
		System.out.println("########Generate board passed#############");
		b.generateBoard();
		assertEquals(".....\n.....\n.....\n..**.\n...**",b);
	}
	@Test
	public void testAliveCount()
	{
		int dimensions=5;
		ArrayList<Cell> livecells =new ArrayList<Cell>();
		livecells.add(new Cell(2,3));
		livecells.add(new Cell(3,3));
		livecells.add(new Cell(4,4));
		Board b=new Board(livecells,dimensions);
		System.out.println("########live cells Count around the cell passed.");
		assertEquals("1",b.liveCountAround(2,3));
	}

}
