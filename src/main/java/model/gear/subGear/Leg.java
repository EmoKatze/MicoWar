package model.gear.subGear;

import model.Stats;
import model.gear.Gear;
import model.skill.subSkill.Debuff;

public class Leg extends Gear {

    public Leg(int id, String name, String details, Stats statBoni, Debuff debuffSkill) {
        super(id, name, details, debuffSkill);
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
