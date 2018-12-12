package screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import color.Tile;
import creature.*;
import object.StuffFactory;
import screens.Combat.CombatScreen;
import screens.Item.InventoryScreen;
import screens.Item.PickUpItemScreen;
import world.*;

public class PlayScreen implements Screen {
	private World world;
	private GroupCreature player;
	private ArrayList<GroupCreature> groupCreature;
	private int screenWidth;
	private int screenHeight;
	
	public PlayScreen(){
		screenWidth = 140;
		screenHeight = 40;
		createWorld();

		CreatureFactory creatureFactory = new CreatureFactory(world);
		StuffFactory stuffFactory = new StuffFactory(world);
		player = creatureFactory.newPlayer();
		createItems(stuffFactory);

		groupCreature = new ArrayList<GroupCreature>();
		ArrayList<Point>listMonster = world.getListMonster();
		for(int i = 0 ; i<listMonster.size();i++){
			Point p = listMonster.get(i);
			groupCreature.add(creatureFactory.newMonster((int)p.getY(),(int)p.getX()));
		}
	}

	public PlayScreen(World world, GroupCreature player,ArrayList<GroupCreature> groupCreature){
		screenWidth = 140;
		screenHeight = 40;
		this.world = world;
		this.player = player;
		this.groupCreature = groupCreature;
	}

	public PlayScreen(GroupCreature player){
        screenWidth = 140;
        screenHeight = 40;
        createWorld();
        this.player= player;
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
        ArrayList<Point>listMonster = world.getListMonster();
        for(int i = 0 ; i<listMonster.size();i++){
            Point p = listMonster.get(i);
            groupCreature.add(creatureFactory.newMonster((int)p.getY(),(int)p.getX()));
        }
    }

	private void createWorld(){
		world = new WorldBuilder(100	, 100).build();
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

	public int getScrollX() { return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight)); }
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.setDefaultBackgroundColor(new Color(0, 0, 0));
		terminal.clear();

		int left = getScrollX();
		int top = getScrollY();
		
		displayTiles(terminal, left, top);
		terminal.write(player.glyph(), player.x - left, player.y - top, player.getColor());

		//terminal.writeCenter("-- bonjour --", 41);
		terminal.write("Vie : "+player.getGroupCreature().get(0).getPointDeVie()+"/"
				+player.getGroupCreature().get(0).getPointDeVieMax() ,110, 41,Color.white);

		terminal.write("Floor : "+player.getGroupCreature().get(0).getNiveau() ,125, 41,Color.white);

		if (world.tile(player.x, player.y) == Tile.ITEMS){
			terminal.write("Press [P] to pickup item",3,41);
			terminal.write("item : "+world.item(player.x,player.y).getName(),35,41);
		}

		for(int i = 0 ; i<groupCreature.size();i++){
			if((groupCreature.get(i).x-left) <= 0 || (groupCreature.get(i).y-top)<=0 || (groupCreature.get(i).y-top) >= 40 || (groupCreature.get(i).x-left) <= 0){
			}else {
				terminal.write(groupCreature.get(i).glyph(), groupCreature.get(i).x- left, groupCreature.get(i).y -top , groupCreature.get(i).getColor());
			}
		}
		terminal.write(player.glyph(), player.x - left, player.y - top, player.getColor());
	}

	private void creatureMove(){
		for(int i = 0 ; i<groupCreature.size();i++){
			int rand = (int)((Math.random() * ( 4 )));
			switch (rand){
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

	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;
				//System.out.println("x : "+ x + "y : "+ y);
				terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
			}
		}
	}

	private Screen testRencontre(){
		for(int i = 0; i < groupCreature.size();i++) {
			if (groupCreature.get(i).isNextTo(player.getX(),player.getY())) {
				return new CombatScreen(groupCreature, player, world, i);
			}
		}
		if (world.tile(player.x,player.y)==Tile.EXIT){
			return new PlayScreen(player);
		}
		return this;
	}

	private Screen testPickUpItem(){
		if (world.tile(player.x, player.y) == Tile.ITEMS && world.item(player.x, player.y) != null){
			return new PickUpItemScreen(groupCreature,player,world);
		} else return this;
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				return new MenuScreen(groupCreature,player,world);
			case KeyEvent.VK_ENTER:
				return new WinScreen();
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
                player.moveBy( 0, 1);
                creatureMove();
                return testRencontre();
            }
			case KeyEvent.VK_I: return new InventoryScreen(player, world, groupCreature);
			case KeyEvent.VK_P: return testPickUpItem();
			case KeyEvent.VK_C: return new StatScreen(groupCreature,player,world);
			case KeyEvent.VK_H: return new HelpScreen(groupCreature,player,world);
			/*case KeyEvent.VK_J: player.moveBy( 0, 1); break;
			case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
			case KeyEvent.VK_U: player.moveBy( 1,-1); break;
			case KeyEvent.VK_B: player.moveBy(-1, 1); break;
			case KeyEvent.VK_N: player.moveBy( 1, 1); break;*/
		}

		return this;
	}
}
