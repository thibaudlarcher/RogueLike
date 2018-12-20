package screens.village;

import Tiles.Tile;
import asciiPanel.AsciiPanel;
import creature.CreatureFactory;
import creature.GroupCreature;
import screens.*;
import screens.endgame.WinScreen;
import screens.item.InventoryScreen;
import screens.item.PickUpItemScreen;
import screens.menu.HelpScreen;
import screens.menu.MenuScreen;
import screens.menu.StatScreen;
import world.World;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Classe du village
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class VillageScreen implements Screen {
    /**
     * world du village
     */
    private World village;

    /**
     * les villageois
     */
    private GroupCreature playerVillage;
    /**
     * groupe de Villageois
     */
    private ArrayList<GroupCreature> groupVillageois;

    /**
     * taille du l'affichage Largeur
     */
    private int screenWidth;

    /**
     * taille du l'affichage Hauteur
     */
    private int screenHeight;

    /**
     * Screen play
     */
    private PlayScreen playscreen;

    /**
     * Constructeur de la classe VillageScreen.
     * @param screen Screen
     * @param village world du village
     */
    public VillageScreen(PlayScreen screen, World village) {
        screenWidth = 140;
        screenHeight = 40;
        this.playscreen = screen;
        this.village = village;

        CreatureFactory creatureFactory = new CreatureFactory(this.village);
        this.playerVillage = creatureFactory.newPlayerVillage(screen.getPlayer());
        this.playerVillage.setWorld(village);

        groupVillageois = new ArrayList<GroupCreature>();
        ArrayList<Point> listVillageois = village.getListVillageois();
        for (int i = 0; i < listVillageois.size(); i++) {
            Point p = listVillageois.get(i);
            groupVillageois.add(creatureFactory.newVillageois((int) p.getX(), (int) p.getY()));
        }
        this.playerVillage.getGroupCreature().get(0).inventory().setMonnaie(screen.getPlayer().getGroupCreature().get(0).inventory().getMonnaie());
    }

    /**
     * Constructeur alternatif a la classe VillageScreen.
     * @param villageScreen Screen
     * @param screen world du village
     */
    public VillageScreen(VillageScreen villageScreen, PlayScreen screen) {
        screenWidth = 140;
        screenHeight = 40;
        this.playscreen = screen;
        this.village = villageScreen.getVillage();
        this.playerVillage = villageScreen.getPlayer();
        this.groupVillageois = villageScreen.groupVillageois;
    }

    /**
     * Méthode pour le scroll du personnage.
     * @return valeur du scoll en largeur
     */
    public int getScrollX() {
        return Math.max(0, Math.min(playerVillage.x - screenWidth / 2, village.width() - screenWidth));
    }

    /**
     * Méthode pour le scroll du personnage.
     * @return valeur du scoll en hauteur
     */
    public int getScrollY() {
        return Math.max(0, Math.min(playerVillage.y - screenHeight / 2, village.height() - screenHeight));
    }

    /**
     * Permet d'afficher les tiles sur l'écran.
     * @param terminal asciipanel
     * @param left le scroll en x
     * @param top le scroll en y
     * @param playerx position en x du player
     * @param playery position en y du player
     * @param range le champ de vision du player
     */
    private void displayTiles(AsciiPanel terminal, int left, int top,int playerx,int playery, int range) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                for (int l = 0; l < groupVillageois.size(); l++) {
                    if ((groupVillageois.get(l).x - left) > playerVillage.x - left - range && (groupVillageois.get(l).y - top) > playerVillage.y - top - range
                            && (groupVillageois.get(l).x - left) < playerVillage.x - left + range && (groupVillageois.get(l).y - top) < playerVillage.y - top + range) {
                        terminal.write(groupVillageois.get(l).glyph(), groupVillageois.get(l).x - left, groupVillageois.get(l).y - top, groupVillageois.get(l).getColor());
                    }
                }

                if (x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top) {
                    if (village.tile(wx, wy) == Tile.WALLUNKNOW || village.tile(wx, wy) == Tile.WALLALREADYVISITED) {
                        village.tiles[wx][wy] = Tile.WALL;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                    } else if (village.tile(wx, wy) == Tile.EXITUNKNOW || village.tile(wx, wy) == Tile.EXITALREADYVISITED) {
                        village.tiles[wx][wy] = Tile.EXIT;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                    } else if (village.tile(wx, wy) == Tile.VILLAGEOISVISITED) {
                        village.tiles[wx][wy] = Tile.VILLAGEOIS;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                    } else if (village.tile(wx, wy) == Tile.FLOORUNKNOW || village.tile(wx, wy) == Tile.FLOORALREADYVISITED) {
                        village.tiles[wx][wy] = Tile.FLOOR;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                    } else if (village.tile(wx, wy) == Tile.VILLAGEPORTALUNKNOW || village.tile(wx, wy) == Tile.VILLAGEPORTALALREADYVISITED) {
                        village.tiles[wx][wy] = Tile.VILLAGEPORTAL;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                    } else if (village.tile(wx, wy) == Tile.ITEMSUNKNOW || village.tile(wx, wy) == Tile.ITEMALREADYVISITED) {
                        village.tiles[wx][wy] = Tile.ITEMS;
                        if (village.item(wx, wy).getName() == "baton") {
                            village.item(wx, wy).setColor(new Color(128, 64, 0));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx, wy).getName() == "epee") {
                            village.item(wx, wy).setColor(new Color(128, 128, 128));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx, wy).getName() == "potion") {
                            village.item(wx, wy).setColor(new Color(255, 77, 77));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx, wy).getName() == "armure") {
                            village.item(wx, wy).setColor(new Color(140, 140, 140));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx, wy).getName() == "botte") {
                            village.item(wx, wy).setColor(new Color(155, 89, 30));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx, wy).getName() == "casque") {
                            village.item(wx, wy).setColor(new Color(20, 86, 123));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx, wy).getName() == "pantalon") {
                            village.item(wx, wy).setColor(new Color(123, 49, 39));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx, wy).getName() == "pierre de teleportation") {
                            village.item(wx, wy).setColor(new Color(0, 19, 255));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        }
                    } else {
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                    }
                } else if (village.tile(wx, wy) == Tile.WALL && !(x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top)) {
                    village.tiles[wx][wy] = Tile.WALLALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                } else if (village.tile(wx, wy) == Tile.EXIT && !(x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top)) {
                    village.tiles[wx][wy] = Tile.EXITALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                } else if (village.tile(wx, wy) == Tile.FLOOR && !(x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top)) {
                    village.tiles[wx][wy] = Tile.FLOORALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                } else if (village.tile(wx, wy) == Tile.VILLAGEOIS && !(x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top)) {
                    village.tiles[wx][wy] = Tile.VILLAGEOISVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                } else if (village.tile(wx, wy) == Tile.VILLAGEPORTAL && !(x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top)) {
                    village.tiles[wx][wy] = Tile.VILLAGEPORTALALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                } else if (village.tile(wx, wy) == Tile.ITEMS && !(x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top)) {
                    village.tiles[wx][wy] = Tile.ITEMALREADYVISITED;
                    village.item(wx, wy).setColor(Color.gray);
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                } else {
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                }
            }
        }
        terminal.write(playerVillage.glyph(), playerVillage.x - left, playerVillage.y - top, playerVillage.getColor());
    }

    /**
     * Permet d'afficher dans le terminal de ascii panel.
     * @param terminal asciipanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(0, 0, 0));
        terminal.clear();
        int range = 10;

        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top,playerVillage.x, playerVillage.y,range);
        terminal.write(playerVillage.glyph(), playerVillage.x - left, playerVillage.y - top, playerVillage.getColor());

        //terminal.writeCenter("-- bonjour --", 41);
        terminal.write("Vie : " + playerVillage.getGroupCreature().get(0).getPointDeVie() + "/" + playerVillage.getGroupCreature().get(0).getPointDeVieMax(),110, 41,Color.white);

        terminal.write("Floor : " + playerVillage.getGroupCreature().get(0).getNiveau(),125, 41,Color.white);

        if (village.tile(playerVillage.x, playerVillage.y) == Tile.ITEMS) {
            terminal.write("Press [P] to pickup item", 3, 41);
            terminal.write("item : " + village.item(playerVillage.x, playerVillage.y).getName(), 35, 41);
        }
    }

    /**
     * Permet de tester si on peut récupérer un item sur un tile
     * @return le Screen du pickup item
     */
    private Screen testPickUpItem() {
        if (village.tile(playerVillage.x, playerVillage.y) == Tile.ITEMS && village.item(playerVillage.x, playerVillage.y) != null) {
            return new PickUpItemScreen(this, this.playscreen);
        } else return this;
    }

    /**
     * Permet de tester si on peux rencontrer le villageoi
     * @return me Screen
     */
    private Screen testRencontre() {
        if (village.tile(playerVillage.x, playerVillage.y) == Tile.VILLAGEOIS) {
            return new VillageoisScreen(this);
        }
        if (village.tile(playerVillage.x, playerVillage.y) == Tile.EXIT) {
            playscreen.setInVillage(false);
            GroupCreature player = playscreen.getPlayer();
            return new PlayScreen(this.playscreen, this.playerVillage);
        }
        return this;
    }

    /**
     * Permet de gérer les actions du clavier et ainsi lui donner des actions.
     * @param key Appuie sur une touche
     * @return Un Screen
     */
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return new MenuScreen(this, playscreen);
            case KeyEvent.VK_ENTER:
                return new WinScreen();
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q: {
                playerVillage.moveBy(-1, 0);
                return testRencontre();
            }
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D: {
                playerVillage.moveBy(1, 0);
                return testRencontre();
            }
            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z: {
                playerVillage.moveBy(0, -1);
                return testRencontre();
            }
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S: {
                playerVillage.moveBy(0, 1);
                return testRencontre();

            }
            case KeyEvent.VK_I: return new InventoryScreen(this, this.playscreen);
            case KeyEvent.VK_P: return testPickUpItem();
            case KeyEvent.VK_C: return new StatScreen(this, playscreen);
            case KeyEvent.VK_H: return new HelpScreen(this, playscreen);
			/*case KeyEvent.VK_J: player.moveBy( 0, 1); break;
			case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
			case KeyEvent.VK_U: player.moveBy( 1,-1); break;
			case KeyEvent.VK_B: player.moveBy(-1, 1); break;
			case KeyEvent.VK_N: player.moveBy( 1, 1); break;*/
        }

        return this;
    }

    /**
     * Getter du world village.
     * @return world village
     */
    public World getVillage() {
        return village;
    }

    /**
     * Getter du player.
     * @return player
     */
    public GroupCreature getPlayer() {
        return playerVillage;
    }

    /**
     * Getter du groupe de villageois.
     * @return groupe de villageois
     */
    public ArrayList<GroupCreature> getGroupVillageois() {
        return groupVillageois;
    }

    /**
     * Getter Screen du jeu.
     * @return Screen du jeu
     */
    public PlayScreen getPlayscreen() {
        return playscreen;
    }
}