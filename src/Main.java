import java.util.*;
import game.Controler;
import model.Card.Card;
public class Main {

    public static void main(String[] args) {
        Controler c=new Controler(3);
        Card.PrintStandardDeck(Card.getStandardDeck());
        c.playGame();
        c.playGame();
        c.playGame(3);
        c.playGame(4);
        c.playGame();


    }
}