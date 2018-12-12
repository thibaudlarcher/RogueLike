package object;
import object.Items.*;
import world.*;
import java.awt.*;

public class StuffFactory {
	private World world;
	
	public StuffFactory(World world){
		this.world = world;
	}

	public Item newSword(){
		Item sword = new ItemArme((char) 197,Color.black, "epee",5);
		world.addItemAtLocation(sword);
		return sword;
	}

	public Item newStick(){
		Item stick = new ItemArme((char) 179,Color.black,"baton",2);
		world.addItemAtLocation(stick);
		return stick;
	}

	public Item newPotion(){
		Item potion = new ItemPotion((char) 225,Color.black,"potion",10);
		world.addItemAtLocation(potion);
		return potion;
	}

	public Item newArmure(){
		Item armure = new ItemEquipementArmure((char) 190,Color.black,"armure",20);
		world.addItemAtLocation(armure);
		return armure;
	}

	public Item newBotte(){
		Item botte = new ItemEquipementBotte((char) 200,Color.black,"botte",10);
		world.addItemAtLocation(botte);
		return botte;
	}

	public Item newCasque(){
		Item casque = new ItemEquipementCasque((char) 94, Color.black,"casque",10);
		world.addItemAtLocation(casque);
		return casque;
	}

	public Item newPantalon(){
		Item pantalon = new ItemEquipementPantalon((char) 186,Color.black,"pantalon",15);
		world.addItemAtLocation(pantalon);
		return pantalon;
	}
}
