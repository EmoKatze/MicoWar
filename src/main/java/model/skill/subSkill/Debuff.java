package model.skill.subSkill;

import model.Stats;
import model.skill.Skill;

public class Debuff extends Skill {

    Stats debuffStats;

    public Debuff(int id, String name, String details, int range, Stats debuffStats) {
        super(id, name, details, range);
        this.debuffStats = debuffStats;
    }

    public Stats getDebuffStats() {
        return debuffStats;
    }

    public void setDebuffStats(Stats debuffStats) {
        this.debuffStats = debuffStats;
    }
}
