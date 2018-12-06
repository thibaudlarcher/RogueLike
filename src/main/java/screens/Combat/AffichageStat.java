package screens.Combat;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;

import static asciiPanel.AsciiPanel.brightRed;

public class AffichageStat {
    private AffichageStat() { }

    public static void affichePV(AsciiPanel terminal, GroupCreature creature, GroupCreature player) {
        int yCrea = 9;
        int yPlayer = 25;
        for (int i = 0; i < creature.getGroupCreature().size(); i++) {
            terminal.write("PV:", 9 + 30 * i, yCrea, brightRed);
            if (creature.getGroupCreature().get(i).getPointDeVie() < 100) {
                terminal.write("0", 12 + 30 * i, yCrea, brightRed);
                terminal.write(Integer.toString(creature.getGroupCreature().get(i).getPointDeVie()),
                        13 + 30 * i, yCrea, brightRed);
            } else {
                terminal.write(Integer.toString(creature.getGroupCreature().get(i).getPointDeVie()),
                        12 + 30 * i, yCrea, brightRed);
            }
            terminal.write("/", 15 + 30 * i, yCrea, brightRed);
            if (creature.getGroupCreature().get(i).getPointDeVieMax() < 100) {
                terminal.write("0", 16 + 30 * i, yCrea, brightRed);
                terminal.write(Integer.toString(creature.getGroupCreature().get(i).getPointDeVieMax()),
                        17 + 30 * i, yCrea, brightRed);
            } else {
                terminal.write(Integer.toString(creature.getGroupCreature().get(i).getPointDeVieMax()),
                        16 + 30 * i, yCrea, brightRed);
            }

        }

        for (int i = 0; i < player.getGroupCreature().size(); i++) {
            terminal.write("PV:", 9 + 30 * i, yPlayer, brightRed);
            if (player.getGroupCreature().get(i).getPointDeVie() < 100) {
                terminal.write("0", 12 + 30 * i, yPlayer, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        13 + 30 * i, yPlayer, brightRed);
            } else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie()),
                        12 + 30 * i, yPlayer, brightRed);
            }
            terminal.write("/", 15 + 30 * i, yPlayer, brightRed);
            if (player.getGroupCreature().get(i).getPointDeVieMax() < 100) {
                terminal.write("0", 16 + 30 * i, yPlayer, brightRed);
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        17 + 30 * i, yPlayer, brightRed);
            } else {
                terminal.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()),
                        16 + 30 * i, yPlayer, brightRed);
            }

        }

    }

}
