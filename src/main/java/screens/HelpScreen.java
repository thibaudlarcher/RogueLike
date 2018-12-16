package screens;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.Village.VillageScreen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class HelpScreen implements Screen {
    private PlayScreen screen;
    private VillageScreen villageScreen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> GroupCreature;
    private boolean inVilllage;

    public HelpScreen (PlayScreen screen){
        this.screen = screen;
        this.GroupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
        this.world = screen.getWorld();
        inVilllage = false;
    }

    public HelpScreen (VillageScreen villageScreen, PlayScreen screen){
        this.villageScreen = villageScreen;
        this.player = villageScreen.getPlayer();
        this.world = villageScreen.getVillage();
        this.screen = screen;
        inVilllage = true;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Help", 2, Color.WHITE);
        terminal.writeCenter("Raccourcis",7, Color.WHITE);
        terminal.writeCenter("[ESCAPE] Afficher le Menu",10, new Color(53, 118, 63));
        terminal.writeCenter("[I] Afficher l'Inventaire du Personnage",12, new Color(53, 118, 63));
        terminal.writeCenter("[C] Afficher les Statistiques du Personnage",14, new Color(53, 118, 63));
        terminal.writeCenter("[P] Recuperer un Item",16, new Color(53, 118, 63));
        terminal.writeCenter("[D] Lacher un Item",18, new Color(53, 118, 63));
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_H:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_ESCAPE:
                if (inVilllage == true){
                    return new MenuScreen(villageScreen, screen);
                } else return new MenuScreen(screen);
        }
        return this;
    }
}
