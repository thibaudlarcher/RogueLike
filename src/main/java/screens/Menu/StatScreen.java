package screens.menu;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;
import screens.village.VillageScreen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class StatScreen implements Screen {

    private PlayScreen screen;
    private VillageScreen villageScreen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;
    private boolean inVillage;

    public StatScreen(PlayScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
        inVillage = false;
    }

    public StatScreen(VillageScreen villageScreen, PlayScreen screen) {
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
        for (int j = 0; j < 140; j++) {
            terminal.write((char) 196, j, 4, Color.WHITE);
            j++;
        }
        terminal.writeCenter("Point de vie : " + player.getGroupCreature().get(0).getPointDeVie() + "/" + player.getGroupCreature().get(0).getPointDeVieMax(),10,Color.white);

        terminal.writeCenter("Point d'attaque : " + player.getGroupCreature().get(0).getAttaque(),15,Color.white);
        terminal.writeCenter("Defense : " + player.getGroupCreature().get(0).getDefense(), 20, Color.WHITE);
        terminal.writeCenter("Vitesse : " + player.getGroupCreature().get(0).getVitesse(),25,Color.white);
        terminal.writeCenter("Magic attaque : " + player.getGroupCreature().get(0).getmagicattaque(),30,Color.white);

        terminal.write("menu [R]", 0,40,Color.white);
        terminal.write("Jeux [ESC]", 130,40,Color.white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_C:
                if (inVillage == true) {
                    return new VillageScreen(villageScreen, screen);
                } else {
                    return new PlayScreen(world, screen.getVillage(), player, groupCreature);
                }
            case KeyEvent.VK_R:
                if (inVillage == true) {
                    return new MenuScreen(villageScreen, screen);
                } else {
                    return new MenuScreen(screen);
                }
        }
        return this;
    }
}
