package v01dev.model.gear.subGear;

import v01dev.model.gear.Gear;
import v01dev.model.skill.subSkill.Attack;

public class Arm extends Gear {

    private int range;

    public Arm(int id, String name, String details, Attack attackSkill, int range) {
        super(id, name, details, attackSkill);
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
