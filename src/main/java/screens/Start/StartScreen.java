package screens.start;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import asciiPanel.AsciiPanel;
import screens.Screen;

import static java.lang.System.exit;

/**
 * Classe du screen du start Screen
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class StartScreen implements Screen {

    /**
     * Permet d'afficher le start Screen
     * @param terminal Asciipanel
     */
    @Override
    public void displayOutput(final AsciiPanel terminal) {

        try {
            String str;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/LogoMenu.txt"));
            while ((str = fichier.readLine()) != null) {
                String[] sep = str.split(" ");
                terminal.write(sep[0], Integer.parseInt(sep[1]),Integer.parseInt(sep[2]), new Color(Integer.parseInt(sep[3]), Integer.parseInt(sep[4]), Integer.parseInt(sep[5])));
            }
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        terminal.writeCenter("Press start to play", 41, new Color(255, 255, 255));
    }

    /**
     * Permet de gérer les actions du clavier et ainsi lui donner des actions.
     * @param key Appuie sur une touche
     * @return Un Screen
     */
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new LoadSreen();
            case KeyEvent.VK_ESCAPE:
                exit(1);
        }
        return this;
    }
}
