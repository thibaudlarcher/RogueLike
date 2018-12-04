package creature.PJ;
import asciiPanel.AsciiPanel;

import static asciiPanel.AsciiPanel.blue;
import static asciiPanel.AsciiPanel.brightGreen;

public class Guerrier extends PJ{

    public Guerrier(String name, int pointDeVie, int attaque) {
        this.color = brightGreen;
        pointDeVieMax = pointDeVie;
        this.pointDeVie = pointDeVie;
        this.name = name;
        this.attaque = attaque;
        glyph = 'G';
    }

}
