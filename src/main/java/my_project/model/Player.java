package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private int points;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;
    private Color color;

    public Player(double x, double y, int keyToGoLeft, int keyToGoRight, Color color){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;

        this.color = color;
        this.keyToGoLeft    = keyToGoLeft;
        this.keyToGoRight   = keyToGoRight;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(color);
        drawTool.drawFilledRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        if(direction == 0){
            x = x + speed*dt;
        }
        if(direction == 2){
            x = x - speed*dt;
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }
}
