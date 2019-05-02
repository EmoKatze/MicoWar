package v01dev.model.skill.subSkill;

import v01dev.model.Stats;
import v01dev.model.skill.Skill;

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
