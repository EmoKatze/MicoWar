package model.player.subPlayer;

import model.skill.Skill;
import model.Stats;
import model.player.Player;

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
