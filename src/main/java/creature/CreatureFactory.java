package creature;
import asciiPanel.AsciiPanel;
import creature.PJ.Guerrier;
import creature.PJ.Mage;
import creature.PJ.PJ;
import world.*;
import player.*;
import monster.*;

/**
 * Classe des Creature factory.
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public class CreatureFactory {
    /**
     * Création d'un world
     */
    private World world;

    /**
     * Constructeur du Creature factory avec un world.
     * @param world Elle prend en paramètre un wolrd
     */
    public CreatureFactory(World world){
        this.world = world;
    }

    /**
     * Permet de créer un nouveau player jouable en fonction du choix de classe effectuée.
     * @param choix La classe que l'utilisateur choisi
     * @return Un type GroupeCréature qui représente le player
     */
    public GroupCreature newPlayer(PJ choix){
        //244 pied de biche
        //PJ choice = new Mage("bob",15,10);
        GroupCreature player = new GroupCreature(world, choix.glyph, choix.color, choix);
        player.x = world.getPt().x;
        player.y = world.getPt().y;
        new PlayerAi(player);
        return player;
    }

    /**
     * Permet de créer un nouveau villageois.
     * @param player Prends un player
     * @return un villageois
     */
    public GroupCreature newPlayerVillage(GroupCreature player){
        //244 pied de biche
        GroupCreature playerVillage = new GroupCreature(world, '@', AsciiPanel.green, new Guerrier("Bob",20,1));
        playerVillage.x = world.getPtVillage().x;
        playerVillage.y = world.getPtVillage().y;
        new PlayerAi(playerVillage);
        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSizeMax(); i++){
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

    /**
     * Permet de créer un nouveau monstre.
     * @param x Position x du monstre
     * @param y Position y du monstre
     * @return retourne le groupe créature
     */
    public GroupCreature newMonster(int x, int y){
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
}
