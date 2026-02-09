package test;

import static org.junit.Assert.*;
import org.junit.*;

import island.*;
import island.constants.Color;

/**
 * This is a JUnit test class, used to test code
 * 
 * You should test the SmartCat class by designing Island test cases
 * and filling in the JUnit tests according to the assignment
 * description.
 * 
 * @author Colin Sullivan
 */
public class SmartCatTest {

    public static Island pathIsland = new Island(new String[][] {

            { "L", "W", "L", "L", "L", "W", "Y"},
            { "L", "W", "L", "W", "L", "W", "L"},
            { "L", "W", "L", "W", "L", "W", "L"},
            { "L", "W", "L", "W", "L", "W", "L"},
            { "L", "W", "L", "W", "L", "W", "L"},
            { "L", "W", "L", "W", "L", "W", "L"},
            { "L", "L", "L", "W", "L", "L", "L"}
    });

    public static Island yarnIsland = new Island(new String[][] {
            
            { "L", "L", "L", "L", "L", "L", "L", "L", "L" },
            { "L", "Y", "W", "W", "L", "Y", "W", "Y", "L" },
            { "L", "W", "L", "L", "L", "W", "L", "W", "L" },
            { "L", "Y", "W", "Y", "W", "W", "Y", "W", "L" },
            { "L", "L", "L", "W", "L", "L", "L", "L", "L" },
            { "L", "W", "W", "W", "W", "W", "W", "Y", "L" },
            { "L", "L", "L", "L", "L", "L", "L", "L", "L" },
            { "L", "Y", "W", "Y", "W", "Y", "W", "Y", "L" },
            { "L", "L", "L", "L", "L", "L", "L", "L", "L" }
    });

    public static Island mazeIsland = new Island(new String[][] {
            { "L", "W", "L", "L", "L", "W", "L", "L", "L", "L"},
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"},
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"},
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"},
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"},
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"},
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"}, 
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"}, 
            { "L", "W", "L", "W", "L", "W", "L", "W", "L", "L"},
            { "L", "L", "L", "W", "L", "L", "L", "W", "L", "L"}
    });

    @Test
    public void testWalkPath() {
        
        SmartCat SM = new SmartCat("SM", SmartCatTest.pathIsland, 0, 0, Color.BROWN);
        SM.walkPath();
        
        
        assertEquals(0, SM.getRow());
        assertEquals(6, SM.getCol());

        
        //assetTrue(condition)
        //assetFalse(condition)
        //assertEquals(expected, actual)

    }

    @Test
    public void testCollectAllYarn() {
        
        SmartCat YN = new SmartCat("YN", SmartCatTest.yarnIsland, 0, 0, Color.BLACK);
        YN.collectAllYarn();
        Tile[][] tiles = SmartCatTest.yarnIsland.getTiles();

        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                assertFalse(
    "Yarn still found at (" + r + ", " + c + ")",
    tiles[r][c].hasYarn);  // no parentheses

            }
        }

    }

    @Test
    public void testSolveMaze() {
       
        SmartCat MM = new SmartCat("MM", SmartCatTest.mazeIsland, 0, 0, Color.WHITE);
        MM.solveMaze();
        
        assertEquals(9, MM.getRow());
        assertEquals(9, MM.getCol());
        assertTrue(MM.numStepsTaken() >= 30);


    }

}
