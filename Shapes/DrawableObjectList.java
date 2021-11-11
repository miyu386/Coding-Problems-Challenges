package shapes;

import java.awt.*;
import java.util.*;

/**
 * A DrawableObjectList is a collection of Objects that implement the Drawable
 * interface. This class is used by the DrawingTablet to maintain the list of
 * objects to be drawn on the screen. This class also provides methods for
 * drawing or scaling all of the objects.
 */
public class DrawableObjectList {
	
	private ArrayList<Drawable> objectList;
	

    /**
     * Construct a new empty DrawableObjectList.
     */
    public DrawableObjectList() {
    	objectList = new ArrayList();
    }

    /**
     * Get the number of Drawable objects that are currently in the list.
     * 
     * @return the size of the list.
     */
    public int getSize() {
        return objectList.size();
    }

    /**
     * Add the specified Drawable object to the end of this DrawableObjectList.
     * 
     * @param obj the Drawable object to be added.
     */
    public void addDrawable(Drawable obj) {
    	objectList.add(obj);
    }

    /**
     * Remove the specified Drawable object from the DrawableObjectList.  If the
     * object referred to by obj is also stored in the list it is removed.
     * 
     * @param obj the Drawable object to remove.
     */
    public void removeDrawable(Drawable obj) {
    	objectList.remove(obj);
    }

    /**
     * Draw each of the visible Drawable objects that are contained in this
     * DrawableObjectList onto the specified graphics object. Objects that are
     * not visible are not drawn. The objects are drawn in the order
     * that they were added so that more recently added objects appear in front
     * of added earlier.
     * 
     * @param g the Graphics object on which to draw the objects.
     */
    public void drawAll(Graphics g) {
    	for (int i=0; i<objectList.size(); i++) {
    		if (objectList.get(i).isVisible()) {
    			objectList.get(i).draw(g);
    		}
    	}
    	
    	
    }

    /**
     * Scale each of the Drawable objects that also implement the Scaleable
     * interface by the specified factor. Drawable objects that do not also
     * implement the Scaleable interface are unchanged. (Hint: Use instanceof). Both
     * visible and invisible objects are scaled.
     * 
     * @param factor the factor by which to scale the Scaleable objects.
     */
    public void scaleAll(double factor) {
    	for (int i=0; i<objectList.size(); i++) {
    		if (objectList.get(i) instanceof Scaleable) {
    			Scaleable s1 = (Scaleable) objectList.get(i);
    			s1.scale(factor);
    		}
    	}
    }
}
