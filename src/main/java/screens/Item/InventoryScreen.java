package screens.item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import Tiles.Tile;
import creature.Creature;
import creature.GroupCreature;
import object.Inventory;
import object.items.Item;
import screens.menu.MenuScreen;
import screens.PlayScreen;
import screens.Screen;
import screens.village.VillageScreen;
import world.World;

public class InventoryScreen implements Screen {
    private PlayScreen screen;
    private VillageScreen villageScreen;
    private World world;
    private ArrayList<GroupCreature> groupCreature;
    private GroupCreature player;
    private int pos;
    private boolean inVillage;

    public InventoryScreen(PlayScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.player = screen.getPlayer();
        this.groupCreature = screen.getGroupCreature();
        this.pos = -1;
        this.inVillage = false;
    }

    public InventoryScreen(VillageScreen villageScreen, PlayScreen screen) {
        this.villageScreen = villageScreen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        this.pos = -1;
        this.inVillage = true;
        this.screen = screen;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();
        Creature joueur = this.player.getGroupCreature().get(0);
        Inventory currentInventory = player.getGroupCreature().get(0).inventory();
        terminal.writeCenter("INVENTORY", 1, Color.WHITE);
        terminal.writeCenter("Taille : " + joueur.inventory().getSize() + "/" + joueur.inventory().getSizeMax(),2,Color.white);
        terminal.write("Point de vie : " + player.getGroupCreature().get(0).getPointDeVie() + "/" + player.getGroupCreature().get(0).getPointDeVieMax(),117,33, Color.white);
        terminal.write("Monnaie : " + player.getGroupCreature().get(0).inventory().getMonnaie(), 122, 35, Color.WHITE);
        for (int j = 0; j < 140; j++) {
            terminal.write((char) 196, j, 4, Color.WHITE);
            j++;
        }

        for (int j = 6; j < 35; j++) {
            terminal.write((char) 179, 111, j, Color.WHITE);
            j++;
        }

        // Affichage des ItemArme et leur degats
        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSizeMax(); i++) {
            if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "arme") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Cette redoutable arme vous offrira " + Integer.toString(joueur.inventory().get(i).getDammage()) + " de degats face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 82, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 95, 6 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 104, 6 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "potion") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Cette potion vous soignera de " + Integer.toString(joueur.inventory().get(i).getEffet()) + " points de vie.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 82, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                //terminal.writeCenter("Press [ENTER] to use",36, Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "armure") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Cette robuste armure vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 82, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 95, 6 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 104, 6 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "botte") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Cette paire de bottes vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 82, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 95, 6 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 104, 6 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "casque") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Ce simple casque vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 82, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 95, 6 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 104, 6 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "pantalon") {
                terminal.write(joueur.inventory().get(i).getName(), 2, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Ce long pantalon vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Valeur : " + Integer.toString(joueur.inventory().get(i).getValeur()), 82, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
                terminal.write("Equipe : ", 95, 6 + 2 * i, Color.GRAY);
                terminal.write(Boolean.toString(joueur.inventory().get(i).isEquipe()), 104, 6 + 2 * i, currentInventory.get(i).isEquipe() ? Color.green : Color.red);
            }
        }

        // Affichage de l'equipement du joueur
        terminal.write("Equipement", 122, 5,Color.white);
        terminal.write("Casque", 124, 8,Color.white);
        if (currentInventory.getCasqueEquipe() == false) {
            terminal.write("non equipe", 122, 9, Color.red);
        } else {
            terminal.write("equipe", 124, 9, Color.green);
        }

        terminal.write("Armure", 124, 13,Color.white);
        if (currentInventory.getArmureEquipe() == false) {
            terminal.write("non equipe", 122, 14,Color.red);
        } else {
            terminal.write("equipe", 124, 14,Color.green);
        }

        terminal.write("Pantalon", 123, 18,Color.white);
        if (currentInventory.getPantalonEquipe() == false) {
            terminal.write("non equipe", 122, 19,Color.red);
        } else {
            terminal.write("equipe", 124, 19,Color.green);
        }

        terminal.write("Botte", 124, 23,Color.white);
        if (currentInventory.getBotteEquipe() == false) {
            terminal.write("non equipe", 122, 24,Color.red);
        } else {
            terminal.write("equipe", 124, 24,Color.green);
        }

        terminal.write("Arme", 125, 28,Color.white);
        if (currentInventory.getArmeEquipe() == false) {
            terminal.write("non equipe", 122, 29,Color.red);
        } else {
            terminal.write("equipe", 124, 29,Color.green);
        }

        if (joueur.inventory().getSize() >= 1) {
            if (world.tile(player.x,player.y) == Tile.ITEMS) {
                terminal.writeCenter("You can't drop item here", 41, Color.RED);
            } else {
                terminal.writeCenter("Press [D] to drop current item (You can't drop equipped items)", 40, Color.GRAY); }
        }

        terminal.writeCenter("[ENTER] or [E] to equip/take off current item",38, Color.GRAY);
        terminal.writeCenter("[ESCAPE] or [I] to resume game / [R] go to menu", 42, Color.white);

        if (pos >= 0 && currentInventory.get(pos).getType() == "potion") {
            terminal.writeCenter("Press [ENTER] to use",36, Color.GRAY);
        }
    }

    private Screen testEquipe(Item item) {
        if (item.getType() != "potion") {
            if (item.isEquipe() == false) {
                return equipeItem(item);
            } else {
                return deequipeItem(item);
            }
        } else {
            return testPotion(item);
        }
    }

    private Screen testPotion(Item item) {
        if (item.getType() == "potion") {
            player.getGroupCreature().get(0).modifPointDeVie(item.getEffet());
            player.getGroupCreature().get(0).inventory().remove(item);
            if (this.inVillage == true) {
                return new InventoryScreen(this.villageScreen, this.screen);
            } else {
                return new InventoryScreen(screen);
            }
        } else
            return this;
    }

    private Screen equipeItem(Item item) {
        Inventory currentInventory = player.getGroupCreature().get(0).inventory();
        if (item.isEquipe() == false) {
            if (item.getType() == "arme") {
                if (currentInventory.getArmeEquipe() == false) {
                    item.setEquipe(true);
                    currentInventory.setArmeEquipe(true);
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    }
                    if (item.getName() == "baton" && player.getGroupCreature().get(0).getName() == "Mage") {
                        player.getGroupCreature().get(0).modifAttaque(item.getDammage());
                        player.getGroupCreature().get(0).setmagicattaque(item.getDammage() * 2);
                    } else if (item.getName() == "epee" && player.getGroupCreature().get(0).getName() == "Mage") {
                        player.getGroupCreature().get(0).modifAttaque(item.getDammage());
                        player.getGroupCreature().get(0).setmagicattaque(player.getGroupCreature().get(0).getmagicattaque() - 3);
                    } else {
                        player.getGroupCreature().get(0).modifAttaque(item.getDammage());
                    }
                    return new InventoryScreen(screen);
                }
            } else if (item.getType() == "armure") {
                if (currentInventory.getArmureEquipe() == false) {
                    item.setEquipe(true);
                    currentInventory.setArmureEquipe(true);
                    player.getGroupCreature().get(0).modifDefense(item.getDefense());
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            } else if (item.getType() == "pantalon") {
                if (currentInventory.getPantalonEquipe() == false) {
                    item.setEquipe(true);
                    currentInventory.setPantalonEquipe(true);
                    player.getGroupCreature().get(0).modifDefense(item.getDefense());
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            } else if (item.getType() == "botte"){
                if (currentInventory.getBotteEquipe() == false) {
                    item.setEquipe(true);
                    currentInventory.setBotteEquipe(true);
                    player.getGroupCreature().get(0).modifDefense(item.getDefense());
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            } else if (item.getType() == "casque") {
                if (currentInventory.getCasqueEquipe() == false) {
                    item.setEquipe(true);
                    currentInventory.setCasqueEquipe(true);
                    player.getGroupCreature().get(0).modifDefense(item.getDefense());
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            }
        }
        return this;
    }

    private Screen deequipeItem(Item item) {
        Inventory currentInventory = player.getGroupCreature().get(0).inventory();
        if (item.isEquipe() == true) {
            if (item.getType() == "arme") {
                if (currentInventory.getArmeEquipe() == true) {
                    item.setEquipe(false);
                    currentInventory.setArmeEquipe(false);
                    player.getGroupCreature().get(0).modifAttaque(-(item.getDammage()));
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            } else if (item.getType() == "armure") {
                if (currentInventory.getArmureEquipe() == true) {
                    item.setEquipe(false);
                    currentInventory.setArmureEquipe(false);
                    player.getGroupCreature().get(0).modifDefense(-(item.getDefense()));
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            } else if (item.getType() == "pantalon") {
                if (currentInventory.getPantalonEquipe() == true) {
                    item.setEquipe(false);
                    currentInventory.setPantalonEquipe(false);
                    player.getGroupCreature().get(0).modifDefense(-(item.getDefense()));
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            } else if (item.getType() == "botte") {
                if (currentInventory.getBotteEquipe() == true) {
                    item.setEquipe(false);
                    currentInventory.setBotteEquipe(false);
                    player.getGroupCreature().get(0).modifDefense(-(item.getDefense()));
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            } else if (item.getType() == "casque") {
                if (currentInventory.getCasqueEquipe() == true) {
                    item.setEquipe(false);
                    currentInventory.setCasqueEquipe(false);
                    player.getGroupCreature().get(0).modifDefense(-(item.getDefense()));
                    if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, this.screen);
                    } else {
                        return new InventoryScreen(screen);
                    }
                }
            }
        }
        return this;
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_R: return new MenuScreen(screen);
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_I:
                if (this.inVillage == true) {
                    return new VillageScreen(villageScreen, this.screen);
                } else {
                    return new PlayScreen(world, screen.getVillage(), player, groupCreature);
                }
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
                        if (this.pos - 1 == -1) {
                            this.pos = -1;
                            while (player.getGroupCreature().get(0).inventory().get(pos + 1) == null) {
                                this.pos++;
                            }
                            this.pos = this.pos + 2;
                        }
                    }
                    this.pos--;
                }
                return this;
            case KeyEvent.VK_D:
                if (world.tile(player.x, player.y) == Tile.FLOOR && world.item(player.x, player.y) == null && pos >= 0) {
                    if (player.getGroupCreature().get(0).inventory().get(pos).isEquipe() == false) {
                        if (inVillage == true) {
                            return new DropItemScreen(villageScreen, screen, pos);
                        } else {
                            return new DropItemScreen(screen, pos);
                        }
                    } else if (this.inVillage == true) {
                        return new InventoryScreen(this.villageScreen, screen);
                    } else  return new InventoryScreen(screen);
                } else {
                    return this;
                }
            case KeyEvent.VK_E:
            case KeyEvent.VK_ENTER:
                if (pos >= 0){
                    return testEquipe(player.getGroupCreature().get(0).inventory().get(pos));
                }
        }
        return this;
    }
}