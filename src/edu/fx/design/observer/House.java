package edu.fx.design.observer;

import java.util.Observable;

/**
 * @author: Pxn
 * @date: 2019/11/6 20:19
 */
public class House extends Observable {
    String name;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.setChanged();//我改变了
        this.price=price;
        this.notifyObservers(price);//我改变了的值告诉你
    }

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public House(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
