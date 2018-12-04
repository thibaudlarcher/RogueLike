package creature;
import asciiPanel.AsciiPanel;
import creature.Monstre.Kobold;
import creature.PJ.Guerrier;
import world.*;
import player.*;
import Object.*;
import monster.*;
public class StuffFactory {
	private World world;
	
	public StuffFactory(World world){
		this.world = world;
	}

	public Item newSword(){
		Item sword = new Item((char) 180, AsciiPanel.yellow, "sword");
		world.addItemAtLocation(sword);
		return sword;
	}

}
