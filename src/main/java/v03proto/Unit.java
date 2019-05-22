package v03proto;

public class Unit {
    private char tx;
    private int atk,hp,mvmt;
    private String text = "Default Unit";
    String getText() {
        return text;
    }

    public int getAtk(){
        return atk; //ARMS
    }
    public int getMvmt(){
        return mvmt; //LEGS
    }
    public int getHP(){
        return hp;
    }

    char getChar(){
        return tx;
    }
    public Unit(char tx){
        this.tx = tx;
        atk = 5;
        mvmt = 3;
        hp = 10;
    }
}
