package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {
    //Attribute
    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Player[] players;

    Apple[] apples;
    Pear[] pears;
    Peach[] peaches;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     *
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController) {
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        Player player01 = new Player(
                Config.WINDOW_WIDTH - 250,
                Config.WINDOW_HEIGHT - 100,
                KeyEvent.VK_A,
                KeyEvent.VK_D,
                new Color(255, 0, 251)
        );
        Player player02 = new Player(
                150,
                Config.WINDOW_HEIGHT - 100,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                new Color (0, 0, 0));
        players = new Player[] {player01, player02};

        apples = new Apple[5];
        pears = new Pear[5];
        peaches = new Peach[5];

        for (int i = 0; i < apples.length; i++) {
            double xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
            double yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;
            apples[i] = new Apple(xPos, yPos, 70, players);
            viewController.draw(apples[i]);

            xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
            yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;
            pears[i] = new Pear(xPos, yPos, 50, players);
            viewController.draw(pears[i]);

            xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
            yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;
            peaches[i] = new Peach(xPos, yPos, 100, players);
            viewController.draw(peaches[i]);
        }

        for (int i = 0; i < players.length; i++) {
            viewController.draw(players[i]);
            viewController.register(players[i]);
        }
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt) {
    }

}
