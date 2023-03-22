package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Peach extends GraphicalObject {

    //Attribute
    private double speed;

    public Peach(double x, double y) {
        this.x = x;
        this.y = y;
        speed = 150;
        radius = 30;
    }


    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(175, 0, 0, 255);
        drawTool.drawFilledRectangle(x, y, width, height);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawRectangle(x, y, width, height);
    }

    @Override
    public void update(double dt){
        this.y += this.speed * dt;
        if (this.y >= Config.WINDOW_HEIGHT) {
            jumpBack();
        }
    }
    public void jumpBack() {
        this.y = -height;
        this.x = Math.random() * Config.WINDOW_WIDTH;
    }
}

