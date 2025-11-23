package game;
import java.util.*;
import model.Card.Card;

public class  Controler {
    private int NumOfplayer;
    private List<Card> deck;
    private List<Card> ground = new ArrayList<>(4);
    private List<List<Card>> players = new ArrayList<>(4);

    public Controler(int NumOfplayer)  {
            if(NumOfplayer<2||NumOfplayer>6)
                throw new IllegalArgumentException("players must be from 2 to 6 ");

            this.NumOfplayer = NumOfplayer;
            this.deck = Card.getStandardDeck();
            for(int i=0;i<this.NumOfplayer;i++){
                players.add(new ArrayList());
            }
    }
    //game play
    public void play(){
        int Cardsneeded=NumOfplayer*4+4;
        int x=(int) Math.ceil((float)52/Cardsneeded);
        StartGame();
        for (int i = 0; i < x; i++) {
            NextRoud();
            remaining();
        }
        this.deck.clear();
        this.deck = Card.getStandardDeck();
    }
    public void play(int y){
        Changeplayers(y);
        play();
    }

    private void Changeplayers(int NumOfplayer){
        if(NumOfplayer<2||NumOfplayer>6)
            throw new IllegalArgumentException("players must be from 2 to 6 ");

        this.NumOfplayer = NumOfplayer;
        this.deck = Card.getStandardDeck();
        players.clear();
        for(int i=0;i<NumOfplayer;i++){
            players.add(new ArrayList());
        }
    }
    private void StartGame(){
        Collections.shuffle(this.deck);
    }
    private void clearPlayerHands(){
        for(int i=0;i<this.NumOfplayer;i++){
            this.players.get(i).clear();
        }
    }
    private void remaining(){
        System.out.println("remaining cards = "  + deck.size());
    }
    private void DisplayPlayerHands(){
        for(int i = 0; i < NumOfplayer; i++){
            System.out.println("player "+ (i+1) + " : " +players.get(i));
        }

    }

    private void NextRoud(){
        System.out.println("--------------------------");
        clearPlayerHands();
        System.out.println("new round");
        DistributingCardsforPlayer();
        DisplayPlayerHands();
        DistributingGroundCards();
        System.out.println("--------------------------");

    }

    private void DistributingCards(){
            for(int j = 0; j < NumOfplayer; j++){
                players.get(j).add(deck.remove(0));
            }
    }
    private void DistributingCardsforPlayer(){
            for(int j = 0; j < 4; j++){
                if(deck.size()<NumOfplayer){
                    break;
                }
                DistributingCards();
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
