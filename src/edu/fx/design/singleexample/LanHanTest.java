package edu.fx.design.singleexample;

/**
 * @author: Pxn
 * @date: 2019/12/22 21:18
 */
public class LanHanTest {
}
class SingleExample{
    private SingleExample(){}
    private static SingleExample singleExample=null;
    public SingleExample getInstance(){
        if (singleExample==null){
            singleExample= new SingleExample();
        }
        return singleExample;
    }
}
class LanHanSimple{
    private LanHanSimple(){}
    private static LanHanSimple lanHanSimple;
    public static  LanHanSimple getLanHanSimple(){
        if (lanHanSimple==null){
            synchronized(LanHanSimple.class){
                if (lanHanSimple==null){
                    lanHanSimple=new LanHanSimple();
                }
            }
        }
        return lanHanSimple;
    }
}
