package screens;

import java.awt.*;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class InventoryScreen implements Screen {
    private Screen PlayScreen;

    public InventoryScreen (Screen PlayScreen){
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

