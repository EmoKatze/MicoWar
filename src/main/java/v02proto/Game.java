package v02proto;

import java.util.Scanner;

public class Game {

    static char[] players = {'$','Y'};
    static Tile[][] board = new Tile[8][8];
    static int turn = 1;
    static int[] cursor = {0,0};
    static int ap=1;

    public static void main(String[] args) {
        startGame();

    }

    static void startGame(){
        initBoard();

        boolean gameOver = false;
        for(turn = 1 ; !gameOver ; turn++){
            ap = turn;
            draw();
            makeTurn(whosTurn()); //TODO
            gameOver = true;
            //TEST 123456
        }
    }

    private static void draw() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(board[j][i].isSomeoneStanding()){
                    sb.append(""+board[j][i].getTextureChar()+board[j][i].getStandingUnit().getChar());
                    //if(cursor[0]==i&&cursor[1]==j){
                    //    sb.append("C");
                    //} else {
                        sb.append(" ");
                    //}
                } else {
                    sb.append(board[j][i].getTextureChar());
                    //if(cursor[0]==i&&cursor[1]==j){
                    //    sb.append("C ");
                    //} else {
                        sb.append("  ");
                    //}
                }


            }
            sb.append("\n");
        }
        //sb.append("\nCursorTxt:");
        //sb.append(board[cursor[0]][cursor[1]].getCursorText());


        System.out.println(sb.toString());
    }

    private static void initBoard() {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                board[i][j] = new Tile('.');
            }
        }
        board[1][1].setStandingUnit(new Tile.Unit(players[0]));
        board[6][6].setStandingUnit(new Tile.Unit(players[1]));
    }

    static void makeTurn(int player){
        System.out.println("current player: "+players[player]+" : "+player);
        while(ap > 0){
            System.out.println("what do you want to do?");
            System.out.println(""
                    + "m = move\n"
                    + "a = attack\n"
                    + "s = special ability\n"
                    + "0 = skip turn\n"
                    + "f = quit\n"
                    + "r = replay\t hier können weitere commands hin\n"
                    + "");
            Scanner sc = new Scanner(System.in);
            String inn = sc.nextLine();
            char in = inn.charAt(0);
            System.out.println(in+"\n");
            switch (in){
                case 'm' : move(player);
                    break;
                case 'a' :  System.out.println("in welche Richtung? n,w,e,s");
                    String directio = sc.nextLine();
                    char dir = directio.charAt(0);
                    attack(player ,dir);
                    break;
                case 's' :
                    System.out.println("Special Ability");
                    break;
                case '0' : System.out.println("Turn Skipped");
                    break;
                case 'f' :
                    System.out.println("G A M E O V E R");
                    break;
            }
            ap += -1;
            System.out.println("*makeTurn: new ap: "+ap);
        }
    }

    private static void attack(int player, char dir) {
        //TODO
    }

    private static void move(int player) {
        //TODO
    }

    private static Tile chooseTile(int player) {
        boolean isselected = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter coordinates of the tile: x [leerz] y");
        String ip = sc.nextLine();
        String[] input = ip.split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        System.out.println("*chooseTile: "+board[x][y].toString()+"x:"+x+" y:"+y);
        return board[x][y];
    }

    static int whosTurn(){
        return players.length % turn;
    }


    private static class Tile{
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
            if(standing == null){
                standing = u;
            } else {
                System.out.println("*E*setStandingUnit: standing is not null: "+standing.getText());
            }
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

        Unit u = null;


        private static class Unit{
            public char tx;
            private int atk,hp,mvmt;
            public String text = "Default Unit";
            public String getText() {
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
            public char getChar(){
                return tx;
            }
            public Unit(char tx){
                this.tx = tx;
                atk = 5;
                mvmt = 3;
                hp = 10;
            }
        }
    }


}
