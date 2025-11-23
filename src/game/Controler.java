package game;
import java.util.*;
import model.Card.Card;

public class Controler {
    private int NumOfplayer;
    private List<Card> deck;
    private final List<Card> ground = new ArrayList<>(4);
    private List<List<Card>> playersHand;

    public Controler(int NumOfplayer)  {
        if(NumOfplayer<2||NumOfplayer>6)
            throw new IllegalArgumentException("players must be from 2 to 6 ");
        IniatePlay(NumOfplayer);
    }
    public void IniatePlay(int NumOfplayer){
        this.NumOfplayer = NumOfplayer;
        this.deck = Card.getStandardDeck();
        playersHand = new ArrayList<>(NumOfplayer);
        for(int i=0;i<this.NumOfplayer;i++){
            playersHand.add(new ArrayList<>());
        }
    }
    public int NoOfRounds(){
        int Cardsneeded=NumOfplayer*4+4;
        return (int) Math.ceil(52.0/Cardsneeded);
    }
    public void playGame(){
        Collections.shuffle(this.deck);
        for (int i = 0; i < NoOfRounds(); i++) {
            NextRound();
            remainingCards();
        }
        this.deck.clear();
        this.deck = Card.getStandardDeck();
        ground.clear();
        clearPlayerHands();
    }
    public void playGame(int y){
        Changeplayers(y);
        playGame();
    }
    private void Changeplayers(int NumOfplayer){
        if(NumOfplayer<2||NumOfplayer>6)
            throw new IllegalArgumentException("players must be from 2 to 6 ");

        IniatePlay(NumOfplayer);
    }
    private void clearPlayerHands(){
        for (List<Card> hand : playersHand) {
            hand.clear();
        }
    }
    private void NextRound(){
        System.out.println("--------------------------");
        clearPlayerHands();
        System.out.println("new round");
        DistributingCards();
        DisplayPlayerHands();
        DistributingGroundCards();
        System.out.println("--------------------------");

    }
    private void remainingCards(){
        System.out.println("remaining cards = "  + deck.size());
    }
    private void DisplayPlayerHands(){
        for(int i = 0; i < NumOfplayer; i++){
            System.out.println("player "+ (i+1) + " : " +playersHand.get(i));
        }

    }
    private void DistributingOneCardForPlayer(){
        for(int j = 0; j < NumOfplayer; j++){
            playersHand.get(j).add(deck.remove(0));
        }
    }
    private void DistributingCards(){
        for(int j = 0; j < 4; j++){
            if(deck.size()<NumOfplayer){
                return;
            }
            DistributingOneCardForPlayer();
        }
    }
    private void DistributingGroundCards(){
        ground.clear();
        System.out.println("Ground Cards");
        int groundCards = Math.min(4, deck.size());
        for(int i = 0; i < groundCards; i++){
            ground.add(deck.remove(0));
        }
        System.out.println(ground);
    }

}
