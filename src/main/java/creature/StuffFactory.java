package creature;
import Object.Items.Item;
import Object.Items.ItemArme;
import world.*;
import java.awt.*;

public class StuffFactory {
	private World world;
	
	public StuffFactory(World world){
		this.world = world;
	}

	public Item newSword(){
		Item sword = new ItemArme((char) 180, new Color(128,128,128), "sword",5);
		world.addItemAtLocation(sword);
		return sword;
	}

	public Item newBaton(){
		Item baton = new ItemArme((char) 179,new Color(128,64,0),"baton",2);
		world.addItemAtLocation(baton);
		return baton;
	}
}
