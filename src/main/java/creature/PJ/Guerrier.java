package creature.PJ;
import object.Items.*;
import object.*;
import static asciiPanel.AsciiPanel.brightGreen;

public class Guerrier extends PJ{

    public Guerrier(String name, int pointDeVie, int attaque) {
       this.color = brightGreen;
        pointDeVieMax = pointDeVie;
        this.pointDeVie = pointDeVie;
        this.name = name;
        vitesse = 6;
        tour = 0;
        this.attaque = attaque;
        glyph = 'G';
        this.inventory = new Inventory(20);
    }

    @Override
    public void pickupItem(Item item){
        if (!(inventory.isFull()) || item != null){
            inventory.add(item);
        }
    }

    @Override
    public void dropItem(Item item){
        inventory.remove(item);
    }
}
