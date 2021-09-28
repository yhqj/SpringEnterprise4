package com.yheqj.chapter4.ioc;

public class MoAttack {
    private Geli geli;

    //根据构造函数 传入革离的具体表演者
    public MoAttack(Geli geli) {
        this.geli = geli;
    }

    public void cityGateAsk(){
        geli.responseAsk("墨者革离");
    }

    //属性注入方法
    public void setGeli(Geli geli){
        this.geli = geli;
    }

    //接口注入的方式在实际开发中基本没有遇到过 暂时忽略
}
