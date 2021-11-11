package shapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class LineTest {

	Line l1;

    @Before
    public void setUp() throws Exception {
        l1 = new Line(5,5,20,20,Color.red);
    }

    @Test
    public void testConstructor() {
        assertEquals("wrong x1", 5, l1.getX1());
        assertEquals("wrong y1", 5, l1.getY1());
        assertEquals("wrong x2", 20, l1.getX2());
        assertEquals("wrong y2", 20, l1.getY2());
        assertEquals("wrong color", Color.red, l1.getColor());
        assertTrue("should be visible", l1.isVisible());
    }
    
    @Test
    public void testSetColor() {
        l1.setColor(Color.blue);
        assertEquals("wrong color", Color.blue, l1.getColor());     
    }
    
    @Test
    public void testSetVisible() {
        l1.setVisible(false);
        assertFalse("should be invisible", l1.isVisible());
        
        l1.setVisible(true);
        assertTrue("should be visible", l1.isVisible());
    }
    
    
    @Test
    public void testMoveStart() {
        l1.moveStart(20,25);
        assertEquals("wrong x", 20, l1.getX1());
        assertEquals("wrong y", 25, l1.getY1());
    }
    
    @Test
    public void testMoveEnd() {
        l1.moveEnd(35,45);
        assertEquals("wrong x", 35, l1.getX2());
        assertEquals("wrong y", 45, l1.getY2());
    }
    
    @Test
    public void testTranslate() {
        l1.translate(5,5);
        assertEquals("wrong x1", 10, l1.getX1());
        assertEquals("wrong y1", 10, l1.getY1());
        assertEquals("wrong x2", 25, l1.getX2());
        assertEquals("wrong y2", 25, l1.getY2());
    }
    
}