package screens.Village;

import asciiPanel.AsciiPanel;
import creature.Creature;
import creature.GroupCreature;
import object.Inventory;
import object.Items.*;
import screens.Screen;
import world.World;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VillageoisScreen implements Screen {
    private VillageScreen screen;
    private World world;
    private ArrayList<GroupCreature> groupVillageois;
    private GroupCreature player;
    private int pos;

    public VillageoisScreen(VillageScreen screen){
        this.screen = screen;
        this.world = screen.getVillage();
        this.groupVillageois = screen.getGroupVillageois();
        this.player = screen.getPlayer();
        this.pos = -1;
    }


    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();

        Creature joueur = this.player.getGroupCreature().get(0);
        Inventory currentInventory = player.getGroupCreature().get(0).inventory();
        terminal.writeCenter("VILLAGEOIS",1, AsciiPanel.brightWhite);
        for (int j = 0; j < 140; j++){
            terminal.write((char) 196, j, 3, Color.WHITE);
            j++;
        }

        for (int j = 8; j < 38; j++){
            terminal.writeCenter(Character.toString((char) 179), j, Color.WHITE);
            j++;
        }

        terminal.writeCenter("Bonjour !",4, AsciiPanel.white);
        terminal.writeCenter("Que veux-tu vendre / acheter ?",5, AsciiPanel.white);

        //Affichage inventaire joueur
        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSizeMax(); i++){
            if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "arme") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 7 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 12, 7 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 25, 7 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 34, 7 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "potion"){
                terminal.write(joueur.inventory().get(i).getName(), 2, 7 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 12, 7 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "armure"){
                terminal.write(joueur.inventory().get(i).getName(), 2, 7 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 12, 7 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 25, 7 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 34, 7 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "botte"){
                terminal.write(joueur.inventory().get(i).getName(), 2, 7 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 12, 7 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 25, 7 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 34, 7 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "casque") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 7 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 12, 7 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 25, 7 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 34, 7 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "pantalon") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 7 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 12, 7 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 25, 7 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 34, 7 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            }
        }

        terminal.write("Press [A] pour acheter une potion.  Prix : 16",85, 10, AsciiPanel.brightWhite);
        terminal.write("Press [Z] pour acheter une epee.    Prix : 23", 85, 13, AsciiPanel.brightWhite);
        terminal.write("Press [E] pour acheter un baton.    Prix : 8", 85, 16, AsciiPanel.brightWhite);
        terminal.write("Press [R] pour acheter un casque.  Prix : 14", 85, 19, AsciiPanel.brightWhite);
        terminal.write("Press [T] pour acheter une armure.  Prix : 19", 85, 22, AsciiPanel.brightWhite);
        terminal.write("Press [Y] pour acheter un pantalon. Prix : 16", 85, 25, AsciiPanel.brightWhite);
        terminal.write("Press [U] pour acheter des bottes.  Prix : 12", 85, 28, AsciiPanel.brightWhite);
        if (currentInventory.isFull()){
            terminal.write("Inventory full",98,31,AsciiPanel.brightRed);
        }

        terminal.write("Monnaie : " + currentInventory.getMonnaie(), 2, 34, AsciiPanel.brightWhite);
        if (pos >= 0 && currentInventory.get(pos).isEquipe() == true) {
            terminal.write("Vous ne pouvez pas vendre des items equipes.", 2, 36, AsciiPanel.red);
        } else {
            terminal.write("Press [ENTER] to sell current item", 2, 36, AsciiPanel.brightWhite);
        }
        terminal.write("[ESCAPE] to resume game", 2, 41, AsciiPanel.brightWhite);

    }

    private Screen testVente(Item item){
        if (item != null && item.isEquipe() == false){
            vendre(item);
            return new VillageoisScreen(this.screen);
        }
        return this;
    }

    private void achatPotion(){
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            if (player.getGroupCreature().get(0).inventory().getMonnaie() >= 16) {
                player.getGroupCreature().get(0).inventory().add(new ItemPotion((char) 225, Color.black, "potion", 10, 14));
                player.getGroupCreature().get(0).inventory().removeMonnaie(16);
            }
        }
    }

    private void achatEpee(){
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            if (player.getGroupCreature().get(0).inventory().getMonnaie() >= 23) {
                player.getGroupCreature().get(0).inventory().add(new ItemArme((char) 197, Color.black, "epee", 8, 21));
                player.getGroupCreature().get(0).inventory().removeMonnaie(23);
            }
        }
    }

    private void achatCasque(){
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            if (player.getGroupCreature().get(0).inventory().getMonnaie() >= 14) {
                player.getGroupCreature().get(0).inventory().add(new ItemEquipementCasque((char) 94, Color.black, "casque", 1, 12));
                player.getGroupCreature().get(0).inventory().removeMonnaie(14);
            }
        }
    }

    private void achatBaton(){
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            if (player.getGroupCreature().get(0).inventory().getMonnaie() >= 8) {
                player.getGroupCreature().get(0).inventory().add(new ItemArme((char) 179, Color.black, "baton", 3, 6));
                player.getGroupCreature().get(0).inventory().removeMonnaie(8);
            }
        }
    }

    private void achatArmure(){
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            if (player.getGroupCreature().get(0).inventory().getMonnaie() >= 19) {
                player.getGroupCreature().get(0).inventory().add(new ItemEquipementArmure((char) 190, Color.black, "armure", 2, 17));
                player.getGroupCreature().get(0).inventory().removeMonnaie(19);
            }
        }
    }

    private void achatPantalon(){
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            if (player.getGroupCreature().get(0).inventory().getMonnaie() >= 16) {
                player.getGroupCreature().get(0).inventory().add(new ItemEquipementPantalon((char) 186, Color.black, "pantalon", 2, 14));
                player.getGroupCreature().get(0).inventory().removeMonnaie(16);
            }
        }
    }

    private void achatBotte(){
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            if (player.getGroupCreature().get(0).inventory().getMonnaie() >= 12) {
                player.getGroupCreature().get(0).inventory().add(new ItemEquipementBotte((char) 200, Color.black, "botte", 1, 10));
                player.getGroupCreature().get(0).inventory().removeMonnaie(12);
            }
        }
    }

    private void vendre(Item item){
        if (item != null) {
            player.getGroupCreature().get(0).inventory().addMonnaie(item.getValeur());
            player.getGroupCreature().get(0).inventory().remove(item);
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE: return new VillageScreen(screen, screen.getPlayscreen());
            case KeyEvent.VK_DOWN:
                if (player.getGroupCreature().get(0).inventory().getSize() != 0) {
                    if (pos != (player.getGroupCreature().get(0).inventory().getIndiceMaxItem())) {
                        while (player.getGroupCreature().get(0).inventory().get(pos + 1) == null) {
                            this.pos++;
                        }
                        this.pos++;
                    }
                }
                return this;
            case KeyEvent.VK_UP:
                if (pos != 0 && pos > -1) {
                    while (player.getGroupCreature().get(0).inventory().get(pos - 1) == null) {
                        this.pos--;
                        if (this.pos - 1 == -1){
                            this.pos = -1;
                            while (player.getGroupCreature().get(0).inventory().get(pos + 1) == null){
                                this.pos++;
                            }
                            this.pos = this.pos + 2;
                        }
                    }
                    this.pos--;
                }
                return this;
            case KeyEvent.VK_ENTER:
                if (pos >= 0){
                    return testVente(player.getGroupCreature().get(0).inventory().get(pos));
                }
            case KeyEvent.VK_A:
                achatPotion();
                return new VillageoisScreen(this.screen);
            case KeyEvent.VK_Z:
                achatEpee();
                return new VillageoisScreen(this.screen);
            case KeyEvent.VK_E:
                achatBaton();
                return new VillageoisScreen(this.screen);
            case KeyEvent.VK_R:
                achatCasque();
                return new VillageoisScreen(this.screen);
            case KeyEvent.VK_T:
                achatArmure();
                return new VillageoisScreen(this.screen);
            case KeyEvent.VK_Y:
                achatPantalon();
                return new VillageoisScreen(this.screen);
            case KeyEvent.VK_U:
                achatBotte();
                return new VillageoisScreen(this.screen);
//            case KeyEvent.VK_Q:
//                player.getGroupCreature().get(0).inventory().addMonnaie(50);
//                return this;
        }
        return this;
    }
}
