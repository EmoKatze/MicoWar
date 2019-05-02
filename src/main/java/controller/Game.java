package controller;

import model.player.Player;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private int moveCount;


    public static void main(String[] args) {

    }

    public void controllFlow() {
        while (true) {

            //TODO: Game round logic
        }
    }

    public void changeActivePlayer() {
        playerOne.setActive(!playerOne.isActive());
        playerTwo.setActive(!playerTwo.isActive());
    }

    //TODO: Input --> Action --> Actualization --> Output --> Round change

    //TODO: API for get-information for View
}
