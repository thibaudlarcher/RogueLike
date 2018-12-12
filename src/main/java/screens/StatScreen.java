package screens;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static asciiPanel.AsciiPanel.white;

public class StatScreen implements Screen {

    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;

    public StatScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world){
        this.world=world;
        this.groupCreature = groupCreature;
        this.player = player;
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
                return new PlayScreen(world,player,groupCreature);
            case KeyEvent.VK_R:
                return new MenuScreen(groupCreature,player,world);
        }
        return this;
    }
}
