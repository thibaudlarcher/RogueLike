package screens.Combat;

import asciiPanel.AsciiPanel;
import creature.Monstre.*;
import screens.LoseScreen;
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
import static screens.Combat.GestionTour.isJoueurTour;
import static screens.Combat.IsMort.*;
import static screens.Combat.AffichageDesign.*;

/**
 * Classe du screen de combat
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class CombatScreen implements Screen {

    /**
     * Stock le world
     */
    private World world;

    /**
     * Stock player
     */
    private GroupCreature player;

    /**
     * Stock la liste de Monstres
     */
    private ArrayList<GroupCreature> groupCreature;

    /**
     * Stock les créatures
     */
    private GroupCreature creature;

    /**
     * Stock la position
     */
    private int position;

    /**
     * Stock le choix dans le screen avec keyEvent
     */
    private int choix;

    /**
     * Le numéro des monstres dans la liste des créatures
     */
    private int numero;

    /**
     * Si on a plus que 1 player dans le groupe player
     */
    private int nextPlayer;

    /**
     * La créature suivante
     */
    private int nextCrea;

    /**
     * PlayScreen
     */
    private PlayScreen screen;

    /**
     * le World
     */
    private World village;

    /**
     * Constructeur de la classe CombatScreen.
     * @param groupCreature ensemble des créatures
     * @param player le player
     * @param world world
     * @param village village
     * @param numero valeur du numéro
     * @param screen le Screen
     */
    public CombatScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world, World village, int numero, PlayScreen screen) {
        position = 0;
        nextPlayer = -1;
        nextCrea = -1;
        this.world=world;
        this.village = village;
        this.screen = screen;
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

    /**
     * Permet d'afficher sur le terminal de asciipanel
     * @param terminal asciiPanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        while((nextPlayer = isJoueurTour(player)) == -1) {
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
            if((nextCrea = isJoueurTour(creature)) != -1) {
                ((Monstre) creature.getGroupCreature().get(nextCrea)).takeAction(player);
                nextCrea = -1;
            }
            for (int i = 0; i < creature.getGroupCreature().size(); i++) {
                creature.getGroupCreature().get(i).updateTour();
            }
            for (int i = 0; i < player.getGroupCreature().size(); i++) {
                player.getGroupCreature().get(i).updateTour();
            }
        }
        if (player.getGroupCreature().get(0).getPointDeVie()<=0){
            terminal.clear();
            terminal.writeCenter("You Die.", 3, Color.red);
            terminal.writeCenter("Press [ENTER] to continue",38, Color.black);
        }
        else {
            terminal.setDefaultBackgroundColor(new Color(125, 125, 125));
            terminal.clear();
            afficheMenu(terminal, this);
            for (int y = 0; y < 40; y++) {
                terminal.write('#', 100, y, new Color(16, 21, 78)); // Color(61,50,5)
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
    }

    /**
     * Il permet d'afficher les actions possibles dans un combat.
     * @param terminal asciipanel
     * @param menu Screen de combat
     */
    public void afficheMenu(AsciiPanel terminal,CombatScreen menu){
        terminal.write("Attaque", 105 ,7, menu.position == 0 ? brightRed : white );
        terminal.write("Fuite", 105 ,13, menu.position == 1 ? brightRed : white );
        if (this.player.getGroupCreature().get(0).getName()=="Mage"){
            terminal.write("Boule de feu", 105 ,10, menu.position == 2 ? brightRed : white );
        }
    }

    /**
     * Permet de gérer les actions du clavier et ainsi lui donner des actions.
     * @param key Appuie sur une touche
     * @return Un Screen
     */
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (player.getGroupCreature().get(0).getName()=="Mage") {
                    switch (this.position) {
                        case 0:
                            if (mortPersonnage(player)) {
                                return new LoseScreen(player);
                            }
                            player.getGroupCreature().get(nextPlayer).dealDamageTo(
                                    creature.getGroupCreature().get(choix));
                            nextPlayer = -1;
                            CreatureMort(creature, choix);
                            if (CreatureMortGroupe(groupCreature, numero)) {
                                return new PlayScreen(world,village, player, groupCreature);
                            }
                            return this;
                        case 2:
                            if (mortPersonnage(player)) {
                                return new LoseScreen(player);
                            }
                            player.getGroupCreature().get(nextPlayer).dealDamageToMagic(
                                    creature.getGroupCreature().get(choix));
                            nextPlayer = -1;
                            CreatureMort(creature, choix);
                            if (CreatureMortGroupe(groupCreature, numero)) {
                                return new PlayScreen(world,village, player, groupCreature);
                            }
                            return this;
                        case 1:
                            player.getGroupCreature().get(nextPlayer).setPointDeVie(player.getGroupCreature().get(nextPlayer).getPointDeVie()-4);
                            return new PlayScreen(world,village, player, groupCreature);
                    }
                }else {
                    switch (this.position) {
                        case 0:
                            if (mortPersonnage(player)) {
                                return new LoseScreen(player);
                            }
                            player.getGroupCreature().get(nextPlayer).dealDamageTo(
                                    creature.getGroupCreature().get(choix));
                            nextPlayer = -1;
                            CreatureMort(creature, choix);
                            if (CreatureMortGroupe(groupCreature, numero)) {
                                return new PlayScreen(world,village, player, groupCreature);
                            }
                            return this;
                        case 1:
                            return new PlayScreen(world,village, player, groupCreature);
                    }
                }
            case KeyEvent.VK_ESCAPE:
                exit(1);
            case KeyEvent.VK_RIGHT:
                if (this.choix != creature.getGroupCreature().size()-1) {
                    this.choix++;
                }
                return this;
            case KeyEvent.VK_LEFT:
                if (this.choix != 0) {
                    this.choix--;
                }
                return this;
            case KeyEvent.VK_DOWN:
                if (player.getGroupCreature().get(0).getName()=="Mage"){
                    position = (position+1)%3;
                }else position = (position+1)%2;
                break;
            case KeyEvent.VK_UP:
                if (player.getGroupCreature().get(0).getName()=="Mage"){
                    position = (position-1)%3;
                    if (position<0){
                        position = (position+3);
                    }
                }else{
                    position = (position-1)%2;
                    if (position<0){
                        position = (position+2);
                    }
                }
                break;
        }
        return this;
    }

}