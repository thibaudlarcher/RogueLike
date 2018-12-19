package screens.EndGameScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;

public class LoseScreen implements Screen {
	private GroupCreature player;
	private int choix;

	public LoseScreen(GroupCreature player){
		this.player=player;
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("Continue", 10,this.choix == 0 ? brightRed : white );
		terminal.writeCenter("Quit", 15,this.choix == 1 ? brightRed : white);
	}

	public void restartchoice(){
		player.getGroupCreature().get(0).setPointDeVie(player.getGroupCreature().get(0).getPointDeVieMax());
		player.getGroupCreature().get(0).inventory().removeAllItem();
		player.getGroupCreature().get(0).inventory().setArmeEquipe(false);
		player.getGroupCreature().get(0).inventory().setArmureEquipe(false);
		player.getGroupCreature().get(0).inventory().setBotteEquipe(false);
		player.getGroupCreature().get(0).inventory().setCasqueEquipe(false);
		player.getGroupCreature().get(0).inventory().setPantalonEquipe(false);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_ENTER:
			switch (this.choix) {
				case 0:
					restartchoice();
					return new PlayScreen(player);
				case 1:
					exit(1);
					break;
			}
			case KeyEvent.VK_ESCAPE:
				exit(1);
			case KeyEvent.VK_DOWN:
				choix = (choix+1)%2;
				break;
			case KeyEvent.VK_UP:
				choix = (choix-1)%2;
				if (choix<0){
					choix = (choix+2);
				}
				break;
		}
		return this;
	}
}

