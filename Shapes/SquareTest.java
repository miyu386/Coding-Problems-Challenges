package shapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {

	Square s1;

    @Before
    public void setUp() throws Exception {
        s1 = new Square(5,5,10,Color.red);
    }

    @Test
    public void testConstructor() {
        assertEquals("wrong x", 5, s1.getX());
        assertEquals("wrong y", 5, s1.getY());
        assertEquals("wrong side length", 10, s1.getSideLength());
        assertEquals("wrong color", Color.red, s1.getColor());
        assertTrue("should be visible", s1.isVisible());
    }
    
    @Test
    public void testSetColor() {
        s1.setColor(Color.blue);
        assertEquals("wrong color", Color.blue, s1.getColor());     
    }
    
    @Test
    public void testSetVisible() {
        s1.setVisible(false);
        assertFalse("should be invisible", s1.isVisible());
        
        s1.setVisible(true);
        assertTrue("should be visible", s1.isVisible());
    }
    
    @Test 
    public void testSetRadius() {
        s1.setSideLength(30);
        assertEquals("wrong side length", 30, s1.getSideLength());
        
        s1.setSideLength(-15);
        assertEquals("wrong side length", 15, s1.getSideLength());
    }
    
    @Test
    public void testMove() {
        s1.move(25,35);
        assertEquals("wrong x", 25, s1.getX());
        assertEquals("wrong y", 35, s1.getY());
    }
    
    @Test
    public void testTranslate() {
        s1.translate(5,5);
        assertEquals("wrong x", 10, s1.getX());
        assertEquals("wrong y", 10, s1.getY());
    }
    
    @Test
    public void testScale() {
        s1.scale(2.0);
        assertEquals("wrong side length", 20, s1.getSideLength());
        
        s1.scale(0.5);
        assertEquals("wrong side length", 10, s1.getSideLength());
        
        s1.scale(-2.0);
        assertEquals("wrong side length", 10, s1.getSideLength());
    }
}
