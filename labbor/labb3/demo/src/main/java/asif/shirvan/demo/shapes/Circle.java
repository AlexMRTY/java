package asif.shirvan.demo.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {

    private double diameter;

    public Circle(double x, double y, Color color, double diameter) {
        super(x, y, color);
        this.diameter = diameter;
    }

    public Circle() {
        super();
        this.diameter = 40;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }


    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.setFill(getColor());
        gc.strokeOval(getX(), getY(), diameter, diameter);
        if (isFilled()) gc.fillOval(getX(), getY(), diameter, diameter);

    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY,
                boxWidth - diameter, boxHeight - diameter);
    }

    @Override
    public String toString() {
        return super.toString() +
                " diameter=" + diameter +
                '}';
    }
}
