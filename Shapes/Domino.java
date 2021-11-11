package shapes;

import java.awt.*;

/**
 * Program that draws a domino in the
 * window.
 *
 * @author Billy, Josie
 * @author Dickinson College
 * @version 03/04/2020
 */
public class Domino {
	/**
     * Draw a multicolored domino in the window.
     * 
     * @param args none
     */
    public static void main(String[] args) {
    	DrawableObjectList objList = new DrawableObjectList();
    	DrawingTablet tablet = new DrawingTablet("Domino", 200, 400, objList);
    	Square s1 = new Square(0,0,200,Color.yellow);
    	Square s2 = new Square(0,200,200,Color.cyan);
    	Circle c1 = new Circle(50,50,25,Color.red);
    	Circle c2 = new Circle(100,100,25,Color.green);
    	Circle c3 = new Circle(150,150,25,Color.blue);
    	Circle c4 = new Circle(50,250,25,Color.pink);
    	Circle c5 = new Circle(150,355,25,Color.white);
    	objList.addDrawable(s1);
    	objList.addDrawable(s2);
    	objList.addDrawable(c1);
    	objList.addDrawable(c2);
    	objList.addDrawable(c3);
    	objList.addDrawable(c4);
    	objList.addDrawable(c5);
        tablet.repaint();

    }
}
