package creature.monstre;

import creature.Creature;
import creature.GroupCreature;


public abstract class Monstre extends Creature {

    public void takeAction(GroupCreature player){
        //System.out.println((int)(Math.random() * (player.getGroupCreature().size())));
        this.dealDamageTo(player.getGroupCreature().get((int)(Math.random() * (player.getGroupCreature().size()))));
    }

}
