package v03proto;

import java.util.HashMap;
import java.util.Scanner;

public class Game {


    enum Action {
        SPELL, MOVE, ATTACK;
    }

    enum Player {
        Player1, Player2;
    }

    static Tile[][] board = new Tile[6][6];
    static char[] players = {'$', '&'};

    static HashMap<Character, Integer> health = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        mainScreen();
        init();
        Player currentPlayer = Player.Player1;
        draw();
        for (int turns = 0; turns < 5; turns++) {
            makeMove(currentPlayer);
            currentPlayer = changePlayer(currentPlayer);
            draw();
        }

    }


    private static void mainScreen() {
        String mainscreen = "" +
                " _  _  __  ___  __   _  _ \n" +
                "( \\/ )(  )/ __)/  \\ / )( \\\n" +
                "/ \\/ \\ )(( (__(  O )\\ /\\ /\n" +
                "\\_)(_/(__)\\___)\\__/ (_/\\_)\n";
        Scanner sc = new Scanner(System.in);
        System.out.println(mainscreen);
        System.out.println("Enter Any Key to Start");
        sc.nextLine();
    }

    private static void draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < board.length; i++) {
            sb.append(i + "  ");
        }
        sb.append("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    sb.append(i + " ");
                }
                sb.append(board[j][i].getAll3Chars());
                /*
                if (board[j][i].isSomeoneStanding()) {
                    sb.append("" + board[j][i].getTextureChar() + board[j][i].getStandingUnit().getChar());
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
                */



            }
            sb.append("\n");
        }

        sb.append(getHealthDrawing());

        //sb.append("\nCursorTxt:");
        //sb.append(board[cursor[0]][cursor[1]].getCursorText());


        System.out.println(sb.toString());
    }

    private static String getHealthDrawing() {
        StringBuilder sb = new StringBuilder();
        for(Player p : Player.values()){
            sb.append(p+": "+players[p.ordinal()]+" - HP: "+health.get(players[p.ordinal()])+"\n");
        }
        sb.append("\n");
        return sb.toString();
    }


    private static Player changePlayer(Player currentPlayer) {
        if (currentPlayer == Player.Player1) {
            return Player.Player2;
        } else {
            return Player.Player1;
        }
    }

    private static void makeMove(Player currentPlayer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Current Player: " + currentPlayer + "  " + currentPlayer.ordinal() + "  " + players[currentPlayer.ordinal()]);
        System.out.println("Please enter your Action\n" +
                "0 - Spell\n" +
                "1 - Move\n" +
                "2 - Attack\n");
        int input = sc.nextInt();
        switch (input) {
            case 0:
                wizard(currentPlayer);
                System.out.println("SPELL");
                break;
            case 1:
                System.out.println("MOVE");
                move(currentPlayer);
                break;
            case 2:
                System.out.println("ATTACK");
                attack(currentPlayer);
                break;
        }
    }

    private static void wizard(Player currentPlayer) {
        System.out.println("choose tile to fuck up");
        Tile selected = chooseTile(currentPlayer);
        selected.setEffect(new Tile.Fire());
    }

    private static void attack(Player currentPlayer) {
        Tile playerTile = searchTileForPlayer(players[currentPlayer.ordinal()]);
        System.out.println(checkForAdjacentUnit(playerTile));
        if(checkForAdjacentUnit(playerTile)){
            battle(currentPlayer);
        } else {
            System.out.println("cant attack, no unit in neighborhood");
        }
        return;
    }

    private static void battle(Player currentPlayer) {
        drawBattleScreen();
        Scanner sc = new Scanner(System.in);
        int battleturns = 4;
        System.out.println("Please Implement Battle System, now it simulates random combat"); //TODO :)

        battleScene(Player.Player1, Player.Player2);

        //System.out.println("Current Player: " + currentPlayer + "  " + currentPlayer.ordinal() + "  " + players[currentPlayer.ordinal()]);
        /*
        System.out.println("Please enter your Action "+currentPlayer+"\n" +
                "0 - atk0\n" +
                "1 - atk1\n" +
                "2 - def0\n");
         */
        //int input = sc.nextInt();
        /*
        switch (input) {
            case 0:

                break;
            case 1:

                break;
            case 2:


                break;
        }
        */
        /*
        System.out.println(getHealthDrawing());
        currentPlayer = changePlayer(currentPlayer);
        for(int i = 0; i < battleturns ; i++){
            Tile selected = searchTileForPlayer(players[currentPlayer.ordinal()]);
            assert selected != null; //Kp was das ist, ich probiere es mal aus
            int damage = 0;
            damage = (int) (Math.random()*200); //100 -> 50 dmg
            if(selected.isEffected()){
                damage /= selected.getEffect().getDefenseFactor(); //Bei defesefactor 2 -> halber dmg
                System.out.println("Debug damage: "+damage); //temp
            }
            int relevantHealth = health.get(players[currentPlayer.ordinal()])-damage;
            health.put(players[currentPlayer.ordinal()], relevantHealth);
            System.out.println(getHealthDrawing());

            try {
                System.out.println("Sleeping now");
                Thread.sleep(1500);
                System.out.println("Wakeup");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentPlayer = changePlayer(currentPlayer);
        }

        */
    }

    enum AttackType {
        Lighntning, Slash, Blunt
        /*
        Lightning   > Slash
        Slash       > Blunt
        Blunt       > Lightning
         */
    }

    private static void battleScene(Player player1, Player player2) {
        AttackType player1type = chooseAttackType(player1);
        assert player1type != null;
        AttackType player2type = chooseAttackType(player2);
        assert player2type != null;

        int[] damageP1P2 = calculateDamage(player1type, player2type);



    }

    //returns the damages that need to be subtracted from the players health
    //check ground tile effect of both players then calcualte by the attacktypes and stats
    //#Uff #TODO
    //int[0]:P1     int[1]:P2
    private static int[] calculateDamage(AttackType player1type, AttackType player2type) {
        Tile player1Tile = searchTileForPlayer(players[0]);
        Tile player2Tile = searchTileForPlayer(players[1]);
        assert player1Tile != null;                                         //Kp was das ist, ich probiere es mal aus
        assert player2Tile != null;


        try {
            int outcome = calculateOutcome(player1type, player2type); //0 for P1 win, 1 for draw, 2 for P2 win, -1 for error
        } catch (Exception e) {
            e.printStackTrace();
        }

        int damage = 0; //TODO calculate Damage


        if(player1Tile.isEffected()){
            damage /= player1Tile.getEffect().getDefenseFactor(); //Bei defesefactor 2 -> halber dmg
            System.out.println("P1 Debug damage: "+damage); //temp
        }
        if(player1Tile.isEffected()){
            damage /= player1Tile.getEffect().getDefenseFactor(); //Bei defesefactor 2 -> halber dmg = dmg/defensefactor
            System.out.println("P1 Debug damage: "+damage); //temp
        }



        //here the new refreshed health gets calculated and the old health gets overridden :)
        int relevantHealthP1 = health.get(players[0])-damage;
        health.put(players[0], relevantHealthP1);

        int relevantHealthP2 = health.get(players[1])-damage;
        health.put(players[1], relevantHealthP2);


        return null;//new int[]{-1,-1}; //nur temp
    }

    enum winner {
        P1,Draw,P2
    }

        /*
        Lightning   > Slash
        Slash       > Blunt
        Blunt       > Lightning
         */
    //ich werde diese methode jetzt mies vergewaltigen, bitte besser neu machen future bj oder future ju TODO
    private static int calculateOutcome(AttackType player1type, AttackType player2type) throws Exception {
        switch(player1type){
            case Blunt:
                switch (player2type){   //P1: BLUNT
                    case Blunt:         //Draw
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.Draw.ordinal()+" //ICH HOFFE ES IST 1");
                        return winner.Draw.ordinal(); //Draw -> int 1
                    case Slash:         //P2 WIN
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.P2.ordinal()+" //ICH HOFFE ES IST 2");
                        return winner.P2.ordinal(); //Draw -> int 2
                    case Lighntning:    //P1 WIN
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.P1.ordinal()+" //ICH HOFFE ES IST 0");
                        return winner.P1.ordinal(); //Draw -> int 0
                    default:
                        System.out.println("KEINER HAT GEWONNEN PROGRAMM MÜDE");
                        throw new Exception("calculateOutcome Error :)");
                }
            case Slash:
                switch (player2type){   //P1: SLASH
                    case Blunt:         //P1 WIN
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.Draw.ordinal()+" //ICH HOFFE ES IST 0");
                        return winner.P1.ordinal(); //Draw -> int 0
                    case Slash:         //DRAW
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.P2.ordinal()+" //ICH HOFFE ES IST 1");
                        return winner.Draw.ordinal(); //Draw -> int 1
                    case Lighntning:    //P2 WIN
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.P2.ordinal()+" //ICH HOFFE ES IST 2");
                        return winner.P2.ordinal(); //Draw -> int 2
                    default:
                        System.out.println("KEINER HAT GEWONNEN PROGRAMM MÜDE");
                        throw new Exception("calculateOutcome Error :)");
                }
            case Lighntning:                                    //Warum hält der zug jetzt an FML bin fast fertig
                switch (player2type){   //P1: LIGHTNING
                    case Blunt:         //P2 WIN
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.Draw.ordinal()+" //ICH HOFFE ES IST 2");
                        return winner.P2.ordinal(); //P2 -> int 2
                    case Slash:         //P1 WIN
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.P2.ordinal()+" //ICH HOFFE ES IST 0");
                        return winner.P1.ordinal(); //P1-> int 0
                    case Lighntning:    //DRAW
                        System.out.println("DIESE METHODE RETURNT JETZT: "+winner.P2.ordinal()+" //ICH HOFFE ES IST 1");
                        return winner.Draw.ordinal(); //Draw -> int 1
                    default:
                        System.out.println("KEINER HAT GEWONNEN PROGRAMM MÜDE");
                        throw new Exception("calculateOutcome Error :)");
                }
            default:
                System.out.println("error");
                break;
        }
        return 0; //TEMP TODO
    }

    private static AttackType chooseAttackType(Player player1) {
        return null; //TEMP TODO
    }

    private static void drawBattleScreen() {
        String screen = " ___  ____ ___ ___ _    ____\n" +
                        " |--] |--|  |   |  |    |---\n" +
                        " |__] |  |  |   |  |___ |___\n" +
                players[Player.Player1.ordinal()] +
                " VS " +
                players[Player.Player2.ordinal()]+"\n";
        System.out.println(screen);
    }

    private static boolean checkForAdjacentUnit(Tile playerTile) {
        /* Bro wie würdest du machen? brauche ne methode die das umfeld chceckt von nem feld
        also ich muss mit ner schleife folgendes checken (überall wo X steht)

        Nur checken, ob X ja oder nein? und dann position merken? in ner liste

        eig nur boolean gibt es eine unit auf einer tile nebenan, soll ich noch zeigen wie man fragt?
              0  1  2  3  4  5
            0 .  .  .  .  .  .
            1 .  .X .X .X .  .
            2 .  .X .$ .X .& .
            3 .  .X .X .X .  .
            4 .  .  .  .  .  .
            5 .  .  .  .  .  .

              0  1  2  3  4  5
            0 .$ .X .  .  .  .
            1 .X .X .  .  .  .
            2 .  .  .  .  .& .
            3 .  .  .  .  .  .
            4 .  .  .  .  .  .
            5 .  .  .  .  .  .

            Digga die methode checke alle felder und checkt ob es irgendwo eine unit gibt

            ich will checken ob eine bestimmt unit, wie in den beispielen $ einen nachbarn hat
            auf dem eine andere unit steht
         */
        int x = playerTile.x;
        int y = playerTile.y;
        boolean leftPossible = false;
        boolean rightPossible = false;
        boolean topPossible = false;
        boolean bottomPossible = false;

        // check top
        topPossible = checkIndexLeftOrTopBoard(x);
        // check bottom
        bottomPossible = checkIndexBottomBoard(x);
        // check left
        leftPossible = checkIndexLeftOrTopBoard(y);
        // check right
        rightPossible = checkIndexRightBoard(y);

        //execute cross
        if (topPossible) {
            if (board[x - 1][y].getStandingUnit() != null) {
                return true;
            }
        } else if (bottomPossible) {
            if (board[x + 1][y].getStandingUnit() != null) {
                return true;
            }
        } else if (leftPossible) {
            if (board[x][y - 1].getStandingUnit() != null) {
                return true;
            }
        } else if (rightPossible) {
            if (board[x][y + 1].getStandingUnit() != null) {
                return true;
            }
        }

        // check and execute diagonal
        if (topPossible && leftPossible) {
            return board[x - 1][y - 1].getStandingUnit() != null;
        }
        if (topPossible && rightPossible) {
            return board[x - 1][y + 1].getStandingUnit() != null;
        }
        if (bottomPossible && leftPossible) {
            return board[x + 1][y - 1].getStandingUnit() != null;

        }
        if (bottomPossible && rightPossible) {
            return board[x + 1][y + 1].getStandingUnit() != null;
        }

        return false;
    }


    private static boolean checkIndexLeftOrTopBoard(final int index) {
        return index > 0;
    }

    private static boolean checkIndexBottomBoard(final int index) {
        return index < board[0].length - 1;
    }

    private static boolean checkIndexRightBoard(final int index) {
        return index < board.length - 1;
    }

    private static void move(Player currentPlayer) {    //TODO assert if noone is standing and in field etc
        Tile selected = searchTileForPlayer(players[currentPlayer.ordinal()]);
        if (selected.isSomeoneStanding()) {
            Tile goal = chooseTile(currentPlayer);
            if (goal.isSomeoneStanding()) {
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Unit u = board[i][j].getStandingUnit();
                if (!(u == null)) {
                    if (u.getChar() == player) {
                        return board[i][j];
                    }
                }
            }
        }
        return null;
    }

    private static Tile chooseTile(Player currentPlayer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter X coordinate of the tile: ");
        int x = sc.nextInt();
        System.out.println("enter Y coordinate of the tile: ");
        int y = sc.nextInt();
        System.out.println("*chooseTile:"/*+board[x][y].toString()*/ + " x:" + x + " y:" + y);
        return board[x][y];
    }


    private static void init() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Tile('.', i, j);
            }
        }
        board[1][1].setStandingUnit(new Unit(players[0]));
        board[4][4].setStandingUnit(new Unit(players[1]));
        health.put(players[Player.Player1.ordinal()], 1000);
        health.put(players[Player.Player2.ordinal()], 1000);
    }

}
