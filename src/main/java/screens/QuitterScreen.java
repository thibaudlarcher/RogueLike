package screens;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;

public class QuitterScreen implements Screen {

    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int choix;

    public QuitterScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world){
        this.world=world;
        this.groupCreature = groupCreature;
        this.player = player;
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
                        return new MenuScreen(groupCreature,player,world);

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