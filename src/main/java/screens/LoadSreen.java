package screens;

import asciiPanel.AsciiPanel;
import io.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;
import static java.lang.System.in;

public class LoadSreen implements Screen{

    private int choix;

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();
        terminal.writeCenter("Menu", 10,new Color(255, 255, 255));
        terminal.writeCenter("Nouveau", 15,this.choix == 0 ? brightRed : white);
        terminal.writeCenter("Charger", 20,this.choix == 1 ? brightRed : white );
        terminal.writeCenter("Quitter", 25,this.choix == 2 ? brightRed : white);
       }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                switch (this.choix){
                    case 0 :
                        return new PersonnageChoice();
                    case 1 :
                        return new LoadSave().Test();
                    case 2 :
                         exit(0);
                }
            /*case KeyEvent.VK_ESCAPE :
                return new PlayScreen();*/
            case KeyEvent.VK_DOWN:
                choix = (choix+1)%3;
                break;
            case KeyEvent.VK_UP:
                choix = (choix-1)%3;
                if (choix<0){
                    choix = (choix+3);
                }
                break;
        }
        return this;
    }
}
