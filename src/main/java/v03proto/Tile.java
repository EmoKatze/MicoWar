package v03proto;

public class Tile {
    private char tx = '.';
    private Unit standing = null;
    //private String text = "Default Tile"; For Cursor
    int x,y;
    private Effect effect = null;

    String getAll3Chars(){
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

    boolean isEffected(){
        return !(effect == null);
    }

    Effect getEffect() {
        return effect;
    }

    void setEffect(Effect e) {
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

    boolean isSomeoneStanding(){
        return !(standing == null);
    }
    Unit getStandingUnit(){
        return standing;
    }
    void setStandingUnit(Unit u){
        //if(standing == null){
        standing = u;
        //} else {
        //System.out.println("*E*setStandingUnit: standing is not null: "+standing.getText());
        //}
    }
    /*
    public String getCursorText(){
        if(isSomeoneStanding()){
            return text+"\nUnit: "+standing.getText();
        } else {
            return text;
        }
    }
    */
    private char getTextureChar(){
        return tx;
    }

    static abstract class Effect{
        char texture;
        double attackFactor = 1;    //for unit standing on effected tile
        double defenseFactor = 1;   //for unit standing on effected tile

        char getTexture() {
            return texture;
        }
        /*
        public double getAttackFactor() {
            return attackFactor;
        }
        */
        double getDefenseFactor() {
            return defenseFactor;
        }
    }
    static class Fire extends Effect {
        Fire(){
            texture = 'f';
            attackFactor = 0.7;
            defenseFactor = 0.5;
        }
    }

}
