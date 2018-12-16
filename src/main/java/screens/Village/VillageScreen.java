package screens.Village;

import Tiles.Tile;
import asciiPanel.AsciiPanel;
import creature.CreatureFactory;
import creature.GroupCreature;
import screens.*;
import screens.Item.InventoryScreen;
import screens.Item.PickUpItemScreen;
import world.World;
import world.WorldBuilder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class VillageScreen implements Screen {

    private World village;
    private GroupCreature playerVillage;
    private int screenWidth;
    private int screenHeight;
    private PlayScreen playscreen;


    public VillageScreen(PlayScreen screen){
        screenWidth = 140;
        screenHeight = 40;
        this.playscreen = screen;
        createVillage();

        CreatureFactory creatureFactory = new CreatureFactory(village);
        this.playerVillage = screen.getPlayer();
        this.playerVillage.x = village.getPositionPersonnageX();
        this.playerVillage.y = village.getPositionPersonnageY();
        this.playerVillage.setWorld(village);
    }

    public VillageScreen(VillageScreen villageScreen, PlayScreen screen){
        screenWidth = 140;
        screenHeight = 40;
        this.playscreen = screen;
        this.village = villageScreen.getVillage();
        this.playerVillage = villageScreen.getPlayer();
    }

    private void createVillage(){
        village = new WorldBuilder(100	, 100).buildVillage();
    }

    public int getScrollX() { return Math.max(0, Math.min(playerVillage.x - screenWidth / 2, village.width() - screenWidth)); }

    public int getScrollY() { return Math.max(0, Math.min(playerVillage.y - screenHeight / 2, village.height() - screenHeight)); }

    private void displayTiles(AsciiPanel terminal, int left, int top,int playerx,int playery, int range) {
        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;
                if (x>playerx-range-left && x<playerx+range-left && y>playery-range-top && y<playery+range-top){
                    if (village.tile(wx,wy)==Tile.WALLUNKNOW || village.tile(wx,wy)==Tile.WALLALREADYVISITED){
                        village.tiles[wx][wy]=Tile.WALL;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                    } else if (village.tile(wx,wy)==Tile.EXITUNKNOW || village.tile(wx,wy)==Tile.EXITALREADYVISITED){
                        village.tiles[wx][wy]=Tile.EXIT;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                    } else if (village.tile(wx,wy)==Tile.FLOORUNKNOW || village.tile(wx,wy)==Tile.FLOORALREADYVISITED){
                        village.tiles[wx][wy]=Tile.FLOOR;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                    } else if (village.tile(wx,wy)==Tile.VILLAGEPORTALUNKNOW || village.tile(wx,wy)==Tile.VILLAGEPORTALALREADYVISITED){
                        village.tiles[wx][wy]=Tile.VILLAGEPORTAL;
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                    } else if (village.tile(wx,wy)==Tile.ITEMSUNKNOW || village.tile(wx,wy)==Tile.ITEMALREADYVISITED){
                        village.tiles[wx][wy]=Tile.ITEMS;
                        if (village.item(wx,wy).getName()=="baton"){
                            village.item(wx,wy).setColor(new Color(128,64,0));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx,wy).getName()=="epee"){
                            village.item(wx,wy).setColor(new Color(128,128,128));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx,wy).getName()=="potion"){
                            village.item(wx,wy).setColor(new Color(255,77,77));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx,wy).getName()=="armure"){
                            village.item(wx,wy).setColor(new Color(140,140,140));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx,wy).getName()=="botte"){
                            village.item(wx,wy).setColor(new Color(155, 89, 30));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx,wy).getName()=="casque"){
                            village.item(wx,wy).setColor(new Color(20, 86,123));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx,wy).getName()=="pantalon"){
                            village.item(wx,wy).setColor(new Color(123, 49, 39));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        } else if (village.item(wx,wy).getName() == "pierre de teleportation"){
                            village.item(wx,wy).setColor(new Color(0, 19, 255));
                            terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                        }
                    }
                    else{
                        terminal.write(village.glyph(wx, wy), x, y, village.color(wx, wy));
                    }
                } else if (village.tile(wx,wy)==Tile.WALL && !(x>playerx-range-left && x<playerx+range-left && y>playery-range-top && y<playery+range-top)){
                    village.tiles[wx][wy]=Tile.WALLALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                } else if (village.tile(wx,wy)==Tile.EXIT && !(x>playerx-range-left && x<playerx+range-left && y>playery-range-top && y<playery+range-top)){
                    village.tiles[wx][wy]=Tile.EXITALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                } else if (village.tile(wx,wy)==Tile.FLOOR && !(x>playerx-range-left && x<playerx+range-left && y>playery-range-top && y<playery+range-top)){
                    village.tiles[wx][wy]=Tile.FLOORALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                } else if (village.tile(wx,wy)==Tile.VILLAGEPORTAL && !(x>playerx-range-left && x<playerx+range-left && y>playery-range-top && y<playery+range-top)){
                    village.tiles[wx][wy]=Tile.VILLAGEPORTALALREADYVISITED;
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                } else if (village.tile(wx,wy)==Tile.ITEMS && !(x>playerx-range-left && x<playerx+range-left && y>playery-range-top && y<playery+range-top)){
                    village.tiles[wx][wy]=Tile.ITEMALREADYVISITED;
                    village.item(wx,wy).setColor(Color.gray);
                    terminal.write(village.glyph(wx, wy), x, y, village.color(wx,wy));
                }
                else {
                    terminal.write(village.glyph(wx, wy), x, y,village.color(wx,wy));
                }
            }
        }
        terminal.write(playerVillage.glyph(), playerVillage.x - left, playerVillage.y - top, playerVillage.getColor());
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(0, 0, 0));
        terminal.clear();
        int range =10;

        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top,playerVillage.x,playerVillage.y,range);
        terminal.write(playerVillage.glyph(), playerVillage.x - left, playerVillage.y - top, playerVillage.getColor());

        //terminal.writeCenter("-- bonjour --", 41);
        terminal.write("Vie : "+playerVillage.getGroupCreature().get(0).getPointDeVie()+"/"
                +playerVillage.getGroupCreature().get(0).getPointDeVieMax() ,110, 41,Color.white);

        terminal.write("Floor : "+playerVillage.getGroupCreature().get(0).getNiveau() ,125, 41,Color.white);

        if (village.tile(playerVillage.x, playerVillage.y) == Tile.ITEMS) {
            terminal.write("Press [P] to pickup item", 3, 41);
            terminal.write("item : " + village.item(playerVillage.x, playerVillage.y).getName(), 35, 41);
        }
    }

    private Screen testPickUpItem(){
        if (village.tile(playerVillage.x, playerVillage.y) == Tile.ITEMS && village.item(playerVillage.x, playerVillage.y) != null){
            return new PickUpItemScreen(this, this.playscreen);
        } else return this;
    }

    private Screen testRencontre(){
//        for(int i = 0; i < groupCreature.size();i++) {
//            if (groupCreature.get(i).isNextTo(playerVillage.getX(),playerVillage.getY())) {
//                return new CombatScreen(groupCreature, playerVillage, village, i);
//            }
//        }
        if (village.tile(playerVillage.x,playerVillage.y)==Tile.EXIT){
                return new PlayScreen(this.playscreen);
        }
        return this;
    }

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
                playerVillage.moveBy( 0, 1);
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

    public World getVillage() {
        return village;
    }

    public GroupCreature getPlayer() {
        return playerVillage;
    }
}
