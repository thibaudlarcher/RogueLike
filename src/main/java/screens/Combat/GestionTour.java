package screens.Combat;

import creature.GroupCreature;

public class GestionTour {
    private GestionTour() {}

    public static int testJoueurTour(GroupCreature player) {
        for(int i = 0; i < player.getGroupCreature().size();i++){
            if(player.getGroupCreature().get(i).getTour() >= 100){
                return i;
            }
        }
        return -1;
    }
}
