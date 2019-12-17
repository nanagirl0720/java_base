package edu.fx.meiju;

/**
 * @author: Pxn
 * @date: 2019/12/16 20:48
 */

/**
 * 枚举练习：举例子（确定、有限）
 */
enum   Color implements ColorInterface{
    RED("红色",1),Blue("蓝色",2),Black("黑色",3);

    private String name;
    private int index;

    //构造方法
    private Color(String name,int index){
        this.name=name;
        this.index=index;
    }

    //声明方法
    public static String getName(int i){
        for (Color c: Color.values()) {
            if(c.getIndex()==i){
               return c.getName();
            }
        }
        return null;
    }

    @Override
    public void print() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

}
