package com.epam.rd.autocode.startegy.cards;

import java.util.*;

public class ImplementationService implements CardDealingStrategy{

    private final int cardsPerPlayer;

    private final boolean isCommunity;

    private final boolean isTrumpCard;

    public ImplementationService(int cardsPerPlayer, boolean isCommunity, boolean isTrumpCard) {
        this.cardsPerPlayer = cardsPerPlayer;
        this.isCommunity = isCommunity;
        this.isTrumpCard = isTrumpCard;
    }

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        TreeMap<String, List<Card> > map = new TreeMap<>();

        for (int i = 0; i < players; i++) {
            map.put("Player "+(i+1),new ArrayList<Card>());
        }

        int k = 0;
        int count = 0;

        for (int size = deck.size() - 1; size >= 0; size--) {

            if (count<players*cardsPerPlayer){
                List<Card> cards = map.get("Player " + (k%players+1));
                cards.add(new CardImpl1(size));
                k++;
            }else if (isCommunity && count<players*2+5){
                List<Card> community = map.get("Community");
                if (Objects.isNull(community)){
                    map.put("Community",new ArrayList<Card>());
                    community = map.get("Community");
                }
                community.add(new CardImpl1(size));
            } else if (isTrumpCard && count==players*cardsPerPlayer) {
                ArrayList<Card> cards = new ArrayList<>();
                cards.add(new CardImpl1(size));
                map.put("Trump card",cards);
                map.get("Trump card");
            } else {
                List<Card> remaining = map.get("Remaining");
                if (Objects.isNull(remaining)){
                    map.put("Remaining",new ArrayList<Card>());
                    remaining = map.get("Remaining");
                }
                remaining.add(new CardImpl1(size));
            }
            deck.dealCard();
            count++;
        }

        return map;
    }
}
