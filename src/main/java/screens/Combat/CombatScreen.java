package screens.Combat;

import asciiPanel.AsciiPanel;
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
import static screens.Combat.AffichageStat.*;
import static screens.Combat.TestMort.*;
import static screens.Combat.AffichageDesign.*;

public class CombatScreen implements Screen {
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private GroupCreature creature;
    private int position;
    private int choix;
    private int numero;

    public CombatScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world, int numero) {
        position = 0;
        this.world=world;
        this.groupCreature = groupCreature;
        this.player = player;
        this.numero = numero;
        creature = groupCreature.get(numero);
        if(creature.getGroupCreature().size() == 0){
            creature.getGroupCreature().add(new Kobold());
            creature.getGroupCreature().add(new Kobold());
            creature.getGroupCreature().add(new Kobold());
        }

    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(125,125,125));
        terminal.clear();
        afficheMenu(terminal, this);
        for (int y = 0; y < 40; y++) {
            terminal.write('#', 100, y, new Color(16,21,78)); // Color(61,50,5)
        }
        for (int i = 0; i < creature.getGroupCreature().size(); i++) {
            terminal.write(creature.getGroupCreature().get(i).getName(), 9 + 30 * i, 7,
                    creature.getGroupCreature().get(i).getColor());
        }
        for (int i = 0; i < player.getGroupCreature().size(); i++) {
            terminal.write(player.getGroupCreature().get(i).getName(), 9 + 30 * i, 23,
                    player.getGroupCreature().get(i).getColor());
        }
        affichePV(terminal, creature, player);
        afficheFleche(terminal, choix);
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
                        player.getGroupCreature().get(0).dealDamageTo(
                                creature.getGroupCreature().get(choix));
                        testMort(creature,choix);
                        if(testMortGroupe(groupCreature,numero)) {
                            return new PlayScreen(world, player, groupCreature);
                        }
                        return this;
                    case 1:
                        return new PlayScreen(world, player, groupCreature);
                }
            case KeyEvent.VK_ESCAPE:
                exit(1);
            case KeyEvent.VK_RIGHT:
                if (this.choix != creature.getGroupCreature().size()) {
                    this.choix++;
                }
                System.out.println(this.position);
                return this;
            case KeyEvent.VK_LEFT:
                if (this.choix != 0) {
                    this.choix--;
                }
                System.out.println(this.position);
                return this;
            case KeyEvent.VK_DOWN:
                if (this.position != 1) {
                    this.position++;
                }
                System.out.println(this.position);
                return this;
            case KeyEvent.VK_UP:
                if (this.position != 0) {
                    this.position--;
                }
                System.out.println(this.position);
                return this;
        }
        return this;
    }

}