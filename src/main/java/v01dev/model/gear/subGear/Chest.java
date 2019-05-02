package v01dev.model.gear.subGear;

import v01dev.model.Stats;
import v01dev.model.gear.Gear;
import v01dev.model.skill.subSkill.Aura;

public class Chest extends Gear {

    public Chest(int id, String name, String details, Stats statBoni, Aura auraSkill) {
        super(id, name, details, auraSkill);
        this.statBoni = statBoni;
    }

    private Stats statBoni;

    public Stats getStatBoni() {
        return statBoni;
    }

    public void setStatBoni(Stats statBoni) {
        this.statBoni = statBoni;
    }
}
