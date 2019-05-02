package v01dev.model.player.subPlayer;

import v01dev.model.skill.Skill;
import v01dev.model.Stats;
import v01dev.model.player.Player;

public class Support extends Player {

    public Support(int id, String name, int positionX, int positionY, Stats stats) {
        super(id, name, positionX, positionY, stats);
    }

    public boolean attackTarget(Player player) {
        return false;
    }

    public void defense() {

    }

    public void useSkill(Skill skill) {

    }
}
