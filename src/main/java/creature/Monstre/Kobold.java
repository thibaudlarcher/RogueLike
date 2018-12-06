package creature.Monstre;
import static asciiPanel.AsciiPanel.red;

public class Kobold extends Monstre{

   public Kobold() {
       name = "Kobold";
       this.color = red;
       pointDeVieMax = 20;
       vitesse = 4;
       tour = 0;
       this.pointDeVie = 20;
       this.attaque = 5;
       glyph = 'K';
    }

}
