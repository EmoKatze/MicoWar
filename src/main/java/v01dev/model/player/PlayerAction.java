package v01dev.model.player;

import v01dev.model.skill.Skill;

public interface PlayerAction {
    boolean attackTarget(Player player);

    void defense();

    void useSkill(Skill skill);
}
