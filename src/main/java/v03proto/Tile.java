package v03proto;

import v02proto.Game;

public class Tile {
    char tx = '.';
    Unit standing = null;
    String text = "Default Tile";
    public int x,y;

    Effect effect = null;

    public String getAll3Chars(){
        StringBuilder sb = new StringBuilder();
        sb.append(getTextureChar());
        if(isSomeoneStanding()){
            sb.append(getStandingUnit().getChar());
        }
        if(isEffected()){
            sb.append(effect.getTexture());
        }
        while(sb.toString().length() < 3){
            sb.append(" ");
        }
        return sb.toString();
    }

    public Effect getEffect() {
        return effect;
    }

    public boolean isEffected(){
        return !(effect == null);
    }

    public void setEffect(Effect e) {
        this.effect = e;
    }

    public Tile(char texture){ tx = texture; }
    public Tile(Unit u){
        standing = u;
    }

    public Tile(char c, int i, int j) {
        tx = c;
        x = i;
        y = j;
    }

    public char getTexture(){
        return tx;
    }
    public boolean isSomeoneStanding(){
        return !(standing == null);
    }
    public Unit getStandingUnit(){
        return standing;
    }
    public void setStandingUnit(Unit u){
        //if(standing == null){
        standing = u;
        //} else {
        //System.out.println("*E*setStandingUnit: standing is not null: "+standing.getText());
        //}
    }
    public String getCursorText(){
        if(isSomeoneStanding()){
            return text+"\nUnit: "+standing.getText();
        } else {
            return text;
        }
    }
    public char getTextureChar(){
        return tx;
    }

    public static abstract class Effect{
        char texture;
        double attackFactor = 1;    //for unit standing on effected tile
        double defenseFactor = 1;   //for unit standing on effected tile

        public char getTexture() {
            return texture;
        }

        public double getAttackFactor() {
            return attackFactor;
        }

        public double getDefenseFactor() {
            return defenseFactor;
        }
    }
    public static class Fire extends Effect {
        public Fire(){
            texture = 'f';
            attackFactor = 0.7;
            defenseFactor = 0.5;
        }
    }

}
