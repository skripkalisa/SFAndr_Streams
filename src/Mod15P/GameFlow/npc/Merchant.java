package Mod15P.GameFlow.npc;

import Mod15P.Players.Seller;

public class Merchant implements Seller {
    ///Метод для продажи
    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            result = "potion";
        }
        return result;
    }
    ///Энам для товаров
    public enum Goods {
        POTION
    }
}
