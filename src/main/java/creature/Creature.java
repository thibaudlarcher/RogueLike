package creature;
import java.awt.Color;
import world.World;
import Object.*;

public class Creature {
	private World world;

	private Inventory inventory;
	public Inventory inventory() { return inventory; }

	public int x;
	public int y;
	
	private char glyph;
	public char glyph() { return glyph; }
	
	private Color color;
	public Color color() { return color; }

	private CreatureAi ai;
	public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
	
	public Creature(World world, char glyph, Color color){
		this.world = world;
		this.glyph = glyph;
		this.color = color;
		this.inventory = new Inventory(10);
	}
	
	public void moveBy(int mx, int my){
		ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
		System.out.println("x :"+ x+ "y : " + y);
	}

//	public void pickupItem(){
//		Item item = world.item(x,y);
//
//		if (inventory.isFull() || item == null){
//			doAction("grab at the ground");
//		} else {
//			doAction("pickup a %s", item.name());
//			world.remove(x, y);
//			inventory.add(item);
//		}
//	}

//	public void drop(Item item){
//		doAction("drop a " + item.name());
//		inventory.remove(item);
//		world.addAtEmptySpace(item, x, y, z);
//	}

}
