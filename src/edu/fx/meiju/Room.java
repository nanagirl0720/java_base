package edu.fx.meiju;

/**
 * @author: Pxn
 * @date: 2019/12/16 22:20
 */
enum  Room {
    Sofa("沙发"),Table("桌子"),Bed("床");

    private final String name;

    public String getName() {
        return name;
    }

    private  Room(String name) {
        this.name = name;
    }
}
