package screens.Menu;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;
import screens.Village.VillageScreen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;

public class QuitterScreen implements Screen {

    private PlayScreen screen;
    private VillageScreen villageScreen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;
    private boolean inVillage;

    public QuitterScreen(PlayScreen screen){
        this.screen = screen;
        this.world=screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
        inVillage = false;
    }

    public QuitterScreen(VillageScreen villageScreen, PlayScreen screen){
        this.villageScreen = villageScreen;
        this.screen = screen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        inVillage = true;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
       terminal.writeCenter("Voulez-vous quitter la partie ?",15,Color.white);
       terminal.write("Oui",63,20,this.choix == 0 ? brightRed : white);
        terminal.write("Non",73,20,this.choix == 1 ? brightRed : white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                switch (this.choix){
                    case 0 :
                        exit(0);
                        break;
                    case 1 :
                        if (inVillage == true){
                            return new MenuScreen(villageScreen, screen);
                        } else return new MenuScreen(screen);

                }
                case KeyEvent.VK_LEFT:
                    choix = (choix+1)%2;
                    break;
                case KeyEvent.VK_RIGHT:
                    choix = (choix-1)%2;
                    if (choix<0){
                        choix = (choix+2);
                    }
                    break;

        }
        return this;
    }
}
