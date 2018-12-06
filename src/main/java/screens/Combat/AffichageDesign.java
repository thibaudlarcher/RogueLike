package screens.Combat;

import asciiPanel.AsciiPanel;

import static asciiPanel.AsciiPanel.black;
import static asciiPanel.AsciiPanel.white;

public class AffichageDesign {
    private AffichageDesign() {}

    public static void afficheFleche(AsciiPanel terminal, int i) {
        terminal.write("->",7 + i*30,7,black);
    }
}
