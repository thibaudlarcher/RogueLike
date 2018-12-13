package screens;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static asciiPanel.AsciiPanel.white;

public class StatScreen implements Screen {

    PlayScreen screen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;

    public StatScreen(PlayScreen screen){
        this.screen = screen;
        this.world=screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Stats", 5,new Color(255, 255, 255));
        System.out.println(terminal.getWidth());
        for (int var=0;var<140-1;var++){
            terminal.write("- ", var, 3, white);
        }
        terminal.writeCenter("Point de vie : "+player.getGroupCreature().get(0).getPointDeVie()+"/"+
                player.getGroupCreature().get(0).getPointDeVieMax(),10,Color.white);

        terminal.writeCenter("Point d'attaque : "+player.getGroupCreature().get(0).getAttaque(),15,Color.white);
        terminal.writeCenter("Vitesse : "+player.getGroupCreature().get(0).getVitesse(),20,Color.white);

        terminal.write("Menu [R]", 0,40,Color.white);
        terminal.write("Jeux [ESC]", 130,40,Color.white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_C:
                return new PlayScreen(world,player,groupCreature);
            case KeyEvent.VK_R:
                return new MenuScreen(screen);
        }
        return this;
    }
}
