package screens.combat;

import asciiPanel.AsciiPanel;

import static asciiPanel.AsciiPanel.black;

public class AffichageDesign {
    private AffichageDesign() {}

    public static void afficheFleche(AsciiPanel terminal, int i) {
        terminal.write("->",7 + i * 30,7,black);
    }
}
