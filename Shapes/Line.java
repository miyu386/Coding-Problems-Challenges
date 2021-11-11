package shapes;
import java.awt.*;

public class Line implements Drawable {
	/**
	 * A Line is an object representing a line. A Line has a starting point with coordinates 
	 * (x1,y1), a ending point with coordinates (x2,y2) and a color. It can be moved, translated, scaled and drawn.
	 */
	private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color theColor;
    private boolean isVisible;
	
    /**
     * Construct a new Sqaure with a upper left corner at initX, initY with a side length of
     * initsideLength and color indicated by initColor. The new Square is visible by
     * default.
     * 
     * @param initX the x coordinate of the center of the square.
     * @param initY the y coordinate of the center of the square.
     * @param initSideLength the radius of the square.
     * @param initColor the color of the square.
     */
    public Line (int initX1, int initY1, int initX2, int initY2, Color initColor) {
        x1 = initX1;
        y1 = initY1;
        x2 = initX2;
        y2 = initY2;
        theColor = initColor;
        isVisible = true;
    }
    
    /**
     * Get the x coordinate of the starting point.
     * 
     * @return the x coordinate
     */
    public int getX1() {
        return x1;
    }

    /**
     * Get the y coordinate of the starting point.
     * 
     * @return the y coordinate
     */
    public int getY1() {
        return y1;
    }
    
    /**
     * Get the x coordinate of the ending point.
     * 
     * @return the x coordinate
     */
    public int getX2() {
        return x2;
    }

    /**
     * Get the y coordinate of the ending point..
     * 
     * @return the y coordinate
     */
    public int getY2() {
        return y2;
    }
    
    /**
     * Move the starting point of Line to a new location. This method changes the starting point of the line
     * using the values provided by the parameters.
     * 
     * @param newX the new x coordinate
     * @param newY the new y coordinate
     */
    public void moveStart(int newX, int newY) {
        x1 = newX;
        y1 = newY;
    }
    
    /**
     * Move the ending point of Line to a new location. This method changes the ending point of the line
     * using the values provided by the parameters.
     * 
     * @param newX the new x coordinate
     * @param newY the new y coordinate
     */
    public void moveEnd(int newX, int newY) {
        x2 = newX;
        y2 = newY;
    }

    /**
     * Move the Line relative to its current location. The starting point and the ending point of the
     * Line are moved by adding the parameters to the Line's current
     * location.
     * 
     * @param deltaX the change in the x coordinate. Positive values move the
     *            Line to the right, negative values move it to the left.
     * @param deltaY the change in the y coordinate. Positive values move the
     *            Line down, negative values move it up.
     */
    public void translate(int deltaX, int deltaY) {
        x1 = x1 + deltaX;
        y1 = y1 + deltaY;
        x2 = x2 + deltaX;
        y2 = y2 + deltaY;
    }


    // === Implementation of the Drawable interface ===

    /**
     * Draw this DrawableLine onto the specified Graphics object.
     * 
     * @param g the Graphics object on which to draw this DrawableLine.
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

    /**
     * Get the Color of this Line.
     * 
     * @return the color.
     */
    public Color getColor() {
        return theColor;
    }

    /**
     * Change the color of this Line to the newColor.
     * 
     * @param newColor the new color.
     */
    public void setColor(Color newColor) {
        theColor = newColor;
    }

    /**
     * Set whether or not this Line will be visible. If it is visible its draw
     * method will be invoked when the DrawingTablet is repainted. If it is not
     * visible its draw method will not be invoked.
     * 
     * @param visible true to make this Line visible, false to make it
     *            invisible.
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    /**
     * Find out if this Line is visible or not.
     * 
     * @return true if the Line is visible, false if it is not.
     */
    public boolean isVisible() {
        return isVisible;
    }
}