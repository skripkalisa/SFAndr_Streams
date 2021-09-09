package Mod15P.GameFlow;

import Mod15P.Players.FantasyCharacter;
import Mod15P.GameFlow.player.Hero;


public class BattleScene {
    //Метод, который вызывается при начале боя, сюда мы передаем ссылки на нашего героя и монстра, который встал у него на пути
    public void fight(FantasyCharacter hero, FantasyCharacter monster, Realm.FightCallback fightCallback) {
        //Ходы будут идти в отдельном потоке
        Runnable runnable = () -> {
            //Сюда будем записывать какой сейчас ход по счету
            int turn = 1;
            //Когда бой будет закончен мы
            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("----Ход: " + turn + "----");
                //Воины бьют по очереди, поэтому здесь мы описываем логику смены сторон
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(monster, hero, fightCallback);
                } else {
                    isFightEnded = makeHit(hero, monster, fightCallback);
                }
                try {
                    //Чтобы бой не проходил за секунду, сделаем имитацию работу, как если бы
                    //у нас была анимация
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //Запускаем новый поток
        Thread thread = new Thread(runnable);
        thread.start();
    }
    //Метод для совершения удара
    private Boolean makeHit(FantasyCharacter defender, FantasyCharacter attacker, Realm.FightCallback fightCallback) {
        //Получаем силу удара
        int hit = attacker.attack();
        //Отнимаем количество урона из здоровья защищающегося
        int defenderHealth = defender.getHealthPoints() - hit;
        //Если атака прошла, выводим в консоль сообщение об этом
        if (hit != 0) {
            System.out.printf("%s Нанес удар в %d единиц!%n", attacker.getName(), hit);
            System.out.printf("У %s осталось %d единиц здоровья...%n", defender.getName(), defenderHealth);
        } else {
            //Если атакующий промахнулся(то есть урон не 0) выводим это сообщение
            System.out.printf("%s промахнулся!%n", attacker.getName());
        }
        if (defenderHealth <= 0 && defender instanceof Hero) {
            //Если здоровье меньше 0 и если защищающейся был героем, то игра заканчивается
            System.out.println("Извините, вы пали в бою...");
            //Вызываем коллбэк, что мы проиграли
            fightCallback.fightLost();
            return true;
        } else if(defenderHealth <= 0) {
            //Если здоровья больше нет и защищающийся это монстр, то мы забираем от монстра его опыт и золото
            System.out.printf("Враг повержен! Вы получаете %d опыт и %d золота%n", defender.getXp(), defender.getGold());
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            //вызываем коллбэк, что мы победили
            fightCallback.fightWin();
            return true;
        } else {
            //если защищающийся не повержен, то мы устанавливаем ему новый уровень здоровья
            defender.setHealthPoints(defenderHealth);
            return false;
        }
    }
}
