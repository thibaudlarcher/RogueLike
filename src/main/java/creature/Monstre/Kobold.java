package creature.Monstre;
import object.Items.Item;

import static asciiPanel.AsciiPanel.red;

public class Kobold extends Monstre {

    public Kobold() {
        name = "Kobold";
        this.color = red;
        pointDeVieMax = 20;
        vitesse = 4;
        tour = 0;
        this.pointDeVie = 20;
        this.attaque = 6;
        glyph = 'K';
    }


    @Override
    public void dropItem(Item item) {
    }

    @Override
    public void pickupItem(Item item) {
    }
}