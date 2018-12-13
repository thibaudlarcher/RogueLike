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
		Item sword = new ItemArme((char) 197, new Color(128,128,128), "epee",8,23);
		world.addItemAtLocation(sword);
		return sword;
	}

	public Item newStick(){
		Item stick = new ItemArme((char) 179,new Color(128,64,0),"baton",3, 6);
		world.addItemAtLocation(stick);
		return stick;
	}

	public Item newPotion(){
		Item potion = new ItemPotion((char) 225,new Color(255,77,77),"potion",10,14);
		world.addItemAtLocation(potion);
		return potion;
	}

	public Item newArmure(){
		Item armure = new ItemEquipementArmure((char) 190,new Color(140,140,140),"armure",2,17);
		world.addItemAtLocation(armure);
		return armure;
	}

	public Item newBotte(){
		Item botte = new ItemEquipementBotte((char) 200,new Color(155, 89, 30),"botte",1,10);
		world.addItemAtLocation(botte);
		return botte;
	}

	public Item newCasque(){
		Item casque = new ItemEquipementCasque((char) 94, new Color(20, 86,123),"casque",1, 12);
		world.addItemAtLocation(casque);
		return casque;
	}

	public Item newPantalon(){
		Item pantalon = new ItemEquipementPantalon((char) 186,new Color(123, 49, 39),"pantalon",2, 14);
		world.addItemAtLocation(pantalon);
		return pantalon;
	}
}
