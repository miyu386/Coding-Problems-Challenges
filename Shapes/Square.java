package shapes;
import java.awt.*;

public class Square implements Drawable, Scaleable {
	/**
	 * A Square is an object representing a square. A Square has a upper left corner with coordinates 
	 * (x,y), a side length and a color. It can be moved, translated, scaled and drawn.
	 */
	private int x;
    private int y;
    private int sideLength;
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
    public Square (int initX, int initY, int initSideLength, Color initColor) {
        x = initX;
        y = initY;
        sideLength = initSideLength;
        theColor = initColor;
        isVisible = true;
    }
    
    /**
     * Get the x coordinate of the upper left corner of this Square.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate of the upper left corner of this Square.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Get the side length of this Square.
     * 
     * @return the sideLength
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     * Set the sideLength of this Square. The Square's sideLength is set to the absolute
     * value of the specified sideLength to eliminate any negative sideLength values.
     * 
     * @param newSideLength the sideLength of the new square.
     */
    public void setSideLength(int newSideLength) {
        sideLength = Math.abs(newSideLength);
    }
    
    /**
     * Move the Square to a new location. This method changes the upper left corner
     * of the Square using the values provided by the parameters.
     * 
     * @param newX the new x coordinate
     * @param newY the new y coordinate
     */
    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    /**
     * Move the Square relative to its current location. The upper left corner of the
     * Square is moved by adding the parameters to the Square's current
     * location.
     * 
     * @param deltaX the change in the x coordinate. Positive values move the
     *            Square to the right, negative values move it to the left.
     * @param deltaY the change in the y coordinate. Positive values move the
     *            Square down, negative values move it up.
     */
    public void translate(int deltaX, int deltaY) {
        x = x + deltaX;
        y = y + deltaY;
    }
    
    // === Implementation of the Scaleable interface ===
    /**
     * Scale this Square by the specified factor. For example a factor of 2.0
     * will make the sideLength twice as big and a factor of 0.5 will make it half
     * as large. If the factor is negative the sideLength is not changed.
     * 
     * @param factor the factor by which this Square is to be scaled.
     */
    public void scale(double factor) {
        if (factor > 0) {
            sideLength = (int) (Math.round(sideLength * factor));
        }
    }

    // === Implementation of the Drawable interface ===

    /**
     * Draw this DrawableSquare onto the specified Graphics object.
     * 
     * @param g the Graphics object on which to draw this DrawableSquare.
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), sideLength, sideLength);
    }

    /**
     * Get the Color of this Square.
     * 
     * @return the color.
     */
    public Color getColor() {
        return theColor;
    }

    /**
     * Change the color of this Square to the newColor.
     * 
     * @param newColor the new color.
     */
    public void setColor(Color newColor) {
        theColor = newColor;
    }

    /**
     * Set whether or not this Square will be visible. If it is visible its draw
     * method will be invoked when the DrawingTablet is repainted. If it is not
     * visible its draw method will not be invoked.
     * 
     * @param visible true to make this Square visible, false to make it
     *            invisible.
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    /**
     * Find out if this Square is visible or not.
     * 
     * @return true if the Square is visible, false if it is not.
     */
    public boolean isVisible() {
        return isVisible;
    }
}