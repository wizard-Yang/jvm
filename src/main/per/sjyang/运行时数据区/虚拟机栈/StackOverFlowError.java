package main.per.sjyang.运行时数据区.虚拟机栈;

/**
 * @author saijun.yang
 * @date Created in 2019/12/11 14:15
 * @description 虚拟机栈当线程申请栈深度大于虚拟机允许的深度
 * VM Args：-Xss128k
 */
public class StackOverFlowError {
    private int num = 1;
    public void digui(){
        num ++;
        digui();
    }
    public static void main(String[] args) {
        StackOverFlowError stackOverFlowError = new StackOverFlowError();
        try {
            stackOverFlowError.digui();
        } catch (Exception e) {
            System.out.println("计算结果："+stackOverFlowError.num);
            e.printStackTrace();
        }

    }

}
