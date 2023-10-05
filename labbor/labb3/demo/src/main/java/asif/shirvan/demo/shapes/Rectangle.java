package asif.shirvan.demo.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape {
    private double width, height;

    public Rectangle(double x, double y, Color color, double width, double height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
     super();
     this.width=this.height=40;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY,
                boxWidth-width, boxHeight-height);
    }
    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.setStroke(getColor());
        gc.strokeRect(getX(),getY(),width,height);
        if (isFilled()) gc.fillRect(getX(),getY(),width,height);
    }

    @Override
    public String toString() {
        return super.toString() + " RectWidth: "+ width + "RectHeight: "+height;
    }
}
