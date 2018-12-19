package creature;

import asciiPanel.AsciiPanel;
import creature.pj.Guerrier;
import creature.pj.Mage;
import creature.pj.PJ;
import world.*;
import player.*;
import monster.*;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world) {
        this.world = world;
    }

    public GroupCreature newPlayer(PJ choix) {
        GroupCreature player = new GroupCreature(world, choix.glyph, choix.color, choix);
        player.x = world.getPt().x;
        player.y = world.getPt().y;
        new PlayerAi(player);
        return player;
    }

    public GroupCreature newPlayerVillage(GroupCreature player) {
        GroupCreature playerVillage;
        if (player.glyph() == 'M') {
            playerVillage = new GroupCreature(world, player.glyph(), player.getColor(), new Mage(player.getGroupCreature().get(0).getName(), player.getGroupCreature().get(0).getPointDeVieMax(), player.getGroupCreature().get(0).getAttaque(), player.getGroupCreature().get(0).getmagicattaque()));
        } else {
            playerVillage = new GroupCreature(world, player.glyph(), player.getColor(), new Guerrier(player.getGroupCreature().get(0).getName(), player.getGroupCreature().get(0).getPointDeVieMax(), player.getGroupCreature().get(0).getAttaque()));
        }
        playerVillage.x = world.getPtVillage().x;
        playerVillage.y = world.getPtVillage().y;
        new PlayerAi(playerVillage);
        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSizeMax(); i++) {
            if (player.getGroupCreature().get(0).inventory().get(i) != null) {
                playerVillage.getGroupCreature().get(0).inventory().add(player.getGroupCreature().get(0).inventory().get(i));
            }
        }
        return playerVillage;
    }

	/*public GroupCreature newBoss(){
		GroupCreature player = new GroupCreature(world, (char)144, AsciiPanel.green);
		player.x = world.getPtSpawn().x;
		player.y = world.getPtSpawn().y;
		new PlayerAi(player);
		return player;
	}*/

    public GroupCreature newMonster(int x, int y) {
        GroupCreature monster = new GroupCreature(world, (char)155, AsciiPanel.brightYellow, x, y);
        new MonsterAI(monster);
        return monster;
    }
    /*
	public GroupCreature newFlyingMonster(){
		GroupCreature player = new GroupCreature(world, (char)174, AsciiPanel.green);
		player.x = world.getPtSpawn().x;
		player.y = world.getPtSpawn().y;
		new PlayerAi(player);
		return player;
	}
	*/

    public GroupCreature newVillageois(int x, int y) {
        GroupCreature villageois = new GroupCreature(world, 'v', AsciiPanel.brightMagenta, x, y);
        return villageois;
    }
}
