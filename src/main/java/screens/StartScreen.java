package screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import asciiPanel.AsciiPanel;

import static java.lang.System.exit;

public class StartScreen implements Screen {

    @Override
    public void displayOutput(AsciiPanel terminal) {

        try {
            String str;
            int comp =0;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/LogoMenu.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[] = str.split(" ");
                System.out.println(comp++);
                terminal.write(sep[0], Integer.parseInt(sep[1]),Integer.parseInt(sep[2]), new Color(Integer.parseInt(sep[3]), Integer.parseInt(sep[4]), Integer.parseInt(sep[5])));
            }
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        terminal.writeCenter("Press Start to play", 40, new Color(255, 255, 255));
    }

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
