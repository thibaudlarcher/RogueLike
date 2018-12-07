package screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import io.Save;
import world.World;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;

public class MenuScreen implements Screen {

    private PlayScreen screen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;

    public MenuScreen(PlayScreen screen) {
        this.screen = screen;
        this.world=screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Menu", 5,new Color(255, 255, 255));
        terminal.writeCenter("Sauvegarde", 10,this.choix == 0 ? brightRed : white );
        terminal.writeCenter("Stats", 15,this.choix == 1 ? brightRed : white);
        terminal.writeCenter("Item", 20,this.choix == 2 ? brightRed : white);
        terminal.writeCenter("Reprendre", 25,this.choix == 3 ? brightRed : white);
        terminal.writeCenter("Quitter", 30,this.choix == 4 ? brightRed : white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                switch (this.choix){
                    case 0 :
                         new Save(screen);
                         break;
                    case 1 :
                       // return new StatsScreen();
                    case 2 :
                        return new StatScreen(screen);
                    case 3 :
                        return new PlayScreen(world,player,groupCreature);
                    case 4 :
                        exit(0);
                }
            case KeyEvent.VK_ESCAPE :
                return new PlayScreen(world,player,groupCreature);
            case KeyEvent.VK_DOWN:
                choix = (choix+1)%5;
                break;
            case KeyEvent.VK_UP:
                choix = (choix-1)%5;
                if (choix<0){
                    choix = (choix+5);
                }
                break;
        }

        return this;
    }

}
