/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author harry
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addCounterVisual method, of class Game.
     */
    @Test
    public void testAddCounterVisual() {
        System.out.println("addCounterVisual");
        int x = 0;
        BoardGui gui = null;
        Game instance = new Game();
        instance.addCounterVisual(x, gui);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkForLine method, of class Game.
     */
    @Test
    public void testLine() {
        System.out.println("line");
        int x = 0;
        int step = 0;
        Game instance = new Game();
        int expResult = 0;
        int result = instance.checkForLine(x, step);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompleteLine method, of class Game.
     */
    @Test
    public void testLine2() {
        System.out.println("line2");
        int x = 0;
        int step = 0;
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getCompleteLine(x, step);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkForWin method, of class Game.
     */
    @Test
    public void testWinner() {
        System.out.println("winner");
        int x = 0;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.checkForWin(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of whatColour method, of class Game.
     */
    @Test
    public void testWhatColour() {
        System.out.println("whatColour");
        Game instance = new Game();
        String expResult = "";
        String result = instance.whatColour();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
