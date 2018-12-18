package screens;

import asciiPanel.AsciiPanel;
import creature.PJ.Guerrier;
import creature.PJ.Mage;

import java.awt.*;
import java.awt.event.KeyEvent;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;

public class PersonnageChoice implements Screen {

    private int choix;

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Choix du personnage", 5,new Color(255, 255, 255));
        terminal.writeCenter("Guerrier", 10,this.choix == 0 ? brightRed : white);
        terminal.writeCenter("Mage", 15,this.choix == 1 ? brightRed : white );
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                switch (this.choix){
                    case 0 :
                        return new PlayScreen(new Guerrier("Guerrier",30,5));
                    case 1 :
                        return new PlayScreen(new Mage("Mage",20,15));
                }
            case KeyEvent.VK_DOWN:
                choix = (choix+1)%2;
                break;
            case KeyEvent.VK_UP:
                choix = (choix-1)%2;
                if (choix<0){
                    choix = (choix+2);
                }
                break;
        }
        return this;
    }
}
