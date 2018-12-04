package creature.Monstre;

import static asciiPanel.AsciiPanel.red;

public class Kobold extends Monstre{

    public Kobold(int pointDeVie, int attaque) {
        this.color = red;
        pointDeVieMax = pointDeVie;
        this.pointDeVie = pointDeVie;
        this.attaque = attaque;
        glyph = 'K';
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
}
