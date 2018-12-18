package creature.PJ;
import object.Items.*;
import object.*;

import java.awt.*;


public class Mage extends PJ{

    public Mage(String name, int pointDeVie, int attaque, int magicattaque) {
        this.color = new Color(171,71,188);
        pointDeVieMax = pointDeVie;
        this.pointDeVie = pointDeVie;
        this.name = name;
        vitesse = 6;
        tour = 0;
        this.attaque = attaque;
        this.magicattaque= magicattaque;
        glyph = 'M';
        this.inventory = new Inventory(10);
        this.defense = 0;
    }

    public Mage() {
        this.color = new Color(171,71,188);
        vitesse = 6;
        tour = 0;
        glyph = 'M';
        this.inventory = new Inventory(10);
        this.defense = 0;
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

    @Override
    public void updateAttaque(int attaque) {}
}
