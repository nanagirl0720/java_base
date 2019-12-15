package edu.fx.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: Pxn
 * @date: 2019/11/6 20:14
 */
public class People implements Observer {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People(String name) {
        this.name = name;
    }

    public People() {
    }

    public static void main(String[] args) {
        House house = new House("绿地", 20000);
        People people = new People("娜娜");
        System.out.println("**************");
        house.addObserver(people);
        house.setPrice(21000);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
        System.out.println("您好，"+this.name+"，我知道了现在的房子"+((House)o).getName()+"变成了"+arg+"元了");
    }

}
