import java.util.*;
import game.controler;
import model.Card.Card;
public class Main {

    public static void main(String[] args) {
        controler c=new controler(5);
        Card.PrintStandardDeck(Card.getStandardDeck());
        c.play();
        c.play();
        c.play(3);

    }
}