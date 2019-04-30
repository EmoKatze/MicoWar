package model.player;

import model.gear.Gear;
import model.Stats;
import model.gear.subGear.Arm;
import model.gear.subGear.Chest;
import model.gear.subGear.Leg;

import java.util.List;

public abstract class Player implements PlayerAction {
    protected int id;
    protected String name;
    protected int positionX;
    protected int positionY;
    protected Stats stats;
    protected Arm armGear;
    protected Chest chestGear;
    protected Leg legGear;
    private boolean active = false;

    public Player(int id, String name, int positionX, int positionY, Stats stats, Arm armGear, Chest chestGear, Leg legGear) {
        this.id = id;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.stats = stats;
        this.armGear = armGear;
        this.chestGear = chestGear;
        this.legGear = legGear;
    }

    public Player(int id, String name, int positionX, int positionY, Stats stats) {
        this.id = id;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.stats = stats;
    }

    public Chest getChestGear() {
        return chestGear;
    }

    public void setChestGear(Chest chestGear) {
        this.chestGear = chestGear;
    }

    public Leg getLegGear() {
        return legGear;
    }

    public void setLegGear(Leg legGear) {
        this.legGear = legGear;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Arm getArmGear() {
        return armGear;
    }

    public void setArmGear(Arm armGear) {
        this.armGear = armGear;
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

    protected int getPositionX() {
        return positionX;
    }

    protected void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    protected int getPositionY() {
        return positionY;
    }

    protected void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    protected Stats getStats() {
        return stats;
    }

    protected void setStats(Stats stats) {
        this.stats = stats;
    }
}
