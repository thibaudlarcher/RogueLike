package screens.Combat;

import asciiPanel.AsciiPanel;
import creature.*;
import creature.Monstre.*;
import screens.PlayScreen;
import creature.GroupCreature;
import screens.Screen;
import world.World;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;

public class CombatScreen implements Screen {
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private GroupCreature creature;
    private int position;

    public CombatScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world) {
        position = 0;
        this.world=world;
        this.groupCreature = groupCreature;
        this.player = player;
        creature = groupCreature.get(0);
        creature.getGroupCreature().add(new Kobold());
        creature.getGroupCreature().add(new Kobold());
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        int y, i;
        afficheMenu(terminal, this);
        for (y = 0; y < 40; y++) {
            terminal.write('#', 100, y, new Color(200, 200, 200)); // Color(61,50,5)
        }

        for (i = 0; i < player.getGroupCreature().size(); i++) {
            terminal.write(player.getGroupCreature().get(i).getGlyph(), 15 + 30 * i, 30,
                    player.getGroupCreature().get(i).getColor());
            //Affichage Point de Vie
            terminal.write("PV:", 9 + 30 * i, 32, brightRed);
            if (player.getGroupCreature().get(i).getPointDeVie() < 100) {
                terminal.write("0", 12 + 30 * i, 32, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        13 + 30 * i, 32, brightRed);
            } else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        12 + 30 * i, 32, brightRed);
            }
            terminal.write("/", 15 + 30 * i, 32, brightRed);
            if (player.getGroupCreature().get(i).getPointDeVieMax() < 100) {
                terminal.write("0", 16 + 30 * i, 32, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        17 + 30 * i, 32, brightRed);
            } else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        16 + 30 * i, 32, brightRed);
            }

        }
    }

    public static void afficheMenu(AsciiPanel terminal,CombatScreen menu){
        terminal.write("Attaque", 105 ,7, menu.position == 0 ? brightRed : white );
        terminal.write("Fuite", 105 ,10, menu.position == 1 ? brightRed : white );
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                switch (this.position) {
                    case 0:
                        this.creature.getGroupCreature().get(0).setPointDeVie(
                                this.creature.getGroupCreature().get(0).getPointDeVie() -
                                this.player.getGroupCreature().get(0).getAttaque()
                            );
                        System.out.println(this.creature.getGroupCreature().get(0).getPointDeVie());
                        return this;
                    case 1:
                        return new PlayScreen(world, player, groupCreature);
                }
            case KeyEvent.VK_ESCAPE:
                exit(1);
            case KeyEvent.VK_DOWN:
                if(this.position != 1){
                    this.position++;
                }
                System.out.println(this.position);
                return this;
            case KeyEvent.VK_UP:
                if(this.position != 0){
                    this.position--;
                }
                System.out.println(this.position);
                return this;
        }
        //Je ne sais pas ce qui avait avant ...
        return null;
    }
    /*
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
    */
}