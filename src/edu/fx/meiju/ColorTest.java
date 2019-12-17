package edu.fx.meiju;

/**
 * @author: Pxn
 * @date: 2019/12/16 21:51
 */
public class ColorTest extends Object{
   
    public static void main(String[] args) {
        Color color = Color.Blue;
        switch (color){
            case RED:
                color=Color.RED;
                break;
            case Blue:
                color=Color.Blue;
                System.out.println("当前颜色是："+color);
                break;
        }
    }
}
