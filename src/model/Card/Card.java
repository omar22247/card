package model.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    public record Card(Suit suit, String face, int rank) {
        public enum Suit{
            CLUB(9827), DIAMOND(9830), HEART(9829), SPADE(9824);
            private char symbol;
            Suit(int codePoint) {
                this.symbol = (char) codePoint;
            }
            public char getSymbol() {
                return symbol;
            }
        }
        @Override
        public String toString() {
            String displayFace = face.length() == 1 ? face : face.substring(0); // This is redundant
            return "%s%c(%d)".formatted(displayFace,suit.getSymbol(),rank);
        }
        public static Card getNumericCard(Suit suit, int CardNum){
            if (CardNum >= 2 && CardNum <= 10){
                return new Card( suit,String.valueOf(CardNum),CardNum-2);
            }
            System.out.println("Invalid Card number");
            return null;
        }
        public static Card getFaceCard(Suit suit, char face){
            int index="JQKA".indexOf(face);
            if(index<0){
                System.out.println("Invalid face");
                return null;
            }
            return new Card( suit,""+face,index+9);

        }
        public static List<Card> getStandardDeck(){
            List<Card> Cards=new ArrayList<>(52);
            for(Suit suit:Suit.values()){
                for (int i=2;i<=10;i++){
                    Cards.add(getNumericCard(suit,i));
                }
                //new char[]
                for(char c :List.of('J','Q','K','A')){
                    Cards.add(getFaceCard(suit,c));
                }
            }
            return Cards;
        }
        public static void PrintStandardDeck(List<Card> Cards, String description, int rows) {
            System.out.println("==========================");
                System.out.println((description != null)?description : "Current Deck");
            System.out.println("-----------------------------");
            int CardsInRow = (int) Math.ceil((float)Cards.size() / rows);

            for (int i = 0; i < Cards.size(); i++) {
                System.out.printf("%-10s", Cards.get(i));
                if((i+1)%CardsInRow==0){
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("==========================");
        }
        public static void PrintStandardDeck(List<Card> Cards) {
            PrintStandardDeck(Cards,"Current Deck",4);
        }

    }


