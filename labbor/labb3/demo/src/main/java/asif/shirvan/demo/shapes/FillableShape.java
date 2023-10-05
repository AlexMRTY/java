package asif.shirvan.demo.shapes;

import javafx.scene.paint.Color;

public abstract class  FillableShape extends Shape {
    private boolean filled;

    protected FillableShape(double x, double y, Color color) {
        super(x, y, color);
        this.filled= false;
    }
    protected FillableShape(){
        super();
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public boolean isFilled(){
        return this.filled;
    }

}
