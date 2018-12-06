package creature.PJ;
import Object.Items.*;
import Object.*;
import static asciiPanel.AsciiPanel.brightGreen;
import static asciiPanel.AsciiPanel.blue;

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
