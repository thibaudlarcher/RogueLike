package screens;

import java.awt.event.KeyEvent;
import java.util.List;

import asciiPanel.AsciiPanel;
import creature.*;
import world.*;

public class PlayScreen implements Screen {
	private World world;
	private Creature player;
	private List<Creature> creature;
	private int screenWidth;
	private int screenHeight;
	
	public PlayScreen(){
		screenWidth = 160;
		screenHeight = 46;
		createWorld();
		
		CreatureFactory creatureFactory = new CreatureFactory(world);
		player = creatureFactory.newPlayer();
		//createItems(creatureFactory);
		creatureFactory.newMonster();
	}
	
	private void createWorld(){
		world = new WorldBuilder(100	, 100).build();
	}

//	private void createItems(CreatureFactory factory) {
//		for (int i = 0; i < world.width() * world.height() / 10; i++){
//			factory.newRock();
//		}
//	}
	
	public int getScrollX() { return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight)); }
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		int left = getScrollX();
		int top = getScrollY();
		
		displayTiles(terminal, left, top);
		
		terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
		
		terminal.writeCenter("-- bonjour --", 47);
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
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
		case KeyEvent.VK_ESCAPE: return new LoseScreen();
		case KeyEvent.VK_ENTER: return new WinScreen();
		case KeyEvent.VK_I: return new InventoryScreen(this);
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_Q: player.moveBy(-1, 0); break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D: player.moveBy( 1, 0); break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_Z: player.moveBy( 0,-1); break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S: player.moveBy( 0, 1); break;
		/*case KeyEvent.VK_J: player.moveBy( 0, 1); break;
		case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
		case KeyEvent.VK_U: player.moveBy( 1,-1); break;
		case KeyEvent.VK_B: player.moveBy(-1, 1); break;
		case KeyEvent.VK_N: player.moveBy( 1, 1); break;*/
		}
		
		return this;
	}
}
