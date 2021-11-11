package shapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DrawableObjectListTest {
	DrawableObjectList testList;
	Drawable c1;
	Drawable c2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testList= new DrawableObjectList();
		c1 = new Circle(1,1,1,Color.blue);
		c2 = new Circle(2,2,2,Color.red);
		
	}

	@Test
	public void constructorTest() {
		assertEquals("constructor is wrong.",0,testList.getSize());
	}
	
	@Test
	public void getSizeTest() {
		assertEquals("getSize is wrong.",0,testList.getSize());
		testList.addDrawable(c1);
		assertEquals("getSize is wrong.",1,testList.getSize());
	}
	
	@Test
	public void addDrawableTest() {
		testList.addDrawable(c1);
		assertEquals("addDrawable is wrong.",1,testList.getSize());
	}
	
	@Test
	public void removeDrawableTest() {
		testList.addDrawable(c1);
		assertEquals("",1,testList.getSize());
		testList.removeDrawable(c1);
		assertEquals("removeDrawable is wrong.",0,testList.getSize());
	}
	
	@Test
	public void scaleAllTest() {
		testList.addDrawable(c1);
		testList.addDrawable(c2);
		testList.scaleAll(2);
		Circle c1cast = (Circle) c1;
		assertEquals("scaleAll is wrong.",2,c1cast.getRadius());
		Circle c2cast = (Circle) c2;
		assertEquals("scaleAll is wrong.",4,c2cast.getRadius());
	}
	
	


}
