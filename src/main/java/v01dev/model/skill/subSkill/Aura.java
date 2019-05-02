package v01dev.model.skill.subSkill;

import v01dev.model.Stats;
import v01dev.model.skill.Skill;

public class Aura extends Skill {

    private Stats auraStats;

    public Aura(int id, String name, String details, int range, Stats auraStats) {
        super(id, name, details, range);
        this.auraStats = auraStats;
    }

    public Stats getAuraStats() {
        return auraStats;
    }

    public void setAuraStats(Stats auraStats) {
        this.auraStats = auraStats;
    }
}
