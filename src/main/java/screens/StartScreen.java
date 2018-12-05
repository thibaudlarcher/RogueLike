package screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {

		//------------------------ I ------------------------
		terminal.write('#', 5, 1, new Color(61, 50, 5)); // Color(61,50,5)
		terminal.write('#', 6, 1, new Color(61, 50, 5)); //Color(125,102,8)
		terminal.write('#', 7, 1, new Color(61, 50, 5)); //Color(241,196,15)
		terminal.write('#', 8, 1, new Color(61, 50, 5));
		terminal.write('#', 9, 1, new Color(61, 50, 5));
		terminal.write('#', 10, 1, new Color(61, 50, 5));

		terminal.write('#', 2, 2, new Color(61, 50, 5));
		terminal.write('#', 8, 1, new Color(154, 125, 10));
		terminal.write('#', 9, 1, new Color(154, 125, 10));
		terminal.write('#', 10, 1, new Color(154, 125, 10));

		terminal.write('#', 2, 2, new Color(154, 125, 10));
		terminal.write('#', 3, 2, new Color(241, 196, 15));
		terminal.write('#', 4, 2, new Color(241, 196, 15));
		terminal.write('#', 5, 2, new Color(241, 196, 15));
		terminal.write('#', 6, 2, new Color(241, 196, 15));
		terminal.write('#', 7, 2, new Color(241, 196, 15));
		terminal.write('#', 8, 2, new Color(241, 196, 15));
		terminal.write('#', 9, 2, new Color(241, 196, 15));
		terminal.write('#', 10, 2, new Color(241, 196, 15));

		terminal.write('#', 2, 3, new Color(241, 196, 15));
		terminal.write('#', 3, 3, new Color(241, 196, 15));
		terminal.write('#', 4, 3, new Color(241, 196, 15));
		terminal.write('#', 5, 3, new Color(241, 196, 15));
		terminal.write('#', 6, 3, new Color(241, 196, 15));
		terminal.write('#', 7, 3, new Color(61, 50, 5));
		terminal.write('#', 8, 3, new Color(61, 50, 5));
		terminal.write('#', 9, 3, new Color(61, 50, 5));

		terminal.write('#', 4, 4, new Color(61, 50, 5));
		terminal.write('#', 5, 4, new Color(241, 196, 15));
		terminal.write('#', 6, 4, new Color(61, 50, 5));

		terminal.write('#', 4, 5, new Color(61, 50, 5));
		terminal.write('#', 5, 5, new Color(241, 196, 15));
		terminal.write('#', 6, 5, new Color(61, 50, 5));

		terminal.write('#', 4, 6, new Color(61, 50, 5));
		terminal.write('#', 5, 6, new Color(241, 196, 15));

		terminal.write('#', 4, 7, new Color(61, 50, 5));
		terminal.write('#', 5, 7, new Color(241, 196, 15));

		terminal.write('#', 4, 8, new Color(61, 50, 5));
		terminal.write('#', 5, 8, new Color(241, 196, 15));

		terminal.write('#', 4, 9, new Color(61, 50, 5));
		terminal.write('#', 5, 9, new Color(241, 196, 15));

		terminal.write('#', 4, 10, new Color(61, 50, 5));
		terminal.write('#', 5, 10, new Color(241, 196, 15));

		terminal.write('#', 3, 11, new Color(61, 50, 5));
		terminal.write('#', 4, 11, new Color(61, 50, 5));
		terminal.write('#', 5, 11, new Color(241, 196, 15));
		terminal.write('#', 6, 11, new Color(241, 196, 15));
		terminal.write('#', 7, 11, new Color(241, 196, 15));
		terminal.write('#', 8, 11, new Color(241, 196, 15));
		terminal.write('#', 9, 11, new Color(61, 50, 5));

		terminal.write('#', 2, 12, new Color(61, 50, 5));
		terminal.write('#', 3, 12, new Color(241, 196, 15));
		terminal.write('#', 4, 12, new Color(241, 196, 15));
		terminal.write('#', 5, 12, new Color(241, 196, 15));
		terminal.write('#', 6, 12, new Color(241, 196, 15));
		terminal.write('#', 7, 12, new Color(61, 50, 5));
		terminal.write('#', 8, 12, new Color(61, 50, 5));
		terminal.write('#', 9, 12, new Color(61, 50, 5));

		terminal.write('#', 2, 13, new Color(61, 50, 5));
		terminal.write('#', 3, 13, new Color(61, 50, 5));
		terminal.write('#', 4, 13, new Color(61, 50, 5));

		//------------------------ N ------------------------
		terminal.write('#', 13, 2, new Color(61, 50, 5));
		terminal.write('#', 14, 2, new Color(61, 50, 5));

		terminal.write('#', 12, 3, new Color(61, 50, 5));
		terminal.write('#', 13, 3, new Color(241, 196, 15));
		terminal.write('#', 14, 3, new Color(241, 196, 15));
		terminal.write('#', 15, 3, new Color(241, 196, 15));

		terminal.write('#', 12, 4, new Color(61, 50, 5));
		terminal.write('#', 13, 4, new Color(241, 196, 15));
		terminal.write('#', 14, 4, new Color(241, 196, 15));
		terminal.write('#', 15, 4, new Color(241, 196, 15));

		terminal.write('#', 13, 5, new Color(241, 196, 15));
		terminal.write('#', 14, 5, new Color(241, 196, 15));
		terminal.write('#', 15, 5, new Color(241, 196, 15));
		terminal.write('#', 16, 5, new Color(61, 50, 5));

		terminal.write('#', 13, 6, new Color(241, 196, 15));
		terminal.write('#', 14, 6, new Color(241, 196, 15));
		terminal.write('#', 15, 6, new Color(241, 196, 15));
		terminal.write('#', 16, 6, new Color(241, 196, 15));
		terminal.write('#', 17, 6, new Color(61, 50, 5));

		terminal.write('#', 13, 7, new Color(241, 196, 15));
		terminal.write('#', 14, 7, new Color(61, 50, 5));
		terminal.write('#', 15, 7, new Color(61, 50, 5));
		terminal.write('#', 16, 7, new Color(241, 196, 15));
		terminal.write('#', 17, 7, new Color(241, 196, 15));
		terminal.write('#', 18, 7, new Color(61, 50, 5));

		terminal.write('#', 13, 8, new Color(241, 196, 15));
		terminal.write('#', 14, 8, new Color(61, 50, 5));
		terminal.write('#', 15, 8, new Color(61, 50, 5));
		terminal.write('#', 16, 8, new Color(61, 50, 5));
		terminal.write('#', 17, 8, new Color(241, 196, 15));
		terminal.write('#', 18, 8, new Color(241, 196, 15));
		terminal.write('#', 19, 8, new Color(241, 196, 15));

		terminal.write('#', 13, 9, new Color(241, 196, 15));
		terminal.write('#', 14, 9, new Color(61, 50, 5));
		terminal.write('#', 16, 9, new Color(61, 50, 5));
		terminal.write('#', 17, 9, new Color(241, 196, 15));
		terminal.write('#', 18, 9, new Color(241, 196, 15));
		terminal.write('#', 19, 9, new Color(241, 196, 15));

		terminal.write('#', 12, 10, new Color(61, 50, 5));
		terminal.write('#', 13, 10, new Color(241, 196, 15));
		terminal.write('#', 14, 10, new Color(61, 50, 5));
		terminal.write('#', 17, 10, new Color(61, 50, 5));
		terminal.write('#', 18, 10, new Color(61, 50, 5));
		terminal.write('#', 19, 10, new Color(241, 196, 15));
		terminal.write('#', 20, 10, new Color(241, 196, 15));
		terminal.write('#', 21, 10, new Color(241, 196, 15));

		terminal.write('#', 12, 11, new Color(61, 50, 5));
		terminal.write('#', 13, 11, new Color(241, 196, 15));
		terminal.write('#', 14, 11, new Color(61, 50, 5));
		terminal.write('#', 18, 11, new Color(61, 50, 5));
		terminal.write('#', 19, 11, new Color(241, 196, 15));
		terminal.write('#', 20, 11, new Color(241, 196, 15));
		terminal.write('#', 21, 11, new Color(241, 196, 15));

		terminal.write('#', 12, 12, new Color(61, 50, 5));
		terminal.write('#', 13, 12, new Color(241, 196, 15));
		terminal.write('#', 14, 12, new Color(61, 50, 5));
		terminal.write('#', 18, 12, new Color(61, 50, 5));
		terminal.write('#', 19, 12, new Color(241, 196, 15));
		terminal.write('#', 20, 12, new Color(241, 196, 15));
		terminal.write('#', 21, 12, new Color(241, 196, 15));

		terminal.write('#', 19, 13, new Color(61, 50, 5));
		terminal.write('#', 20, 13, new Color(61, 50, 5));

		terminal.write('#', 20, 12, new Color(241, 196, 15));
		terminal.write('#', 20, 11, new Color(241, 196, 15));
		terminal.write('#', 20, 10, new Color(241, 196, 15));
		terminal.write('#', 20, 9, new Color(241, 196, 15));
		terminal.write('#', 20, 8, new Color(241, 196, 15));
		terminal.write('#', 20, 7, new Color(241, 196, 15));
		terminal.write('#', 20, 6, new Color(241, 196, 15));
		terminal.write('#', 20, 5, new Color(241, 196, 15));
		terminal.write('#', 20, 4, new Color(241, 196, 15));
		terminal.write('#', 20, 3, new Color(241, 196, 15));
		terminal.write('#', 20, 2, new Color(241, 196, 15));
		terminal.write('#', 20, 1, new Color(61, 50, 5));

		terminal.write('#', 21, 12, new Color(61, 50, 5));
		terminal.write('#', 21, 11, new Color(61, 50, 5));
		terminal.write('#', 21, 10, new Color(61, 50, 5));
		terminal.write('#', 21, 9, new Color(61, 50, 5));
		terminal.write('#', 21, 8, new Color(61, 50, 5));
		terminal.write('#', 21, 7, new Color(61, 50, 5));
		terminal.write('#', 21, 6, new Color(61, 50, 5));
		terminal.write('#', 21, 5, new Color(61, 50, 5));
		terminal.write('#', 21, 4, new Color(61, 50, 5));
		terminal.write('#', 21, 3, new Color(61, 50, 5));
		terminal.write('#', 21, 2, new Color(61, 50, 5));
		terminal.write('#', 21, 1, new Color(61, 50, 5));

		terminal.write('#', 19, 4, new Color(61, 50, 5));
		terminal.write('#', 19, 3, new Color(61, 50, 5));
		terminal.write('#', 19, 2, new Color(61, 50, 5));
		terminal.write('#', 19, 1, new Color(61, 50, 5));

		//------------------------ F ------------------------
		terminal.write('#', 25, 1, new Color(61, 50, 5));
		terminal.write('#', 26, 1, new Color(61, 50, 5));
		terminal.write('#', 27, 1, new Color(61, 50, 5));
		terminal.write('#', 28, 1, new Color(61, 50, 5));
		terminal.write('#', 29, 1, new Color(61, 50, 5));

		terminal.write('#', 23, 2, new Color(61, 50, 5));
		terminal.write('#', 24, 2, new Color(241, 196, 15));
		terminal.write('#', 25, 2, new Color(241, 196, 15));
		terminal.write('#', 26, 2, new Color(241, 196, 15));
		terminal.write('#', 27, 2, new Color(241, 196, 15));
		terminal.write('#', 28, 2, new Color(241, 196, 15));
		terminal.write('#', 29, 2, new Color(61, 50, 5));

		terminal.write('#', 22, 3, new Color(61, 50, 5));
		terminal.write('#', 23, 3, new Color(241, 196, 15));
		terminal.write('#', 24, 3, new Color(241, 196, 15));
		terminal.write('#', 25, 3, new Color(61, 50, 5));
		terminal.write('#', 26, 3, new Color(61, 50, 5));
		terminal.write('#', 27, 3, new Color(61, 50, 5));

		terminal.write('#', 24, 4, new Color(61, 50, 5));
		terminal.write('#', 23, 4, new Color(241, 196, 15));

		terminal.write('#', 24, 5, new Color(61, 50, 5));
		terminal.write('#', 23, 5, new Color(241, 196, 15));

		terminal.write('#', 22, 7, new Color(61, 50, 5));
		terminal.write('#', 23, 7, new Color(241, 196, 15));

		terminal.write('#', 22, 8, new Color(61, 50, 5));
		terminal.write('#', 23, 8, new Color(241, 196, 15));

		terminal.write('#', 22, 9, new Color(61, 50, 5));
		terminal.write('#', 23, 9, new Color(241, 196, 15));
		terminal.write('#', 24, 9, new Color(61, 50, 5));

		terminal.write('#', 22, 10, new Color(61, 50, 5));
		terminal.write('#', 23, 10, new Color(241, 196, 15));
		terminal.write('#', 24, 10, new Color(61, 50, 5));

		terminal.write('#', 22, 11, new Color(61, 50, 5));
		terminal.write('#', 23, 11, new Color(241, 196, 15));
		terminal.write('#', 24, 11, new Color(61, 50, 5));

		terminal.write('#', 22, 12, new Color(61, 50, 5));
		terminal.write('#', 23, 12, new Color(241, 196, 15));
		terminal.write('#', 24, 12, new Color(61, 50, 5));

		terminal.write('#', 22, 13, new Color(61, 50, 5));
		terminal.write('#', 23, 13, new Color(241, 196, 15));
		terminal.write('#', 24, 13, new Color(61, 50, 5));

		terminal.write('#', 23, 7, new Color(241, 196, 15));
		terminal.write('#', 24, 7, new Color(241, 196, 15));
		terminal.write('#', 25, 7, new Color(241, 196, 15));
		terminal.write('#', 26, 7, new Color(241, 196, 15));
		terminal.write('#', 27, 7, new Color(241, 196, 15));
		terminal.write('#', 28, 7, new Color(61, 50, 5));

		terminal.write('#', 23, 6, new Color(241, 196, 15));
		terminal.write('#', 24, 6, new Color(61, 50, 5));
		terminal.write('#', 25, 6, new Color(61, 50, 5));
		terminal.write('#', 26, 6, new Color(61, 50, 5));
		terminal.write('#', 27, 6, new Color(241, 196, 15));
		terminal.write('#', 28, 6, new Color(241, 196, 15));
		terminal.write('#', 29, 6, new Color(241, 196, 15));
		terminal.write('#', 30, 6, new Color(61, 50, 5));

		terminal.write('#', 23, 8, new Color(241, 196, 15));
		terminal.write('#', 24, 8, new Color(241, 196, 15));
		terminal.write('#', 25, 8, new Color(61, 50, 5));
		terminal.write('#', 26, 8, new Color(61, 50, 5));

		terminal.write('#', 29, 5, new Color(61, 50, 5));
		terminal.write('#', 28, 5, new Color(61, 50, 5));

		//------------------------ I ------------------------

		terminal.write('#', 31, 1, new Color(61, 50, 5));
		terminal.write('#', 32, 1, new Color(61, 50, 5));
		terminal.write('#', 33, 1, new Color(61, 50, 5));

		terminal.write('#', 31, 2, new Color(61, 50, 5));
		terminal.write('#', 32, 2, new Color(241, 196, 15));
		terminal.write('#', 33, 2, new Color(61, 50, 5));

		terminal.write('#', 32, 3, new Color(241, 196, 15));
		terminal.write('#', 33, 3, new Color(61, 50, 5));

		terminal.write('#', 32, 4, new Color(241, 196, 15));
		terminal.write('#', 33, 4, new Color(61, 50, 5));

		terminal.write('#', 32, 5, new Color(241, 196, 15));
		terminal.write('#', 33, 5, new Color(61, 50, 5));

		terminal.write('#', 32, 6, new Color(241, 196, 15));
		terminal.write('#', 33, 6, new Color(61, 50, 5));

		terminal.write('#', 32, 7, new Color(241, 196, 15));
		terminal.write('#', 33, 7, new Color(61, 50, 5));

		terminal.write('#', 31, 8, new Color(61, 50, 5));
		terminal.write('#', 32, 8, new Color(241, 196, 15));
		terminal.write('#', 33, 8, new Color(61, 50, 5));

		terminal.write('#', 31, 9, new Color(61, 50, 5));
		terminal.write('#', 32, 9, new Color(241, 196, 15));
		terminal.write('#', 33, 9, new Color(61, 50, 5));

		terminal.write('#', 31, 10, new Color(61, 50, 5));
		terminal.write('#', 32, 10, new Color(241, 196, 15));
		terminal.write('#', 33, 10, new Color(61, 50, 5));

		terminal.write('#', 31, 11, new Color(61, 50, 5));
		terminal.write('#', 32, 11, new Color(241, 196, 15));
		terminal.write('#', 33, 11, new Color(61, 50, 5));

		terminal.write('#', 31, 12, new Color(61, 50, 5));
		terminal.write('#', 32, 12, new Color(241, 196, 15));
		terminal.write('#', 33, 12, new Color(61, 50, 5));

		terminal.write('#', 32, 13, new Color(61, 50, 5));

		//------------------------ N ------------------------
		terminal.write('#', 36, 2, new Color(61, 50, 5));
		terminal.write('#', 37, 2, new Color(61, 50, 5));

		terminal.write('#', 35, 3, new Color(61, 50, 5));
		terminal.write('#', 36, 3, new Color(241, 196, 15));
		terminal.write('#', 37, 3, new Color(241, 196, 15));
		terminal.write('#', 38, 3, new Color(241, 196, 15));

		terminal.write('#', 35, 4, new Color(61, 50, 5));
		terminal.write('#', 36, 4, new Color(241, 196, 15));
		terminal.write('#', 37, 4, new Color(241, 196, 15));
		terminal.write('#', 38, 4, new Color(241, 196, 15));

		terminal.write('#', 36, 5, new Color(241, 196, 15));
		terminal.write('#', 37, 5, new Color(241, 196, 15));
		terminal.write('#', 38, 5, new Color(241, 196, 15));
		terminal.write('#', 39, 5, new Color(61, 50, 5));

		terminal.write('#', 36, 6, new Color(241, 196, 15));
		terminal.write('#', 37, 6, new Color(241, 196, 15));
		terminal.write('#', 38, 6, new Color(241, 196, 15));
		terminal.write('#', 39, 6, new Color(241, 196, 15));
		terminal.write('#', 40, 6, new Color(61, 50, 5));

		terminal.write('#', 36, 7, new Color(241, 196, 15));
		terminal.write('#', 37, 7, new Color(61, 50, 5));
		terminal.write('#', 38, 7, new Color(61, 50, 5));
		terminal.write('#', 39, 7, new Color(241, 196, 15));
		terminal.write('#', 40, 7, new Color(241, 196, 15));
		terminal.write('#', 41, 7, new Color(61, 50, 5));

		terminal.write('#', 36, 8, new Color(241, 196, 15));
		terminal.write('#', 37, 8, new Color(61, 50, 5));
		terminal.write('#', 38, 8, new Color(61, 50, 5));
		terminal.write('#', 39, 8, new Color(61, 50, 5));
		terminal.write('#', 40, 8, new Color(241, 196, 15));
		terminal.write('#', 41, 8, new Color(241, 196, 15));
		terminal.write('#', 42, 8, new Color(241, 196, 15));

		terminal.write('#', 36, 9, new Color(241, 196, 15));
		terminal.write('#', 37, 9, new Color(61, 50, 5));
		terminal.write('#', 39, 9, new Color(61, 50, 5));
		terminal.write('#', 40, 9, new Color(241, 196, 15));
		terminal.write('#', 41, 9, new Color(241, 196, 15));
		terminal.write('#', 42, 9, new Color(241, 196, 15));

		terminal.write('#', 35, 10, new Color(61, 50, 5));
		terminal.write('#', 36, 10, new Color(241, 196, 15));
		terminal.write('#', 37, 10, new Color(61, 50, 5));
		terminal.write('#', 40, 10, new Color(61, 50, 5));
		terminal.write('#', 41, 10, new Color(61, 50, 5));
		terminal.write('#', 42, 10, new Color(241, 196, 15));
		terminal.write('#', 43, 10, new Color(241, 196, 15));
		terminal.write('#', 44, 10, new Color(241, 196, 15));

		terminal.write('#', 35, 11, new Color(61, 50, 5));
		terminal.write('#', 36, 11, new Color(241, 196, 15));
		terminal.write('#', 37, 11, new Color(61, 50, 5));
		terminal.write('#', 41, 11, new Color(61, 50, 5));
		terminal.write('#', 42, 11, new Color(241, 196, 15));
		terminal.write('#', 43, 11, new Color(241, 196, 15));
		terminal.write('#', 44, 11, new Color(241, 196, 15));

		terminal.write('#', 35, 12, new Color(61, 50, 5));
		terminal.write('#', 36, 12, new Color(241, 196, 15));
		terminal.write('#', 37, 12, new Color(61, 50, 5));
		terminal.write('#', 41, 12, new Color(61, 50, 5));
		terminal.write('#', 42, 12, new Color(241, 196, 15));
		terminal.write('#', 43, 12, new Color(241, 196, 15));
		terminal.write('#', 44, 12, new Color(241, 196, 15));

		terminal.write('#', 42, 13, new Color(61, 50, 5));
		terminal.write('#', 43, 13, new Color(61, 50, 5));

		terminal.write('#', 43, 12, new Color(241, 196, 15));
		terminal.write('#', 43, 11, new Color(241, 196, 15));
		terminal.write('#', 43, 10, new Color(241, 196, 15));
		terminal.write('#', 43, 9, new Color(241, 196, 15));
		terminal.write('#', 43, 8, new Color(241, 196, 15));
		terminal.write('#', 43, 7, new Color(241, 196, 15));
		terminal.write('#', 43, 6, new Color(241, 196, 15));
		terminal.write('#', 43, 5, new Color(241, 196, 15));
		terminal.write('#', 43, 4, new Color(241, 196, 15));
		terminal.write('#', 43, 3, new Color(241, 196, 15));
		terminal.write('#', 43, 2, new Color(241, 196, 15));
		terminal.write('#', 43, 1, new Color(61, 50, 5));

		terminal.write('#', 44, 12, new Color(61, 50, 5));
		terminal.write('#', 44, 11, new Color(61, 50, 5));
		terminal.write('#', 44, 10, new Color(61, 50, 5));
		terminal.write('#', 44, 9, new Color(61, 50, 5));
		terminal.write('#', 44, 8, new Color(61, 50, 5));
		terminal.write('#', 44, 7, new Color(61, 50, 5));
		terminal.write('#', 44, 6, new Color(61, 50, 5));
		terminal.write('#', 44, 5, new Color(61, 50, 5));
		terminal.write('#', 44, 4, new Color(61, 50, 5));
		terminal.write('#', 44, 3, new Color(61, 50, 5));
		terminal.write('#', 44, 2, new Color(61, 50, 5));
		terminal.write('#', 44, 1, new Color(61, 50, 5));

		terminal.write('#', 42, 4, new Color(61, 50, 5));
		terminal.write('#', 42, 3, new Color(61, 50, 5));
		terminal.write('#', 42, 2, new Color(61, 50, 5));
		terminal.write('#', 42, 1, new Color(61, 50, 5));

		//------------------------ I ------------------------
		terminal.write('#', 46, 1, new Color(61, 50, 5));
		terminal.write('#', 47, 1, new Color(61, 50, 5));
		terminal.write('#', 48, 1, new Color(61, 50, 5));

		terminal.write('#', 46, 2, new Color(61, 50, 5));
		terminal.write('#', 47, 2, new Color(241, 196, 15));
		terminal.write('#', 48, 2, new Color(61, 50, 5));

		terminal.write('#', 47, 3, new Color(241, 196, 15));
		terminal.write('#', 48, 3, new Color(61, 50, 5));

		terminal.write('#', 47, 4, new Color(241, 196, 15));
		terminal.write('#', 48, 4, new Color(61, 50, 5));

		terminal.write('#', 47, 5, new Color(241, 196, 15));
		terminal.write('#', 48, 5, new Color(61, 50, 5));

		terminal.write('#', 47, 6, new Color(241, 196, 15));
		terminal.write('#', 48, 6, new Color(61, 50, 5));

		terminal.write('#', 47, 7, new Color(241, 196, 15));
		terminal.write('#', 48, 7, new Color(61, 50, 5));

		terminal.write('#', 46, 8, new Color(61, 50, 5));
		terminal.write('#', 47, 8, new Color(241, 196, 15));
		terminal.write('#', 48, 8, new Color(61, 50, 5));

		terminal.write('#', 46, 9, new Color(61, 50, 5));
		terminal.write('#', 47, 9, new Color(241, 196, 15));
		terminal.write('#', 48, 9, new Color(61, 50, 5));

		terminal.write('#', 46, 10, new Color(61, 50, 5));
		terminal.write('#', 47, 10, new Color(241, 196, 15));
		terminal.write('#', 48, 10, new Color(61, 50, 5));

		terminal.write('#', 46, 11, new Color(61, 50, 5));
		terminal.write('#', 47, 11, new Color(241, 196, 15));
		terminal.write('#', 48, 11, new Color(61, 50, 5));

		terminal.write('#', 46, 12, new Color(61, 50, 5));
		terminal.write('#', 47, 12, new Color(241, 196, 15));
		terminal.write('#', 48, 12, new Color(61, 50, 5));

		terminal.write('#', 47, 13, new Color(61, 50, 5));

		//------------------------ T ------------------------
		terminal.write('#', 55, 1, new Color(61, 50, 5));
		terminal.write('#', 56, 1, new Color(61, 50, 5));
		terminal.write('#', 57, 1, new Color(61, 50, 5));
		terminal.write('#', 58, 1, new Color(61, 50, 5));
		terminal.write('#', 59, 1, new Color(61, 50, 5));
		terminal.write('#', 60, 1, new Color(61, 50, 5));

		terminal.write('#', 51, 2, new Color(61, 50, 5));
		terminal.write('#', 52, 2, new Color(61, 50, 5));
		terminal.write('#', 53, 2, new Color(241, 196, 15));
		terminal.write('#', 54, 2, new Color(241, 196, 15));
		terminal.write('#', 55, 2, new Color(241, 196, 15));
		terminal.write('#', 56, 2, new Color(241, 196, 15));
		terminal.write('#', 57, 2, new Color(241, 196, 15));
		terminal.write('#', 58, 2, new Color(241, 196, 15));
		terminal.write('#', 59, 2, new Color(241, 196, 15));
		terminal.write('#', 60, 2, new Color(61, 50, 5));

		terminal.write('#', 50, 3, new Color(61, 50, 5));
		terminal.write('#', 51, 3, new Color(241, 196, 15));
		terminal.write('#', 52, 3, new Color(241, 196, 15));
		terminal.write('#', 53, 3, new Color(241, 196, 15));
		terminal.write('#', 54, 3, new Color(241, 196, 15));
		terminal.write('#', 55, 3, new Color(241, 196, 15));
		terminal.write('#', 56, 3, new Color(241, 196, 15));
		terminal.write('#', 57, 3, new Color(241, 196, 15));

		terminal.write('#', 51, 4, new Color(61, 50, 5));
		terminal.write('#', 52, 4, new Color(61, 50, 5));
		terminal.write('#', 54, 4, new Color(61, 50, 5));
		terminal.write('#', 55, 4, new Color(241, 196, 15));
		terminal.write('#', 56, 4, new Color(61, 50, 5));

		terminal.write('#', 54, 5, new Color(61, 50, 5));
		terminal.write('#', 55, 5, new Color(241, 196, 15));
		terminal.write('#', 56, 5, new Color(61, 50, 5));

		terminal.write('#', 54, 6, new Color(61, 50, 5));
		terminal.write('#', 55, 6, new Color(241, 196, 15));

		terminal.write('#', 54, 7, new Color(61, 50, 5));
		terminal.write('#', 55, 7, new Color(241, 196, 15));

		terminal.write('#', 54, 8, new Color(61, 50, 5));
		terminal.write('#', 55, 8, new Color(241, 196, 15));

		terminal.write('#', 54, 9, new Color(61, 50, 5));
		terminal.write('#', 55, 9, new Color(241, 196, 15));

		terminal.write('#', 54, 10, new Color(61, 50, 5));
		terminal.write('#', 55, 10, new Color(241, 196, 15));

		terminal.write('#', 54, 11, new Color(61, 50, 5));
		terminal.write('#', 55, 11, new Color(241, 196, 15));

		terminal.write('#', 54, 12, new Color(61, 50, 5));
		terminal.write('#', 55, 12, new Color(241, 196, 15));

		terminal.write('#', 54, 13, new Color(61, 50, 5));
		terminal.write('#', 55, 13, new Color(61, 50, 5));

		//------------------------ Y ------------------------
		terminal.write('#', 68, 1, new Color(61, 50, 5));

		terminal.write('#', 61, 2, new Color(61, 50, 5));
		terminal.write('#', 67, 2, new Color(61, 50, 5));
		terminal.write('#', 68, 2, new Color(241, 196, 15));
		terminal.write('#', 69, 2, new Color(61, 50, 5));

		terminal.write('#', 59, 3, new Color(61, 50, 5));
		terminal.write('#', 60, 3, new Color(61, 50, 5));
		terminal.write('#', 61, 3, new Color(241, 196, 15));
		terminal.write('#', 62, 3, new Color(61, 50, 5));
		terminal.write('#', 66, 3, new Color(61, 50, 5));
		terminal.write('#', 67, 3, new Color(241, 196, 15));
		terminal.write('#', 68, 3, new Color(61, 50, 5));

		terminal.write('#', 60, 4, new Color(61, 50, 5));
		terminal.write('#', 61, 4, new Color(241, 196, 15));
		terminal.write('#', 62, 4, new Color(241, 196, 15));
		terminal.write('#', 65, 4, new Color(61, 50, 5));
		terminal.write('#', 66, 4, new Color(241, 196, 15));
		terminal.write('#', 67, 4, new Color(241, 196, 15));
		terminal.write('#', 68, 4, new Color(61, 50, 5));

		terminal.write('#', 61, 5, new Color(61, 50, 5));
		terminal.write('#', 62, 5, new Color(241, 196, 15));
		terminal.write('#', 63, 5, new Color(61, 50, 5));
		terminal.write('#', 65, 5, new Color(61, 50, 5));
		terminal.write('#', 66, 5, new Color(241, 196, 15));
		terminal.write('#', 67, 5, new Color(61, 50, 5));

		terminal.write('#', 62, 6, new Color(61, 50, 5));
		terminal.write('#', 63, 6, new Color(241, 196, 15));
		terminal.write('#', 64, 6, new Color(61, 50, 5));
		terminal.write('#', 65, 6, new Color(241, 196, 15));
		terminal.write('#', 66, 6, new Color(61, 50, 5));

		terminal.write('#', 63, 7, new Color(241, 196, 15));
		terminal.write('#', 64, 7, new Color(241, 196, 15));
		terminal.write('#', 65, 7, new Color(241, 196, 15));
		terminal.write('#', 66, 7, new Color(61, 50, 5));

		terminal.write('#', 63, 8, new Color(61, 50, 5));
		terminal.write('#', 64, 8, new Color(241, 196, 15));
		terminal.write('#', 65, 8, new Color(61, 50, 5));

		terminal.write('#', 63, 9, new Color(61, 50, 5));
		terminal.write('#', 64, 9, new Color(241, 196, 15));
		terminal.write('#', 65, 9, new Color(61, 50, 5));

		terminal.write('#', 62, 10, new Color(61, 50, 5));
		terminal.write('#', 63, 10, new Color(241, 196, 15));
		terminal.write('#', 64, 10, new Color(61, 50, 5));

		terminal.write('#', 62, 11, new Color(61, 50, 5));
		terminal.write('#', 63, 11, new Color(241, 196, 15));
		terminal.write('#', 64, 11, new Color(61, 50, 5));

		terminal.write('#', 62, 12, new Color(61, 50, 5));
		terminal.write('#', 63, 12, new Color(241, 196, 15));
		terminal.write('#', 64, 12, new Color(61, 50, 5));

		terminal.write('#', 63, 13, new Color(61, 50, 5));

		//------------------------ R ------------------------
		terminal.write('#', 35, 15, new Color(61, 50, 5));
		terminal.write('#', 36, 15, new Color(61, 50, 5));
		terminal.write('#', 37, 15, new Color(61, 50, 5));
		terminal.write('#', 38, 15, new Color(61, 50, 5));
		terminal.write('#', 39, 15, new Color(61, 50, 5));
		terminal.write('#', 40, 15, new Color(61, 50, 5));
		terminal.write('#', 41, 15, new Color(61, 50, 5));
		terminal.write('#', 42, 15, new Color(61, 50, 5));

		terminal.write('#', 34, 16, new Color(61, 50, 5));
		terminal.write('#', 35, 16, new Color(241, 196, 15));
		terminal.write('#', 36, 16, new Color(241, 196, 15));
		terminal.write('#', 37, 16, new Color(241, 196, 15));
		terminal.write('#', 38, 16, new Color(241, 196, 15));
		terminal.write('#', 39, 16, new Color(241, 196, 15));
		terminal.write('#', 40, 16, new Color(241, 196, 15));
		terminal.write('#', 41, 16, new Color(241, 196, 15));
		terminal.write('#', 42, 16, new Color(241, 196, 15));
		terminal.write('#', 43, 16, new Color(61, 50, 5));

		terminal.write('#', 34, 17, new Color(61, 50, 5));
		terminal.write('#', 35, 17, new Color(241, 196, 15));
		terminal.write('#', 36, 17, new Color(61, 50, 5));
		terminal.write('#', 37, 17, new Color(61, 50, 5));
		terminal.write('#', 41, 17, new Color(61, 50, 5));
		terminal.write('#', 42, 17, new Color(61, 50, 5));
		terminal.write('#', 43, 17, new Color(241, 196, 15));

		terminal.write('#', 35, 18, new Color(241, 196, 15));
		terminal.write('#', 36, 18, new Color(61, 50, 5));
		terminal.write('#', 42, 18, new Color(61, 50, 5));
		terminal.write('#', 43, 18, new Color(241, 196, 15));

		terminal.write('#', 35, 19, new Color(241, 196, 15));
		terminal.write('#', 36, 19, new Color(61, 50, 5));
		terminal.write('#', 41, 19, new Color(61, 50, 5));
		terminal.write('#', 42, 19, new Color(241, 196, 15));
		terminal.write('#', 43, 19, new Color(61, 50, 5));

		terminal.write('#', 35, 20, new Color(241, 196, 15));
		terminal.write('#', 36, 20, new Color(61, 50, 5));
		terminal.write('#', 40, 20, new Color(61, 50, 5));
		terminal.write('#', 41, 20, new Color(241, 196, 15));
		terminal.write('#', 42, 20, new Color(241, 196, 15));
		terminal.write('#', 43, 20, new Color(61, 50, 5));

		terminal.write('#', 35, 21, new Color(241, 196, 15));
		terminal.write('#', 36, 21, new Color(61, 50, 5));
		terminal.write('#', 38, 21, new Color(61, 50, 5));
		terminal.write('#', 39, 21, new Color(241, 196, 15));
		terminal.write('#', 40, 21, new Color(241, 196, 15));
		terminal.write('#', 41, 21, new Color(241, 196, 15));
		terminal.write('#', 42, 21, new Color(61, 50, 5));

		terminal.write('#', 35, 22, new Color(241, 196, 15));
		terminal.write('#', 36, 22, new Color(241, 196, 15));
		terminal.write('#', 37, 22, new Color(241, 196, 15));
		terminal.write('#', 38, 22, new Color(241, 196, 15));
		terminal.write('#', 39, 22, new Color(241, 196, 15));
		terminal.write('#', 40, 22, new Color(61, 50, 5));

		terminal.write('#', 35, 23, new Color(241, 196, 15));
		terminal.write('#', 36, 23, new Color(241, 196, 15));
		terminal.write('#', 37, 23, new Color(241, 196, 15));
		terminal.write('#', 38, 23, new Color(241, 196, 15));
		terminal.write('#', 39, 23, new Color(241, 196, 15));
		terminal.write('#', 40, 23, new Color(241, 196, 15));
		terminal.write('#', 41, 23, new Color(61, 50, 5));

		terminal.write('#', 34, 24, new Color(61, 50, 5));
		terminal.write('#', 35, 24, new Color(241, 196, 15));
		terminal.write('#', 36, 24, new Color(61, 50, 5));
		terminal.write('#', 37, 24, new Color(61, 50, 5));
		terminal.write('#', 38, 24, new Color(61, 50, 5));
		terminal.write('#', 39, 24, new Color(61, 50, 5));
		terminal.write('#', 40, 24, new Color(241, 196, 15));
		terminal.write('#', 41, 24, new Color(241, 196, 15));
		terminal.write('#', 42, 24, new Color(61, 50, 5));

		terminal.write('#', 34, 25, new Color(61, 50, 5));
		terminal.write('#', 35, 25, new Color(241, 196, 15));
		terminal.write('#', 36, 25, new Color(61, 50, 5));
		terminal.write('#', 41, 25, new Color(61, 50, 5));
		terminal.write('#', 42, 25, new Color(241, 196, 15));
		terminal.write('#', 43, 25, new Color(61, 50, 5));

		terminal.write('#', 34, 26, new Color(61, 50, 5));
		terminal.write('#', 35, 26, new Color(241, 196, 15));
		terminal.write('#', 36, 26, new Color(61, 50, 5));
		terminal.write('#', 42, 26, new Color(61, 50, 5));
		terminal.write('#', 43, 26, new Color(61, 50, 5));

		terminal.write('#', 35, 27, new Color(61, 50, 5));

		//------------------------ O ------------------------
		terminal.write('#', 49, 15, new Color(61, 50, 5));
		terminal.write('#', 50, 15, new Color(61, 50, 5));
		terminal.write('#', 51, 15, new Color(61, 50, 5));
		terminal.write('#', 52, 15, new Color(61, 50, 5));
		terminal.write('#', 53, 15, new Color(61, 50, 5));

		terminal.write('#', 48, 16, new Color(61, 50, 5));
		terminal.write('#', 49, 16, new Color(241, 196, 15));
		terminal.write('#', 50, 16, new Color(241, 196, 15));
		terminal.write('#', 51, 16, new Color(241, 196, 15));
		terminal.write('#', 52, 16, new Color(241, 196, 15));
		terminal.write('#', 53, 16, new Color(241, 196, 15));
		terminal.write('#', 54, 16, new Color(61, 50, 5));

		terminal.write('#', 47, 17, new Color(241, 196, 15));
		terminal.write('#', 48, 17, new Color(241, 196, 15));
		terminal.write('#', 49, 17, new Color(61, 50, 5));
		terminal.write('#', 50, 17, new Color(61, 50, 5));
		terminal.write('#', 51, 17, new Color(61, 50, 5));
		terminal.write('#', 52, 17, new Color(61, 50, 5));
		terminal.write('#', 53, 17, new Color(241, 196, 15));
		terminal.write('#', 54, 17, new Color(61, 50, 5));

		terminal.write('#', 46, 18, new Color(241, 196, 15));
		terminal.write('#', 47, 18, new Color(241, 196, 15));
		terminal.write('#', 48, 18, new Color(61, 50, 5));
		terminal.write('#', 54, 18, new Color(241, 196, 15));
		terminal.write('#', 53, 18, new Color(61, 50, 5));

		terminal.write('#', 45, 19, new Color(61, 50, 5));
		terminal.write('#', 46, 19, new Color(241, 196, 15));
		terminal.write('#', 47, 19, new Color(61, 50, 5));
		terminal.write('#', 53, 19, new Color(61, 50, 5));
		terminal.write('#', 54, 19, new Color(241, 196, 15));
		terminal.write('#', 55, 19, new Color(61, 50, 5));

		terminal.write('#', 45, 20, new Color(241, 196, 15));
		terminal.write('#', 46, 20, new Color(61, 50, 5));
		terminal.write('#', 53, 20, new Color(61, 50, 5));
		terminal.write('#', 54, 20, new Color(241, 196, 15));
		terminal.write('#', 55, 20, new Color(61, 50, 5));

		terminal.write('#', 44, 21, new Color(61, 50, 5));
		terminal.write('#', 45, 21, new Color(241, 196, 15));
		terminal.write('#', 46, 21, new Color(61, 50, 5));
		terminal.write('#', 53, 21, new Color(241, 196, 15));
		terminal.write('#', 54, 21, new Color(241, 196, 15));

		terminal.write('#', 44, 22, new Color(61, 50, 5));
		terminal.write('#', 45, 22, new Color(241, 196, 15));
		terminal.write('#', 52, 22, new Color(61, 50, 5));
		terminal.write('#', 53, 22, new Color(241, 196, 15));
		terminal.write('#', 54, 22, new Color(61, 50, 5));

		terminal.write('#', 44, 23, new Color(61, 50, 5));
		terminal.write('#', 45, 23, new Color(241, 196, 15));
		terminal.write('#', 46, 23, new Color(61, 50, 5));
		terminal.write('#', 51, 23, new Color(61, 50, 5));
		terminal.write('#', 52, 23, new Color(241, 196, 15));
		terminal.write('#', 53, 23, new Color(241, 196, 15));
		terminal.write('#', 54, 23, new Color(61, 50, 5));

		terminal.write('#', 44, 24, new Color(61, 50, 5));
		terminal.write('#', 45, 24, new Color(241, 196, 15));
		terminal.write('#', 46, 24, new Color(61, 50, 5));
		terminal.write('#', 50, 24, new Color(61, 50, 5));
		terminal.write('#', 51, 24, new Color(241, 196, 15));
		terminal.write('#', 52, 24, new Color(241, 196, 15));
		terminal.write('#', 53, 24, new Color(61, 50, 5));

		terminal.write('#', 45, 25, new Color(241, 196, 15));
		terminal.write('#', 46, 25, new Color(241, 196, 15));
		terminal.write('#', 47, 25, new Color(61, 50, 5));
		terminal.write('#', 48, 25, new Color(61, 50, 5));
		terminal.write('#', 49, 25, new Color(61, 50, 5));
		terminal.write('#', 50, 25, new Color(241, 196, 15));
		terminal.write('#', 51, 25, new Color(241, 196, 15));
		terminal.write('#', 52, 25, new Color(61, 50, 5));

		terminal.write('#', 46, 26, new Color(241, 196, 15));
		terminal.write('#', 47, 26, new Color(241, 196, 15));
		terminal.write('#', 48, 26, new Color(241, 196, 15));
		terminal.write('#', 49, 26, new Color(241, 196, 15));
		terminal.write('#', 50, 26, new Color(61, 50, 5));
		terminal.write('#', 51, 26, new Color(61, 50, 5));

		terminal.write('#', 47, 27, new Color(61, 50, 5));
		terminal.write('#', 48, 27, new Color(61, 50, 5));

		//------------------------ G ------------------------
		terminal.write('#', 63, 15, new Color(61, 50, 5));
		terminal.write('#', 64, 15, new Color(61, 50, 5));
		terminal.write('#', 65, 15, new Color(61, 50, 5));
		terminal.write('#', 66, 15, new Color(61, 50, 5));

		terminal.write('#', 61, 16, new Color(61, 50, 5));
		terminal.write('#', 62, 16, new Color(241, 196, 15));
		terminal.write('#', 63, 16, new Color(241, 196, 15));
		terminal.write('#', 64, 16, new Color(241, 196, 15));
		terminal.write('#', 65, 16, new Color(241, 196, 15));
		terminal.write('#', 66, 16, new Color(61, 50, 5));

		terminal.write('#', 60, 17, new Color(61, 50, 5));
		terminal.write('#', 61, 17, new Color(241, 196, 15));
		terminal.write('#', 62, 17, new Color(241, 196, 15));
		terminal.write('#', 63, 17, new Color(61, 50, 5));
		terminal.write('#', 65, 17, new Color(61, 50, 5));
		terminal.write('#', 66, 17, new Color(61, 50, 5));

		terminal.write('#', 59, 18, new Color(61, 50, 5));
		terminal.write('#', 60, 18, new Color(241, 196, 15));
		terminal.write('#', 61, 18, new Color(241, 196, 15));
		terminal.write('#', 62, 18, new Color(61, 50, 5));

		terminal.write('#', 59, 19, new Color(241, 196, 15));
		terminal.write('#', 60, 19, new Color(241, 196, 15));
		terminal.write('#', 61, 19, new Color(61, 50, 5));

		terminal.write('#', 58, 20, new Color(61, 50, 5));
		terminal.write('#', 59, 20, new Color(241, 196, 15));
		terminal.write('#', 60, 20, new Color(61, 50, 5));
		terminal.write('#', 65, 20, new Color(61, 50, 5));
		terminal.write('#', 66, 20, new Color(61, 50, 5));
		terminal.write('#', 67, 20, new Color(61, 50, 5));
		terminal.write('#', 68, 20, new Color(61, 50, 5));

		terminal.write('#', 58, 21, new Color(241, 196, 15));
		terminal.write('#', 59, 21, new Color(241, 196, 15));
		terminal.write('#', 62, 21, new Color(61, 50, 5));
		terminal.write('#', 63, 21, new Color(241, 196, 15));
		terminal.write('#', 64, 21, new Color(241, 196, 15));
		terminal.write('#', 65, 21, new Color(241, 196, 15));
		terminal.write('#', 66, 21, new Color(241, 196, 15));
		terminal.write('#', 67, 21, new Color(241, 196, 15));
		terminal.write('#', 68, 21, new Color(61, 50, 5));

		terminal.write('#', 57, 22, new Color(61, 50, 5));
		terminal.write('#', 58, 22, new Color(241, 196, 15));
		terminal.write('#', 59, 22, new Color(61, 50, 5));
		terminal.write('#', 62, 22, new Color(61, 50, 5));
		terminal.write('#', 63, 22, new Color(241, 196, 15));
		terminal.write('#', 64, 22, new Color(241, 196, 15));
		terminal.write('#', 65, 22, new Color(241, 196, 15));
		terminal.write('#', 66, 22, new Color(241, 196, 15));
		terminal.write('#', 67, 22, new Color(61, 50, 5));

		terminal.write('#', 57, 23, new Color(61, 50, 5));
		terminal.write('#', 58, 23, new Color(241, 196, 15));
		terminal.write('#', 59, 23, new Color(61, 50, 5));
		terminal.write('#', 65, 23, new Color(61, 50, 5));
		terminal.write('#', 66, 23, new Color(241, 196, 15));
		terminal.write('#', 67, 23, new Color(61, 50, 5));

		terminal.write('#', 57, 24, new Color(61, 50, 5));
		terminal.write('#', 58, 24, new Color(241, 196, 15));
		terminal.write('#', 59, 24, new Color(61, 50, 5));
		terminal.write('#', 64, 24, new Color(61, 50, 5));
		terminal.write('#', 65, 24, new Color(241, 196, 15));
		terminal.write('#', 66, 24, new Color(61, 50, 5));

		terminal.write('#', 57, 25, new Color(61, 50, 5));
		terminal.write('#', 58, 25, new Color(241, 196, 15));
		terminal.write('#', 59, 25, new Color(241, 196, 15));
		terminal.write('#', 60, 25, new Color(241, 196, 15));
		terminal.write('#', 61, 25, new Color(241, 196, 15));
		terminal.write('#', 62, 25, new Color(241, 196, 15));
		terminal.write('#', 63, 25, new Color(241, 196, 15));
		terminal.write('#', 64, 25, new Color(241, 196, 15));
		terminal.write('#', 65, 25, new Color(61, 50, 5));

		terminal.write('#', 58, 26, new Color(61, 50, 5));
		terminal.write('#', 59, 26, new Color(241, 196, 15));
		terminal.write('#', 60, 26, new Color(241, 196, 15));
		terminal.write('#', 61, 26, new Color(241, 196, 15));
		terminal.write('#', 62, 26, new Color(241, 196, 15));
		terminal.write('#', 63, 26, new Color(241, 196, 15));
		terminal.write('#', 64, 26, new Color(61, 50, 5));

		terminal.write('#', 59, 27, new Color(61, 50, 5));
		terminal.write('#', 60, 27, new Color(61, 50, 5));
		terminal.write('#', 61, 27, new Color(61, 50, 5));
		terminal.write('#', 62, 27, new Color(61, 50, 5));
		terminal.write('#', 63, 27, new Color(61, 50, 5));

		//------------------------ U ------------------------
		terminal.write('#', 70, 15,  new Color(61, 50, 5));
		terminal.write('#', 70, 16, new Color(241, 196, 15));
		terminal.write('#', 70, 17, new Color(241, 196, 15));
		terminal.write('#', 70, 18, new Color(241, 196, 15));
		terminal.write('#', 70, 19, new Color(241, 196, 15));
		terminal.write('#', 70, 20, new Color(241, 196, 15));
		terminal.write('#', 70, 21, new Color(241, 196, 15));
		terminal.write('#', 70, 22, new Color(241, 196, 15));
		terminal.write('#', 70, 23, new Color(241, 196, 15));
		terminal.write('#', 70, 24, new Color(241, 196, 15));
		terminal.write('#', 70, 25, new Color(241, 196, 15));
		terminal.write('#', 70, 26, new Color(241, 196, 15));
		terminal.write('#', 70, 27, new Color(61, 50, 5));

		terminal.write('#', 69, 19, new Color(61, 50, 5));
		terminal.write('#', 69, 20, new Color(61, 50, 5));
		terminal.write('#', 69, 21, new Color(61, 50, 5));
		terminal.write('#', 69, 22, new Color(61, 50, 5));
		terminal.write('#', 69, 23, new Color(61, 50, 5));
		terminal.write('#', 69, 24, new Color(61, 50, 5));
		terminal.write('#', 69, 25, new Color(61, 50, 5));
		terminal.write('#', 69, 26, new Color(61, 50, 5));

		terminal.write('#', 71, 15,  new Color(61, 50, 5));
		terminal.write('#', 71, 16, new Color(61, 50, 5));
		terminal.write('#', 71, 17, new Color(61, 50, 5));
		terminal.write('#', 71, 18, new Color(61, 50, 5));
		terminal.write('#', 71, 19, new Color(61, 50, 5));
		terminal.write('#', 71, 24, new  Color(61, 50, 5));
		terminal.write('#', 71, 25, new Color(241, 196, 15));
		terminal.write('#', 71, 26, new Color(241, 196, 15));
		terminal.write('#', 71, 27, new Color(61, 50, 5));

		terminal.write('#', 72, 24, new Color(61, 50, 5));
		terminal.write('#', 72, 25, new  Color(241, 196, 15));
		terminal.write('#', 72, 26, new Color(61, 50, 5));

		terminal.write('#', 73, 24, new Color(61, 50, 5));
		terminal.write('#', 73, 25, new  Color(241, 196, 15));
		terminal.write('#', 73, 26, new Color(61, 50, 5));

		terminal.write('#', 74, 23, new Color(61, 50, 5));
		terminal.write('#', 74, 24, new  Color(241, 196, 15));
		terminal.write('#', 74, 25, new Color(61, 50, 5));

		terminal.write('#', 75, 23, new Color(61, 50, 5));
		terminal.write('#', 75, 24, new  Color(241, 196, 15));
		terminal.write('#', 75, 25, new Color(61, 50, 5));


		terminal.write('#', 76, 15,  new Color(61, 50, 5));
		terminal.write('#', 76, 16, new Color(61, 50, 5));
		terminal.write('#', 76, 17, new Color(61, 50, 5));
		terminal.write('#', 76, 18, new Color(61, 50, 5));
		terminal.write('#', 76, 19, new Color(61, 50, 5));
		terminal.write('#', 76, 20, new Color(61, 50, 5));
		terminal.write('#', 76, 21, new Color(61, 50, 5));
		terminal.write('#', 76, 22, new Color(61, 50, 5));
		terminal.write('#', 76, 23, new Color(61, 50, 5));
		terminal.write('#', 76, 24, new Color(241, 196, 15));
		terminal.write('#', 76, 25, new Color(61, 50, 5));

		terminal.write('#', 77, 15,  new Color(61, 50, 5));
		terminal.write('#', 77, 16, new Color(241, 196, 15));
		terminal.write('#', 77, 17, new Color(241, 196, 15));
		terminal.write('#', 77, 18, new Color(241, 196, 15));
		terminal.write('#', 77, 19, new Color(241, 196, 15));
		terminal.write('#', 77, 20, new Color(241, 196, 15));
		terminal.write('#', 77, 21, new Color(241, 196, 15));
		terminal.write('#', 77, 22, new Color(241, 196, 15));
		terminal.write('#', 77, 23, new Color(241, 196, 15));
		terminal.write('#', 77, 24, new Color(241, 196, 15));
		terminal.write('#', 77, 25, new Color(61, 50, 5));

		//------------------------ U ------------------------
		terminal.write('#', 79, 16, new Color(61, 50, 5));
		terminal.write('#', 79, 17, new Color(61, 50, 5));
		terminal.write('#', 79, 19, new Color(61, 50, 5));
		terminal.write('#', 79, 20, new Color(61, 50, 5));
		terminal.write('#', 79, 21, new Color(61, 50, 5));
		terminal.write('#', 79, 22, new Color(61, 50, 5));
		terminal.write('#', 79, 23, new Color(61, 50, 5));
		terminal.write('#', 79, 24, new Color(61, 50, 5));
		terminal.write('#', 79, 25, new Color(61, 50, 5));

		terminal.write('#', 80, 16,  new Color(61, 50, 5));
		terminal.write('#', 80, 17, new Color(241, 196, 15));
		terminal.write('#', 80, 18, new Color(241, 196, 15));
		terminal.write('#', 80, 19, new Color(241, 196, 15));
		terminal.write('#', 80, 20, new Color(241, 196, 15));
		terminal.write('#', 80, 21, new Color(241, 196, 15));
		terminal.write('#', 80, 22, new Color(241, 196, 15));
		terminal.write('#', 80, 23, new Color(241, 196, 15));
		terminal.write('#', 80, 24, new Color(241, 196, 15));
		terminal.write('#', 80, 25, new Color(241, 196, 15));
		terminal.write('#', 80, 26, new Color(241, 196, 15));
		terminal.write('#', 80, 27,  new Color(61, 50, 5));

		terminal.write('#', 81, 15,  new Color(61, 50, 5));
		terminal.write('#', 81, 16,  new Color(241, 196, 15));
		terminal.write('#', 81, 17, new Color(241, 196, 15));
		terminal.write('#', 81, 18, new Color(61, 50, 5));
		terminal.write('#', 81, 19, new Color(61, 50, 5));
		terminal.write('#', 81, 20, new Color(61, 50, 5));
		terminal.write('#', 81, 21, new Color(241, 196, 15));
		terminal.write('#', 81, 22, new Color(61, 50, 5));
		terminal.write('#', 81, 23, new Color(61, 50, 5));
		terminal.write('#', 81, 24, new Color(61, 50, 5));
		terminal.write('#', 81, 25, new Color(241, 196, 15));
		terminal.write('#', 81, 26,  new Color(241, 196, 15));
		terminal.write('#', 81, 27,  new Color(61, 50, 5));

		terminal.write('#', 82, 15,  new Color(61, 50, 5));
		terminal.write('#', 82, 16,  new Color(241, 196, 15));
		terminal.write('#', 82, 17, new Color(61, 50, 5));
		terminal.write('#', 82, 20, new Color(61, 50, 5));
		terminal.write('#', 82, 21, new Color(241, 196, 15));
		terminal.write('#', 82, 22, new Color(61, 50, 5));
		terminal.write('#', 82, 24, new Color(61, 50, 5));
		terminal.write('#', 82, 25, new Color(241, 196, 15));
		terminal.write('#', 82, 26,  new Color(61, 50, 5));

		terminal.write('#', 83, 15,  new Color(61, 50, 5));
		terminal.write('#', 83, 16,  new Color(241, 196, 15));
		terminal.write('#', 83, 19, new Color(61, 50, 5));
		terminal.write('#', 83, 20, new Color(241, 196, 15));
		terminal.write('#', 83, 21, new Color(61, 50, 5));
		terminal.write('#', 83, 24, new Color(61, 50, 5));
		terminal.write('#', 83, 25, new Color(241, 196, 15));
		terminal.write('#', 83, 26,  new Color(61, 50, 5));

		terminal.write('#', 84, 15,  new Color(61, 50, 5));
		terminal.write('#', 84, 16,  new Color(61, 50, 5));
		terminal.write('#', 84, 19, new Color(61, 50, 5));
		terminal.write('#', 84, 20, new Color(241, 196, 15));
		terminal.write('#', 84, 21, new Color(61, 50, 5));
		terminal.write('#', 84, 24, new Color(241, 196, 15));
		terminal.write('#', 84, 25, new Color(241, 196, 15));
		terminal.write('#', 84, 26,  new Color(61, 50, 5));

		terminal.write('#', 85, 15,  new Color(61, 50, 5));
		terminal.write('#', 85, 16,  new Color(61, 50, 5));
		terminal.write('#', 85, 19, new Color(61, 50, 5));
		terminal.write('#', 85, 20, new Color(241, 196, 15));
		terminal.write('#', 85, 21, new Color(61, 50, 5));
		terminal.write('#', 85, 23, new Color(61, 50, 5));
		terminal.write('#', 85, 24, new Color(241, 196, 15));
		terminal.write('#', 85, 25,  new Color(61, 50, 5));

		terminal.write('#', 86, 15,  new Color(61, 50, 5));
		terminal.write('#', 86, 16,  new Color(61, 50, 5));
		terminal.write('#', 86, 19, new Color(61, 50, 5));
		terminal.write('#', 86, 20, new Color(61, 50, 5));
		terminal.write('#', 86, 23, new Color(61, 50, 5));
		terminal.write('#', 86, 24, new Color(241, 196, 15));

		//------------------------ U ------------------------

		terminal.write('#', 110, 1,  new Color(66, 165, 245));
		terminal.write('#', 109, 1,  new Color(66, 165, 245));
		terminal.write('#', 108, 1,  new Color(62, 39, 35));
		terminal.write('#', 111, 1,  new Color(62, 39, 35));

		terminal.write('#', 108, 2,  new Color(62, 39, 35));
		terminal.write('#', 109, 2,  new Color(62, 39, 35));
		terminal.write('#', 110, 2,  new Color(62, 39, 35));
		terminal.write('#', 111, 2,  new Color(62, 39, 35));

		terminal.write('#', 109, 3,  new Color(62, 39, 35));
		terminal.write('#', 110, 3,  new Color(62, 39, 35));

		terminal.write('#', 109, 4,  new Color(62, 39, 35));
		terminal.write('#', 110, 4,  new Color(62, 39, 35));

		terminal.write('#', 109, 5,  new Color(62, 39, 35));
		terminal.write('#', 110, 5,  new Color(62, 39, 35));

		terminal.write('#', 109, 6,  new Color(62, 39, 35));
		terminal.write('#', 110, 6,  new Color(62, 39, 35));

		terminal.write('#', 109, 7,  new Color(62, 39, 35));
		terminal.write('#', 110, 7,  new Color(62, 39, 35));

		terminal.write('#', 109, 8,  new Color(62, 39, 35));
		terminal.write('#', 110, 8,  new Color(62, 39, 35));

		terminal.write('#', 109, 9,  new Color(62, 39, 35));
		terminal.write('#', 110, 9,  new Color(62, 39, 35));

		terminal.write('#', 108, 10,  new Color(62, 39, 35));
		terminal.write('#', 109, 10,  new Color(62, 39, 35));
		terminal.write('#', 110, 10,  new Color(62, 39, 35));
		terminal.write('#', 111, 10,  new Color(62, 39, 35));

		terminal.write('#', 108, 11,  new Color(62, 39, 35));
		terminal.write('#', 109, 11,  new Color(66, 165, 245));
		terminal.write('#', 110, 11,  new Color(66, 165, 245));
		terminal.write('#', 111, 11,  new Color(62, 39, 35));

		terminal.write('#', 108, 12,  new Color(62, 39, 35));
		terminal.write('#', 109, 12,  new Color(66, 165, 245));
		terminal.write('#', 110, 12,  new Color(66, 165, 245));
		terminal.write('#', 111, 12,  new Color(62, 39, 35));

		terminal.write('#', 108, 13,  new Color(62, 39, 35));
		terminal.write('#', 109, 13,  new Color(62, 39, 35));
		terminal.write('#', 110, 13,  new Color(62, 39, 35));
		terminal.write('#', 111, 13,  new Color(62, 39, 35));

		terminal.write('#', 107, 11,  new Color(62, 39, 35));
		terminal.write('#', 107, 12,  new Color(62, 39, 35));

		terminal.write('#', 106, 11,  new Color(0, 172, 193));
		terminal.write('#', 106, 10,  new Color(0, 172, 193));
		terminal.write('#', 105, 10,  new Color(0, 172, 193));
		terminal.write('#', 105, 9,  new Color(0, 172, 193));

		terminal.write('#', 106, 12,  new Color(62, 39, 35));
		terminal.write('#', 105, 11,  new Color(62, 39, 35));
		terminal.write('#', 105, 12,  new Color(62, 39, 35));
		terminal.write('#', 104, 12,  new Color(62, 39, 35));
		terminal.write('#', 104, 13,  new Color(62, 39, 35));

		terminal.write('#', 104, 14,  new Color(189, 189, 189));
		terminal.write('#', 104, 15,  new Color(189, 189, 189));
		terminal.write('#', 104, 16,  new Color(189, 189, 189));
		terminal.write('#', 105, 13,  new Color(189, 189, 189));
		terminal.write('#', 105, 14,  new Color(189, 189, 189));
		terminal.write('#', 105, 16,  new Color(189, 189, 189));
		terminal.write('#', 106, 13,  new Color(189, 189, 189));



		terminal.write('#', 114, 11,  new Color(62, 39, 35));
		terminal.write('#', 114, 12,  new Color(62, 39, 35));
		terminal.write('#', 113, 12,  new Color(62, 39, 35));
		terminal.write('#', 115, 12,  new Color(62, 39, 35));
		terminal.write('#', 115, 13,  new Color(62, 39, 35));

		terminal.write('#', 112, 11,  new Color(62, 39, 35));
		terminal.write('#', 112, 12,  new Color(62, 39, 35));

		terminal.write('#', 113, 11,  new Color(0, 172, 193));
		terminal.write('#', 113, 10,  new Color(0, 172, 193));
		terminal.write('#', 114, 10,  new Color(0, 172, 193));
		terminal.write('#', 114, 9,  new Color(0, 172, 193));

		terminal.write('#', 113, 12,  new Color(62, 39, 35));
		terminal.write('#', 112, 11,  new Color(62, 39, 35));
		terminal.write('#', 112, 12,  new Color(62, 39, 35));
		terminal.write('#', 111, 12,  new Color(62, 39, 35));
		terminal.write('#', 111, 13,  new Color(62, 39, 35));

		terminal.write('#', 115, 14,  new Color(189, 189, 189));
		terminal.write('#', 115, 15,  new Color(189, 189, 189));
		terminal.write('#', 115, 16,  new Color(189, 189, 189));
		terminal.write('#', 114, 13,  new Color(189, 189, 189));
		terminal.write('#', 114, 14,  new Color(189, 189, 189));
		terminal.write('#', 114, 16,  new Color(189, 189, 189));
		terminal.write('#', 113, 13,  new Color(189, 189, 189));



		terminal.write('#', 108, 14,  new Color(189, 189, 189));
		terminal.write('#', 108, 15,  new Color(189, 189, 189));
		terminal.write('#', 108, 16,  new Color(189, 189, 189));
		terminal.write('#', 108, 17,  new Color(189, 189, 189));
		terminal.write('#', 108, 18,  new Color(189, 189, 189));
		terminal.write('#', 108, 19,  new Color(189, 189, 189));
		terminal.write('#', 108, 20,  new Color(189, 189, 189));
		terminal.write('#', 108, 21,  new Color(189, 189, 189));
		terminal.write('#', 108, 22,  new Color(189, 189, 189));
		terminal.write('#', 108, 23,  new Color(189, 189, 189));
		terminal.write('#', 108, 24,  new Color(189, 189, 189));
		terminal.write('#', 108, 25,  new Color(189, 189, 189));
		terminal.write('#', 108, 26,  new Color(189, 189, 189));
		terminal.write('#', 108, 27,  new Color(189, 189, 189));
		terminal.write('#', 108, 28,  new Color(189, 189, 189));
		terminal.write('#', 108, 29,  new Color(189, 189, 189));
		terminal.write('#', 108, 30,  new Color(189, 189, 189));
		terminal.write('#', 108, 31,  new Color(189, 189, 189));

		terminal.write('#', 111, 14,  new Color(189, 189, 189));
		terminal.write('#', 111, 15,  new Color(189, 189, 189));
		terminal.write('#', 111, 16,  new Color(189, 189, 189));
		terminal.write('#', 111, 17,  new Color(189, 189, 189));
		terminal.write('#', 111, 18,  new Color(189, 189, 189));
		terminal.write('#', 111, 19,  new Color(189, 189, 189));
		terminal.write('#', 111, 20,  new Color(189, 189, 189));
		terminal.write('#', 111, 21,  new Color(189, 189, 189));
		terminal.write('#', 111, 22,  new Color(189, 189, 189));
		terminal.write('#', 111, 23,  new Color(189, 189, 189));
		terminal.write('#', 111, 24,  new Color(189, 189, 189));
		terminal.write('#', 111, 25,  new Color(189, 189, 189));
		terminal.write('#', 111, 26,  new Color(189, 189, 189));
		terminal.write('#', 111, 27,  new Color(189, 189, 189));
		terminal.write('#', 111, 28,  new Color(189, 189, 189));
		terminal.write('#', 111, 29,  new Color(189, 189, 189));
		terminal.write('#', 111, 30,  new Color(189, 189, 189));
		terminal.write('#', 111, 31,  new Color(189, 189, 189));
		terminal.write('#', 110, 31,  new Color(189, 189, 189));
		terminal.write('#', 109, 31,  new Color(189, 189, 189));
		terminal.write('#', 110, 32,  new Color(189, 189, 189));
		terminal.write('#', 109, 32,  new Color(189, 189, 189));

		terminal.write('#', 109, 14,  new Color(0, 172, 193));
		terminal.write('#', 109, 15,  new Color(0, 172, 193));
		terminal.write('#', 109, 16,  new Color(0, 172, 193));
		terminal.write('#', 109, 17,  new Color(0, 172, 193));
		terminal.write('#', 109, 18,  new Color(0, 172, 193));
		terminal.write('#', 109, 19,  new Color(66, 66, 66));
		terminal.write('#', 109, 20,  new Color(66, 66, 66));
		terminal.write('#', 109, 21,  new Color(66, 66, 66));
		terminal.write('#', 109, 22,  new Color(66, 66, 66));
		terminal.write('#', 109, 23,  new Color(0, 172, 193));
		terminal.write('#', 109, 24,  new Color(0, 172, 193));
		terminal.write('#', 109, 25,  new Color(0, 172, 193));
		terminal.write('#', 109, 26,  new Color(0, 172, 193));
		terminal.write('#', 109, 27,  new Color(0, 172, 193));
		terminal.write('#', 109, 28,  new Color(66, 66, 66));
		terminal.write('#', 109, 29,  new Color(66, 66, 66));
		terminal.write('#', 109, 30,  new Color(66, 66, 66));

		terminal.write('#', 110, 14,  new Color(66, 66, 66));
		terminal.write('#', 110, 15,  new Color(66, 66, 66));
		terminal.write('#', 110, 16,  new Color(66, 66, 66));
		terminal.write('#', 110, 17,  new Color(66, 66, 66));
		terminal.write('#', 110, 18,  new Color(0, 172, 193));
		terminal.write('#', 110, 19,  new Color(0, 172, 193));
		terminal.write('#', 110, 20,  new Color(0, 172, 193));
		terminal.write('#', 110, 21,  new Color(0, 172, 193));
		terminal.write('#', 110, 22,  new Color(0, 172, 193));
		terminal.write('#', 110, 23,  new Color(0, 172, 193));
		terminal.write('#', 110, 24,  new Color(66, 66, 66));
		terminal.write('#', 110, 25,  new Color(66, 66, 66));
		terminal.write('#', 110, 26,  new Color(66, 66, 66));
		terminal.write('#', 110, 27,  new Color(66, 66, 66));
		terminal.write('#', 110, 28,  new Color(0, 172, 193));
		terminal.write('#', 110, 29,  new Color(0, 172, 193));
		terminal.write('#', 110, 30,  new Color(0, 172, 193));


//		terminal.writeCenter("Press Start to play", 50, new Color(255, 255, 255));
	}
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}
