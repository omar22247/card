import java.util.*;
import game.Controler;
import model.Card.Card;
public class Main {

    public static void main(String[] args) {
        Controler c=new Controler(5);
        Card.PrintStandardDeck(Card.getStandardDeck());
        c.play();
        c.play();
        c.play(3);

    }
}