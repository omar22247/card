import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Card> cards=Card.getStandardDeck();
        Card.PrintStandardDeck(cards);
    }
}
