package screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import asciiPanel.AsciiPanel;
import color.Tile;
import creature.*;
import screens.Combat.CombatScreen;
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
		player = creatureFactory.newPlayer();
		groupCreature = new ArrayList<GroupCreature>();

		groupCreature.add(creatureFactory.newMonster());
	}
	
	private void createWorld(){
		world = new WorldBuilder(100	, 100).build();
	}
	
	public int getScrollX() { return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight)); }
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		int left = getScrollX();
		int top = getScrollY();
		
		displayTiles(terminal, left, top);
		
		terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
		
		//terminal.writeCenter("-- bonjour --", 35);
	}

	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;

				terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
			}
		}
	}

	private Screen testRencontre(){
		if(world.tile(player.x,player.y) == Tile.MONSTER){
			return new CombatScreen(groupCreature,player,world);
		}else return this;
	}
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
		case KeyEvent.VK_ESCAPE: return new LoseScreen();
		case KeyEvent.VK_ENTER: return new WinScreen();
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_Q: player.moveBy(-1, 0);return testRencontre();
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D: player.moveBy( 1, 0);return testRencontre();
		case KeyEvent.VK_UP:
		case KeyEvent.VK_Z: player.moveBy( 0,-1);return testRencontre();
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S: player.moveBy( 0, 1);return testRencontre();
		/*case KeyEvent.VK_J: player.moveBy( 0, 1); break;
		case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
		case KeyEvent.VK_U: player.moveBy( 1,-1); break;
		case KeyEvent.VK_B: player.moveBy(-1, 1); break;
		case KeyEvent.VK_N: player.moveBy( 1, 1); break;*/
		}
		
		return this;
	}
}
