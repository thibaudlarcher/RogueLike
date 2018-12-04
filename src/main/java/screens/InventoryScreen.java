package screens;
import Object.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import creature.Creature;

public class InventoryScreen implements Screen {
    private Screen PlayScreen;
    protected Creature player;
    private String letters;

    public InventoryScreen (Creature player, Screen PlayScreen){
        this.player = player;
        this.letters = "test";
        this.PlayScreen = PlayScreen;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("INVENTORY", 2, Color.WHITE);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_I:
                return this.PlayScreen;
        }
        return this;
    }
}