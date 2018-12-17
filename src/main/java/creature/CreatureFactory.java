package creature;
import asciiPanel.AsciiPanel;
import creature.PJ.Guerrier;
import world.*;
import player.*;
import monster.*;
public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    public GroupCreature newPlayer(){
        //244 pied de biche
        GroupCreature player = new GroupCreature(world, '@', AsciiPanel.green, new Guerrier("Bob",20,1));
        player.x = world.getPositionPersonnageX();
        player.y = world.getPositionPersonnageY();
        new PlayerAi(player);
        return player;
    }

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
