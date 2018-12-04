package screens.Combat;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static asciiPanel.AsciiPanel.brightRed;
import static java.lang.System.exit;

public class CombatScreen implements Screen {
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private GroupCreature creature;
    private int position;

    public CombatScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world) {
        this.world=world;
        this.groupCreature = groupCreature;
        this.player = player;
        creature = groupCreature.get(0);
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        int y,i;
        for(y = 0; y < 40; y++){
            terminal.write('#', 100, y, new Color(200,200,200)); // Color(61,50,5)
        }

        for(i = 0; i < player.getGroupCreature().size(); i++){
            terminal.write(player.getGroupCreature().get(i).getGlyph(), 15+30*i, 30,
                    player.getGroupCreature().get(i).getColor());

            //Affichage Point de Vie
            terminal.write("PV:", 9 + 30 * i, 32, brightRed);
            if(player.getGroupCreature().get(i).getPointDeVie() < 100) {
                terminal.write("0", 12 + 30 * i, 32, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        13 + 30 * i, 32, brightRed);
            }else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        12 + 30 * i, 32, brightRed);
            }
            terminal.write("/", 15+30*i, 32,brightRed);
            if(player.getGroupCreature().get(i).getPointDeVieMax() < 100) {
                terminal.write("0", 16 + 30 * i, 32, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        17 + 30 * i, 32, brightRed);
            }else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        16 + 30 * i, 32, brightRed);
            }
        }

        for(i = 0; i < creature.getGroupCreature().size(); i++){
            terminal.write(creature.getGroupCreature().get(i).getGlyph(), 15+30*i, 10,
                    creature.getGroupCreature().get(i).getColor());
            //Affichage Point de Vie
            terminal.write("PV:", 9 + 30 * i, 12, brightRed);
            if(player.getGroupCreature().get(i).getPointDeVie() < 100) {
                terminal.write("0", 12 + 30 * i, 12, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        13 + 30 * i, 12, brightRed);
            }else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        12 + 30 * i, 12, brightRed);
            }
            terminal.write("/", 15+30*i, 12,brightRed);
            if(player.getGroupCreature().get(i).getPointDeVieMax() < 100) {
                terminal.write("0", 16 + 30 * i, 12, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        17 + 30 * i, 12, brightRed);
            }else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        16 + 30 * i, 12, brightRed);
            }
        }


    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {

        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new PlayScreen(world,player,groupCreature);
            case KeyEvent.VK_ESCAPE:
                exit(1);
        }
        return this;
    }
}
