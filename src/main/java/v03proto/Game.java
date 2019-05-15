package v03proto;

import java.util.Scanner;

public class Game {

    enum Action{
        SPELL, MOVE, ATTACK;
    }
    enum Player{
        Player1, Player2;
    }

    static Tile[][] board = new Tile[6][6];
    static char[] players = {'$','&'};

    public static void main(String[] args) {
        init();
        Player currentPlayer = Player.Player1;
        draw();
        for(int turns = 0 ; turns < 5 ; turns++){
            makeMove(currentPlayer);
            currentPlayer = changePlayer(currentPlayer);
            draw();
        }

    }

    private static void draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for(int i = 0 ; i < board.length ; i++){
            sb.append(i+"  ");
        }
        sb.append("\n");
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(j==0){
                    sb.append(i+" ");
                }
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

    private static Player changePlayer(Player currentPlayer) {
        if(currentPlayer == Player.Player1){
            return Player.Player2;
        } else {
            return Player.Player1;
        }
    }

    private static void makeMove(Player currentPlayer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Current Player: "+currentPlayer+"  "+currentPlayer.ordinal()+"  "+players[currentPlayer.ordinal()]);
        System.out.println("Please enter your Action\n"+
                "0 - Spell\n"+
                "1 - Move\n"+
                "2 - Attack\n");
        int input = sc.nextInt();
        switch(input){
            case 0:
                System.out.println("SPELL");
                break;
            case 1:
                System.out.println("MOVE");
                move(currentPlayer);
                break;
            case 2:
                System.out.println("ATTACK");
                break;
        }
    }

    private static void move(Player currentPlayer) {
        Tile selected = searchTileForPlayer(players[currentPlayer.ordinal()]);
        if(selected.isSomeoneStanding()){
            Tile goal = chooseTile(currentPlayer);
            if(goal.isSomeoneStanding()){
                System.out.println("Please choose a tile w/o a unit");
            } else {
                Unit temp = selected.getStandingUnit();
                selected.setStandingUnit(null);
                goal.setStandingUnit(temp);
            }
        } else {
            System.out.println("*move: DIDNT CHOOSE A UNIT");
        }
    }

    private static Tile searchTileForPlayer(char player) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                Unit u = board[i][j].getStandingUnit();
                if(!(u == null)){
                    if(u.getChar() == player){
                        return board[i][j];
                    }
                }
            }
        }
        return null;
    }

    private static Tile chooseTile(Player currentPlayer) {    Scanner sc = new Scanner(System.in);
        System.out.println("enter X coordinate of the tile: ");
        int x = sc.nextInt();
        System.out.println("enter Y coordinate of the tile: ");
        int y = sc.nextInt();
        System.out.println("*chooseTile:"/*+board[x][y].toString()*/+" x:"+x+" y:"+y);
        return board[x][y];
    }


    private static void init() {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                board[i][j] = new Tile('.');
            }
        }
        board[1][1].setStandingUnit(new Unit(players[0]));
        board[4][4].setStandingUnit(new Unit(players[1]));
    }

}
