package model;

public class Stats {
    private int attack;
    private int defense;
    private int dodge;
    private int mag;
    private int life;

    public Stats(int attack, int defense, int dodge, int mag, int life) {
        this.attack = attack;
        this.defense = defense;
        this.dodge = dodge;
        this.mag = mag;
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
