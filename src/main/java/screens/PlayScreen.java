package screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import Tiles.Tile;
import creature.*;
import creature.pj.PJ;
import object.StuffFactory;
import screens.combat.CombatScreen;
import screens.endGame.WinScreen;
import screens.item.InventoryScreen;
import screens.item.PickUpItemScreen;
import screens.menu.*;
import screens.menu.StatScreen;
import screens.village.VillageScreen;
import world.*;

public class PlayScreen implements Screen {
    private int i = 0;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int screenWidth;
    private int screenHeight;
    private World village;
    private boolean inVillage;

    public PlayScreen(PJ choix) {
        screenWidth = 140;
        screenHeight = 40;
        inVillage = false;
        createWorld();
        createVillage();

        CreatureFactory creatureFactory = new CreatureFactory(world);
        StuffFactory stuffFactory = new StuffFactory(world);
        player = creatureFactory.newPlayer(choix);
        createItems(stuffFactory);

        groupCreature = new ArrayList<GroupCreature>();
        ArrayList<Point> listMonster = world.getListMonster();
        for (int i = 0; i < listMonster.size(); i++) {
            Point p = listMonster.get(i);
            groupCreature.add(creatureFactory.newMonster((int)p.getY(),(int)p.getX()));
        }
    }

    public PlayScreen(World world, World village, GroupCreature player,ArrayList<GroupCreature> groupCreature) {
        screenWidth = 140;
        screenHeight = 40;
        inVillage = false;
        this.world = world;
        this.village = village;
        this.player = player;
        this.groupCreature = groupCreature;
    }

    public PlayScreen(PlayScreen screen, GroupCreature playervillage) {
        screenWidth = 140;
        screenHeight = 40;
        inVillage = false;
        this.world = screen.getWorld();
        this.village = screen.getVillage();
        this.player = screen.getPlayer();
        this.player.getGroupCreature().get(0).inventory().removeAllItem();
        this.player.getGroupCreature().get(0).setName(playervillage.getGroupCreature().get(0).getName());
        for (int i = 0; i < playervillage.getGroupCreature().get(0).inventory().getSizeMax(); i++) {
            if (playervillage.getGroupCreature().get(0).inventory().get(i) != null) {
                player.getGroupCreature().get(0).inventory().add(playervillage.getGroupCreature().get(0).inventory().get(i));
            }
        }
        this.player.getGroupCreature().get(0).inventory().setMonnaie(playervillage.getGroupCreature().get(0).inventory().getMonnaie());
        this.groupCreature = screen.getGroupCreature();
        this.player.x = world.getPtSpawn().x;
        this.player.y = world.getPtSpawn().y;
        player.setWorld(this.world);
    }

    public PlayScreen(GroupCreature player, World village) {
        screenWidth = 140;
        screenHeight = 40;
        inVillage = false;
        createWorld();
        this.player = player;
        this.village = village;
        int nv = this.player.getGroupCreature().get(0).getNiveau();
        nv++;
        this.player.getGroupCreature().get(0).setNiveau(nv);
        this.player.x = world.getPositionPersonnageX();
        this.player.y = world.getPositionPersonnageY();
        player.setWorld(this.world);

        CreatureFactory creatureFactory = new CreatureFactory(world);
        StuffFactory stuffFactory = new StuffFactory(world);
        createItems(stuffFactory);

        groupCreature = new ArrayList<GroupCreature>();
        ArrayList<Point> listMonster = world.getListMonster();
        for (int i = 0; i < listMonster.size();i++) {
            Point p = listMonster.get(i);
            groupCreature.add(creatureFactory.newMonster((int)p.getY(),(int)p.getX()));
        }
    }

    public PlayScreen(GroupCreature player) {
        screenWidth = 140;
        screenHeight = 40;
        createWorld();
        this.player = player;
        int nv = this.player.getGroupCreature().get(0).getNiveau();
        nv++;
        this.player.getGroupCreature().get(0).setNiveau(nv);
        this.player.x = world.getPositionPersonnageX();
        this.player.y = world.getPositionPersonnageY();
        player.setWorld(this.world);

        CreatureFactory creatureFactory = new CreatureFactory(world);
        StuffFactory stuffFactory = new StuffFactory(world);
        createItems(stuffFactory);

        groupCreature = new ArrayList<GroupCreature>();
        ArrayList<Point> listMonster = world.getListMonster();
        for (int i = 0; i < listMonster.size();i++) {
            Point p = listMonster.get(i);
            groupCreature.add(creatureFactory.newMonster((int)p.getY(),(int)p.getX()));
        }
    }

    private void createWorld() {
        world = new WorldBuilder(100, 100).build();
    }

    private void createVillage() {
        village = new WorldBuilder(100	, 100).buildVillage();
    }

    private void createItems(StuffFactory factory) {
        for (int i = 0; i < 5; i++) {
            factory.newPotion();
            factory.newPotion();
            factory.newSword();
            factory.newStick();
            factory.newArmure();
            factory.newBotte();
            factory.newCasque();
            factory.newPantalon();
        }
    }

    public int getScrollX() {
        return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
    }

    public int getScrollY() {
        return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight));
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(0, 0, 0));
        terminal.clear();
        int range = 4;

        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top,player.x,player.y,range);
        terminal.write(player.glyph(), player.x - left, player.y - top, player.getColor());

        //terminal.writeCenter("-- bonjour --", 41);
        terminal.write("Vie : " + player.getGroupCreature().get(0).getPointDeVie() + "/" + player.getGroupCreature().get(0).getPointDeVieMax(),110, 41,Color.white);

        terminal.write("Floor : " + player.getGroupCreature().get(0).getNiveau(),125, 41,Color.white);

        if (world.tile(player.x, player.y) == Tile.ITEMS) {
            terminal.write("Press [P] to pickup item", 3, 41);
            terminal.write("item : " + world.item(player.x, player.y).getName(), 35, 41);
        }
    }

    private void creatureMove() {
        for (int i = 0; i < groupCreature.size();i++) {
            int rand = (int)((Math.random() * (4)));
            switch (rand) {
                case 0 :
                    groupCreature.get(i).moveBy(1,0);
                    break;
                case 1 :
                    groupCreature.get(i).moveBy(-1,0);
                    break;
                case 2 :
                    groupCreature.get(i).moveBy(0,1);
                    break;
                case 3 :
                    groupCreature.get(i).moveBy(0,-1);
                    break;
            }
        }
    }

    private void displayTiles(AsciiPanel terminal, int left, int top,int playerx,int playery, int range) {
        int indicexm;
        int indicexma;
        int indiceym;
        int indiceyma;
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                indicexm = playerx - range - left;
                indicexma = playerx + range - left;
                indiceym = playery - range - top;
                indiceyma = playery + range - top;
                int wx = x + left;
                int wy = y + top;

                for (int f = playerx - 1;f > indicexm;f--) {
                    if (world.tile(f,playery) == Tile.WALLUNKNOW || world.tile(f,playery) == Tile.WALL) {
                        indicexm = f - 1;
                        break;
                    }
                }
                for (int f = playerx + 1;f < indicexma;f++) {
                    if (world.tile(f,playery) == Tile.WALLUNKNOW || world.tile(f,playery) == Tile.WALL) {
                        indicexma = f + 1;
                        break;
                    }
                }
                for (int f = playery - 1;f > indiceym;f--) {
                    if (world.tile(playerx,f) == Tile.WALLUNKNOW || world.tile(playerx,f) == Tile.WALL) {
                        indiceym = f - 1 - top;
                    }
                    break;
                }

                for (int f = playery + 1;f < indiceyma;f++) {
                    if (world.tile(playerx,f) == Tile.WALLUNKNOW || world.tile(playerx,f) == Tile.WALL) {
                        indiceyma = f + 1 - top;
                        break;
                    }
                }
                if (x > indicexm && x < indicexma && y > indiceym && y < indiceyma) {

                    for(int l = 0; l < groupCreature.size();l++) {
                        if ((groupCreature.get(l).x - left) > indicexm && (groupCreature.get(l).y - top) > indiceym
                                && (groupCreature.get(l).x - left) < indicexma && (groupCreature.get(l).y - top) < indiceyma) {
                            terminal.write(groupCreature.get(l).glyph(), groupCreature.get(l).x - left, groupCreature.get(l).y - top, groupCreature.get(l).getColor());
                        }
                    }

                    if (world.tile(wx,wy) == Tile.WALLUNKNOW || world.tile(wx,wy) == Tile.WALLALREADYVISITED) {
                        world.tiles[wx][wy] = Tile.WALL;
                        terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                    } else if (world.tile(wx,wy) == Tile.EXITUNKNOW || world.tile(wx,wy) == Tile.EXITALREADYVISITED) {
                        world.tiles[wx][wy] = Tile.EXIT;
                        terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                    } else if (world.tile(wx,wy) == Tile.FLOORUNKNOW || world.tile(wx,wy) == Tile.FLOORALREADYVISITED) {
                        world.tiles[wx][wy] = Tile.FLOOR;
                        terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                    } else if (world.tile(wx,wy) == Tile.VILLAGEPORTALUNKNOW || world.tile(wx,wy) == Tile.VILLAGEPORTALALREADYVISITED) {
                        world.tiles[wx][wy] = Tile.VILLAGEPORTAL;
                        terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                    } else if (world.tile(wx,wy) == Tile.ITEMSUNKNOW || world.tile(wx,wy) == Tile.ITEMALREADYVISITED) {
                        world.tiles[wx][wy] = Tile.ITEMS;
                        if (world.item(wx, wy).getName().equals("baton")) {
                            world.item(wx, wy).setColor(new Color(128, 64, 0));
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        } else if (world.item(wx, wy).getName().equals("epee")) {
                            world.item(wx, wy).setColor(new Color(128, 128, 128));
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        } else if (world.item(wx, wy).getName().equals("potion")) {
                            world.item(wx, wy).setColor(new Color(255, 77, 77));
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        } else if (world.item(wx, wy).getName().equals("armure")) {
                            world.item(wx, wy).setColor(new Color(140, 140, 140));
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        } else if (world.item(wx, wy).getName().equals("botte")) {
                            world.item(wx, wy).setColor(new Color(155, 89, 30));
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        } else if (world.item(wx, wy).getName().equals("casque")) {
                            world.item(wx, wy).setColor(new Color(20, 86, 123));
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        } else if (world.item(wx, wy).getName().equals("pantalon")) {
                            world.item(wx, wy).setColor(new Color(123, 49, 39));
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        } else {
                            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                        }
                    }

                } else if (world.tile(wx,wy) == Tile.WALL && !(x > indicexm && x < indicexma && y > indiceym && y < indiceyma)) {
                    world.tiles[wx][wy] = Tile.WALLALREADYVISITED;
                    terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                } else if (world.tile(wx,wy) == Tile.EXIT && !(x > indicexm && x < indicexma && y > indiceym && y < indiceyma)) {
                    world.tiles[wx][wy] = Tile.EXITALREADYVISITED;
                    terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                } else if (world.tile(wx,wy) == Tile.FLOOR && !(x > indicexm && x < indicexma && y > indiceym && y < indiceyma)) {
                    world.tiles[wx][wy] = Tile.FLOORALREADYVISITED;
                    terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                } else if (world.tile(wx,wy) == Tile.VILLAGEPORTAL && !(x > playerx - range - left && x < playerx + range - left && y > playery - range - top && y < playery + range - top)) {
                    world.tiles[wx][wy] = Tile.VILLAGEPORTALALREADYVISITED;
                    terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                } else if (world.tile(wx,wy) == Tile.ITEMS && !(x > indicexm && x < indicexma && y > indiceym && y < indiceyma)) {
                    world.tiles[wx][wy] = Tile.ITEMALREADYVISITED;
                    world.item(wx,wy).setColor(Color.gray);
                    terminal.write(world.glyph(wx, wy), x, y, world.color(wx,wy));
                } else {
                    terminal.write(world.glyph(wx, wy), x, y,world.color(wx,wy));
                }
            }
        }
        terminal.write(player.glyph(), player.x - left, player.y - top, player.getColor());
    }

    private Screen testRencontre() {
        for (int i = 0; i < groupCreature.size();i++) {
            if (groupCreature.get(i).isNextTo(player.getX(),player.getY())) {
                return new CombatScreen(groupCreature, player, world, village, i, this);
            }
        }
        if (world.tile(player.x,player.y) == Tile.EXIT) {
            if (player.getGroupCreature().get(0).getNiveau() == 99) {
                return new WinScreen();
            } else {
                return new PlayScreen(player, village);
            }
        } else if (world.tile(player.x,player.y) == Tile.VILLAGEPORTAL) {
            inVillage = true;
            return new VillageScreen(this, village);
        }
        return this;
    }

    private Screen testPickUpItem() {
        if (world.tile(player.x, player.y) == Tile.ITEMS && world.item(player.x, player.y) != null) {
            return new PickUpItemScreen(this);
        } else return this;
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
//				System.out.println("pt x : " +world.getPt().x + " pt y : " + world.getPt().y);
                return new MenuScreen(this);
//			case KeyEvent.VK_ENTER:
//				return new WinScreen();
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q: {
                player.moveBy(-1, 0);
                creatureMove();
                return testRencontre();
            }
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D: {
                player.moveBy(1, 0);
                creatureMove();
                return testRencontre();
            }
            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z: {
                player.moveBy(0, -1);
                creatureMove();
                return testRencontre();
            }
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S: {
                player.moveBy(0, 1);
                creatureMove();
                return testRencontre();
            }
            case KeyEvent.VK_I: return new InventoryScreen(this);
            case KeyEvent.VK_P: return testPickUpItem();
            case KeyEvent.VK_C: return new StatScreen(this);
            case KeyEvent.VK_H: return new HelpScreen(this);
//			case KeyEvent.VK_V: return new VillageScreen(this, village);
			/*case KeyEvent.VK_J: player.moveBy( 0, 1); break;
			case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
			case KeyEvent.VK_U: player.moveBy( 1,-1); break;
			case KeyEvent.VK_B: player.moveBy(-1, 1); break;
			case KeyEvent.VK_N: player.moveBy( 1, 1); break;*/
//			case KeyEvent.VK_F: player.getGroupCreature().get(0).setNiveau(99);
        }

        return this;
    }

    public World getWorld() {
        return world;
    }

    public GroupCreature getPlayer() {
        return player;
    }

    public ArrayList<GroupCreature> getGroupCreature() {
        return groupCreature;
    }

    public World getVillage() {
        return village;
    }

    public boolean getInVillage() {
        return inVillage;
    }

    public void setInVillage(boolean b) {
        inVillage = b;
    }
}
