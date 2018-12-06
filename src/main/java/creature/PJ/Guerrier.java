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
        this.attaque = attaque;
        glyph = 'G';
        this.inventory = new Inventory(10);
    }
    @Override
    public int getPointDeVieMax() {
        return pointDeVieMax;
    }

    @Override
    public int getPointDeVie() {
        return pointDeVie;
    }

    @Override
    public int getAttaque() {
        return attaque;
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
