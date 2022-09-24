package com.epam.rd.autocode.startegy.cards;


public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new ImplementationService(2,true,false);
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new ImplementationService(5,false,false);
    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
        return new ImplementationService(13,false,false);
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return new ImplementationService(6,false,true);
    }


}

