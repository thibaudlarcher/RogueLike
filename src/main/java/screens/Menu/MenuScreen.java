package screens.menu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.*;
import screens.item.InventoryScreen;
import io.Save;
import screens.start.LoadSreen;
import screens.village.VillageScreen;
import world.World;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;

public class MenuScreen implements Screen {

    private PlayScreen screen;
    private VillageScreen villageScreen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;
    private boolean inVillage;

    public MenuScreen(PlayScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
        inVillage = false;
    }

    public MenuScreen(VillageScreen villageScreen, PlayScreen screen) {
        this.villageScreen = villageScreen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        this.screen = screen;
        inVillage = true;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();
        terminal.writeCenter("menu", 5,new Color(255, 255, 255));
        terminal.writeCenter("Sauvegarde", 10,this.choix == 0 ? brightRed : white);
        terminal.writeCenter("Nouveau", 15,this.choix == 1 ? brightRed : white);
        terminal.writeCenter("Stats", 20,this.choix == 2 ? brightRed : white);
        terminal.writeCenter("Inventaire", 25,this.choix == 3 ? brightRed : white);
        terminal.writeCenter("Reprendre", 30,this.choix == 4 ? brightRed : white);
        terminal.writeCenter("Aide", 35,this.choix == 5 ? brightRed : white);
        terminal.writeCenter("Quitter", 40,this.choix == 6 ? brightRed : white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                switch (this.choix) {
                    case 0 :
                        if (inVillage == true) {
                            new Save(screen, villageScreen);
                        } else {
                            new Save(screen);
                        }
                        break;
                    case 1 :
                        return new LoadSreen();
                    case 2 :
                        if (inVillage == true) {
                            return new StatScreen(villageScreen, screen);
                        } else {
                            return new StatScreen(screen);
                        }
                    case 3 :
                        if (inVillage == true) {
                            return new InventoryScreen(villageScreen, screen);
                        } else {
                            return new InventoryScreen(screen);
                        }
                    case 4 :
                        if (inVillage == true) {
                            return new VillageScreen(villageScreen, screen);
                        } else {
                            return new PlayScreen(world, screen.getVillage(), player, groupCreature);
                        }
                    case 5 :
                        if (inVillage == true) {
                            return new HelpScreen(villageScreen, screen);
                        } else {
                            return new HelpScreen(screen);
                        }
                    case 6 :
                        return new QuitterScreen(screen);
                }
            case KeyEvent.VK_ESCAPE :
                if (inVillage == true) {
                    return new VillageScreen(villageScreen, screen);
                } else {
                    return new PlayScreen(world, screen.getVillage(), player, groupCreature);
                }
            case KeyEvent.VK_DOWN:
                choix = (choix + 1) % 7;
                break;
            case KeyEvent.VK_UP:
                choix = (choix - 1) % 7;
                if (choix < 0) {
                    choix = (choix + 7);
                }
                break;
        }

        return this;
    }

}
