package screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.util.Timer;
import java.util.TimerTask;

import asciiPanel.AsciiPanel;

import static java.lang.System.exit;

public class StartScreen implements Screen {

    @Override
    public void displayOutput(final AsciiPanel terminal) {

        try {
            String str;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/LogoMenu.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[] = str.split(" ");
                terminal.write(sep[0], Integer.parseInt(sep[1]),Integer.parseInt(sep[2]), new Color(Integer.parseInt(sep[3]), Integer.parseInt(sep[4]), Integer.parseInt(sep[5])));
            }
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        terminal.writeCenter("Press start to play", 41, new Color(255, 255, 255));
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
