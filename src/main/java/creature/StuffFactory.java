package creature;
import object.Items.Item;
import object.Items.ItemArme;
import world.*;
import java.awt.*;

public class StuffFactory {
	private World world;
	
	public StuffFactory(World world){
		this.world = world;
	}

	public Item newSword(){
		Item sword = new ItemArme((char) 197, new Color(128,128,128), "epee",5);
		world.addItemAtLocation(sword);
		return sword;
	}

	public Item newStick(){
		Item stick = new ItemArme((char) 179,new Color(128,64,0),"baton",2);
		world.addItemAtLocation(stick);
		return stick;
	}
}
