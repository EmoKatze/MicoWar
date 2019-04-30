package model.gear;

import model.skill.Skill;

public abstract class Gear {
    protected int id;
    protected String name;
    protected String details;
    protected Skill skill;

    public Gear(int id, String name, String details, Skill skill) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.skill = skill;
    }

    protected Skill getSkill() {
        return skill;
    }

    protected void setSkill(Skill skill) {
        this.skill = skill;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getDetails() {
        return details;
    }

    protected void setDetails(String details) {
        this.details = details;
    }
}
