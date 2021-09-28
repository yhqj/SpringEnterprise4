package com.yheqj.chapter4.ioc;

public class Director {
    public void director() {
        Geli geli = new LiuDeHua();

        MoAttack moAttack = new MoAttack(geli);
        moAttack.cityGateAsk();
    }
}
