package model.player;

import model.skill.Skill;

public interface PlayerAction {
    boolean attackTarget(Player player);

    void defense();

    void useSkill(Skill skill);
}
