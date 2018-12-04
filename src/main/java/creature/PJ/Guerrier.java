package creature.PJ;
import asciiPanel.AsciiPanel;

import static asciiPanel.AsciiPanel.blue;

public class Guerrier extends PJ{

    public Guerrier(String name, int pointDeVie, int attaque) {
        this.color = blue;
        pointDeVieMax = pointDeVie;
        this.pointDeVie = pointDeVie;
        this.name = name;
        this.attaque = attaque;
        glyph = 'G';
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
