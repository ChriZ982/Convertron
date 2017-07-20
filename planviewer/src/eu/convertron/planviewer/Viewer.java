package eu.convertron.planviewer;

import gameengine.core.Game;
import gameengine.core.Input;
import gameengine.rendering.Display;
import java.awt.Color;
import java.awt.Graphics2D;

public class Viewer extends Game {

    private Input input;
    private Display display;

    public Viewer() {
        super(30);

        this.input = new Input();
        this.display = new Display("Convertron - Plan Viewer", 1600, 900, input);
    }

    @Override
    protected void doAfterSecond(int ticks, int frames) {
        System.out.println("Ticks: " + ticks + " Frames: " + frames);
    }

    @Override
    protected void update() {
    }

    @Override
    protected void render() {
        Graphics2D graphics = display.getGraphics();

        graphics.setColor(Color.yellow);
        graphics.fillRect(100, 100, 100, 100);

        display.refresh();
    }

}
