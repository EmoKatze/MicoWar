package v01p; //Version 01 Prototype

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Proto {
    public static void main(String[] args){

        Model m = new Model();
        View v = new View(m);
        Controller c = new Controller(m,v);

        Container con = new Container(m,v,c);
        con.start();
    }

    private static class Container extends JFrame{
        Model model;
        View view;
        Controller controller;
        public Container(Model m, View v, Controller c){
            this.model = m;
            this.view = v;
            this.controller = c;

            this.setLayout(new BorderLayout());
            this.add(view.getPanel(), BorderLayout.NORTH);
            this.add(controller, BorderLayout.SOUTH);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setSize(1000, 1000);
            this.setVisible(true);
        }
        public void start() {
            model.run();
            //view.run();
            //controller.run();
        }
  /*
  public Container(Model m1){
   this.model = m1;
  }
  public Container(){
   test();
  }

  void test(){
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLocationRelativeTo(null);

         this.setSize(500,500);

   //this.pack();
   this.setVisible(true);
  }
  */
    }

    private static class Model implements Runnable  {
        /*        ***CUSTOM ROBO IDEE***
         * Tile-, Turn-Based Movement and Combat
         * ( Prototype: 1 vs 1, 8x8 tile grid, 16px x 16px tiles)
         * Build your Character by choosing from different Parts
         * Arm/Weapon -> Shooting Weapon        //Note to self:
         *   Left Arm -> Defense          //Dont start Building
         *   Right Arm -> Attack          //Empires! Start with
         * Legs -> Movement            //a house
         * Chest/Character -> HP / Look / Ultimate(maybe) / Type (From Sniper to Necromancer)
         * ??? -> ??? (extendable)
         *
         * Every Character has 2 AP per Turn
         * During a Turn you can spend 1 AP to move or attack
         *
         * Theme (View):
         *    1. Genome-Splicer >:0 ( angery )
         *       choose from mutations and animal-parts ( claws etc )
         *    2. Cyber-Robo
         *      aka Custom Robo for poor people
         *    3. ???
         *      ???  (need a good theme idea)
         *
         * "AutoChess - Idea":
         *   Each unit has an "auto-attack" which triggers every turn if another
         *   unit stands in their autoattack range, here are some examples:
         *   pleb:   x   medium: xxx sniper:   x x x
         *       xux   xux      xxx
         *     x   xxx       xxxuxxx
         *   Because this is an easy to understand mechanic, we can add the real
         *   goal, a once-per-5-turns-or-so mechanic, that is specific for the
         *   part it is associated with (e.g. the right arm is the "auto-attack",
         *   the torso could have an ability like healing, stealth, explosion, etc)
         *
         */
        private abstract class Unit{
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
                return 'u';
            }
            public Unit(){
                atk = 5;
                mvmt = 3;
                hp = 10;
            }
        }

        private class DefUnit extends Unit{

        }

        Tile[][] screen = new Tile[8][8];

        int[] cursor = {0,0};

        private abstract class Tile{
            char[] tx = {'.','.','.','.'};
            Unit standing = null;
            String text = "Default Tile";

            public Tile(){}
            public Tile(Unit u){
                standing = u;
            }
            public char[] getTexture(){
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
                return tx[0];
            }
        }
        private class DefTile extends Tile{

        }
        private class MounTile extends Tile{

            public MounTile(){
                tx = new char[]{'M','M','M','M'};
                text = "Mountain Tile";
                //System.out.println("this.getTextureChar(): "+this.getTextureChar());
            }


        }


        void initScreen(){
            for(int i = 0 ; i < 8 ; i++){
                for(int j = 0 ; j < 8 ; j++){
                    screen[i][j] = new DefTile();
                }
            }
            screen[3][3] = new MounTile();
            screen[3][3].setStandingUnit(new DefUnit());
            screen[4][4] = new MounTile();
            screen[4][3] = new MounTile();
            screen[3][4] = new MounTile();

        }

        public Model(){
            initScreen();
            start();
        }
        private void start() {
            screen[1][1].setStandingUnit(new DefUnit());
            screen[6][6].setStandingUnit(new DefUnit());
            //System.out.println(screenToString());
        }

        public String screenToString(){ //DAS IST GERADE DER VIEW VOM MVC
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 8 ; i++){
                for(int j = 0 ; j < 8 ; j++){

                    if(screen[j][i].isSomeoneStanding()){
                        sb.append(""+screen[j][i].getTextureChar()+screen[j][i].getStandingUnit().getChar());
                        if(cursor[0]==i&&cursor[1]==j){
                            sb.append("C");
                        } else {
                            sb.append(" ");
                        }
                    } else {
                        sb.append(screen[j][i].getTextureChar());
                        if(cursor[0]==i&&cursor[1]==j){
                            sb.append("C ");
                        } else {
                            sb.append("  ");
                        }
                    }


                }
                sb.append("\n");
            }
            sb.append("\nCursorTxt:");
            sb.append(screen[cursor[0]][cursor[1]].getCursorText());


            return sb.toString();
        }
        public void run() {
            //mainMenu()
            //gameLogic()
            /* TODO:
             * -Alles in 1 Fenster bekommen
             * -GameLogic implementieren
             * -Mehr Units / Tiles
             */


   /*
   Scanner sc = new Scanner(System.in);
   System.out.println("Give yur comment: n/s/w/e/x");
   String inp = "";
   //while(inp != "x"){
    //inp = sc.nextLine();
    switch(inp){
     case "n":
      cursor[0] -= 1;
      break;
     case "s":
      cursor[0] += 1;
      break;
     case "w":
      cursor[1] -= 1;
      break;
     case "e":
      cursor[1] += 1;
      break;
    }
    System.out.println(screenToString());
   //}
   System.out.println("OFFSWITCH");
   //sc.close();
    *
    */
        }
        public boolean gameOver() {
            return false;
        }
        public void moveCursor(char c) {
            switch(c){
                case 'n':
                    if(cursor[0]>0){
                        cursor[0] -= 1;
                    }
                    break;
                case 's':
                    if(cursor[0]<7){
                        cursor[0] += 1;
                    }
                    break;
                case 'w':
                    if(cursor[1]>0){
                        cursor[1] -= 1;
                    }
                    break;
                case 'e':
                    if(cursor[1]<7){
                        cursor[1] += 1;
                    }
                    break;
            }

        }
        public void selectTile(int x, int y) {


        }

        //GAMELOGIC, Playable over system.out ?
    }

    private static class View extends JPanel implements Runnable {
        //Uses Model to generate view
        Model m;
        JTextPane textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("I'm a Style", null);
        JPanel frame;

        public View(Model m){
            this.m = m;
            setup();
            push(m.screenToString());
        }


        void setup(){
            StyleConstants.setBackground(style, Color.white);
            StyleConstants.setForeground(style, Color.black);
            frame = new JPanel();
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(textPane);
            textPane.setFont(new Font("Monospaced", Font.PLAIN,30)); //monospaced,0,10 default
            //frame.pack();
            //frame.setSize(400,400);
            frame.setBackground(Color.LIGHT_GRAY);

            frame.setPreferredSize(new Dimension(500,1000));

            //frame.setMinimumSize(new Dimension(400,400));

            frame.setVisible(true);
        }

        JPanel getPanel(){
            return frame;
        }

        void push(String s){
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("\n\n\n");
            try {
                doc.remove(0, doc.getLength());
                doc.insertString(0, sb.toString() , style);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        void push(char[][] screen){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < screen.length ; i++){
                for(int j = 0 ; j < screen[1].length ; j++){
                    sb.append(screen[i][j]);
                }
                sb.append("\n");
            }
            push(sb.toString());
        }
        public void redraw(){
            push(m.screenToString());
        }
        public void run() {
   /*
   while(!m.gameOver()){
    System.out.println("m? "+m.toString());
    push(m.screenToString());
    System.out.println("Reload view");
    try {
     Thread.sleep(1000);
    } catch (InterruptedException e) {
     e.printStackTrace();
    }
   }
   */

        }

    }

    private static class Controller extends JPanel implements Runnable, KeyListener {
        Model m;
        View v;
        public Controller(Model mod,View vie){
            m = mod;
            v = vie;
            this.setLayout(new BorderLayout());
            JTextField field = new JTextField();
            field.addKeyListener(this);
            this.setPreferredSize(new Dimension(300,300));
            this.add(new JLabel("Hier steuern!"));
            this.add(field, BorderLayout.CENTER);
            this.setVisible(true);
        }

        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_UP){     //UP
                m.moveCursor('n');
            }else if(e.getKeyCode()==KeyEvent.VK_LEFT){   //LEFT
                m.moveCursor('w');
            }else if(e.getKeyCode()==KeyEvent.VK_DOWN){   //DOWN
                m.moveCursor('s');
            }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){  //RIGHT
                m.moveCursor('e');
            }else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
                m.selectTile(m.cursor[0],m.cursor[1]);
            }
            v.redraw();
        }

        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        public void run() {
            // TODO Auto-generated method stub

        }

    }
}
