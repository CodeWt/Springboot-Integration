package com.example.demo.model.abstractfactory;

public class AmericaFactory extends AbstractFactory {
    @Override
    public ClothesBrand createClothesBrand() {
        return new Nike();
    }

    @Override
    public PhoneBrand createPhoneBrand() {
        return new Iphone("iphone 13");
    }

    private AmericaFactory(){}
    private static volatile AmericaFactory INSTANCE;
    public static AmericaFactory getFactory(){
        if (INSTANCE==null){
            synchronized (AmericaFactory.class){
                if (INSTANCE==null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new AmericaFactory();
                }
            }
        }
        return INSTANCE;
    }

}
