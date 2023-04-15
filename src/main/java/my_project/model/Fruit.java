package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Fruit extends GraphicalObject {
    //Attribute
    protected double speed;
    protected int offset;
    protected double timer;
    protected Player[] players;
    public Fruit (double x, double y, int offset, String path, Player[] players) {
        this.x = x;
        this.y = y;
        this.players = players;
        this.offset = offset;
        speed = 150;
        this.setNewImage(path);
        this.height = getMyImage().getHeight();
        this.width = getMyImage().getWidth();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage (getMyImage(), x, y);
    }

    @Override
    public void update(double dt) {
        this.y += this.speed * dt;
        if (this.y >= Config.WINDOW_HEIGHT || checkAndHandleCollision()) {
            jumpBack();
        }
        timer = timer + dt;
        if((int)timer % 2 == 0){
            x = x + offset*dt;
        }else{
            x = x - offset*dt;
        }
    }

    public void jumpBack() {
        this.y = -height;
        this.x = Math.random() * Config.WINDOW_WIDTH;
    }

    private boolean checkAndHandleCollision() {
        for (int i = 0; i < players.length; i++) {
            if (this.collidesWith(players[i])) {
                return true;
            }
        }
        return false;
    }

}
