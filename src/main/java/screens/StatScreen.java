package screens;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.Village.VillageScreen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static asciiPanel.AsciiPanel.white;

public class StatScreen implements Screen {

    private PlayScreen screen;
    private VillageScreen villageScreen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;
    private boolean inVillage;

    public StatScreen(PlayScreen screen){
        this.screen = screen;
        this.world=screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
        inVillage = false;
    }

    public StatScreen(VillageScreen villageScreen, PlayScreen screen){
        this.villageScreen = villageScreen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        this.screen = screen;
        inVillage = true;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Stats", 5,new Color(255, 255, 255));
        //System.out.println(terminal.getWidth());
        for (int var=0;var<140-1;var++){
            terminal.write("- ", var, 3, white);
        }
        terminal.writeCenter("Point de vie : "+player.getGroupCreature().get(0).getPointDeVie()+"/"+
                player.getGroupCreature().get(0).getPointDeVieMax(),10,Color.white);

        terminal.writeCenter("Point d'attaque : "+player.getGroupCreature().get(0).getAttaque(),15,Color.white);
        terminal.writeCenter("Defense : "+ player.getGroupCreature().get(0).getDefense(), 20, Color.WHITE);
        terminal.writeCenter("Vitesse : "+player.getGroupCreature().get(0).getVitesse(),25,Color.white);

        terminal.write("Menu [R]", 0,40,Color.white);
        terminal.write("Jeux [ESC]", 130,40,Color.white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_C:
                if (inVillage == true){
                    return new VillageScreen(villageScreen, screen);
                } else return new PlayScreen(world, screen.getVillage(), player, groupCreature);
            case KeyEvent.VK_R:
                if (inVillage == true){
                    return new MenuScreen(villageScreen, screen);
                } else return new MenuScreen(screen);
        }
        return this;
    }
}
