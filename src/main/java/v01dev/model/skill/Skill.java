package v01dev.model.skill;

public abstract class Skill {
    protected int id;
    protected String name;
    protected String details;
    protected int range;

    public Skill(int id, String name, String details, int range) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.range = range;
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

    protected int getRange() {
        return range;
    }

    protected void setRange(int range) {
        this.range = range;
    }
}
