package v03proto;

import v02proto.Game;

public class Tile {
    char tx = '.';
    Unit standing = null;
    String text = "Default Tile";

    public Tile(char texture){
        tx = texture;
    }
    public Tile(Unit u){
        standing = u;
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


}
