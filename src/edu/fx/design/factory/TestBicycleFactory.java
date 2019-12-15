package edu.fx.design.factory;

/**
 * @author: Pxn
 * @date: 2019/11/6 21:51
 */
public class TestBicycleFactory {

    public static Bicycle createBicycle(String bicycle) {
        Bicycle bicycle1 = null;
        if ("Haluo".equals(bicycle)) {
            bicycle1 = new Haluo();
        } else if ("MoBai".equals(bicycle)) {
            bicycle1 = new MoBai();
        } else if ("XiaoHuangChe".equals(bicycle)) {
            bicycle1 = new XiaoHuangChe();
        }else {
            System.out.println("目前没有可以骑的自行车了！");
        }
        return  bicycle1;
        }

    public static void main(String[] args) {
        Bicycle bicycle = createBicycle("Haluo");
        System.out.println(bicycle.getClass().getName());
    }
}
