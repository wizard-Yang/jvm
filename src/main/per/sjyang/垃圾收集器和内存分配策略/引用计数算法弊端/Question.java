package main.per.sjyang.垃圾收集器和内存分配策略.引用计数算法弊端;

/**
 * @author saijun.yang
 * @date Created in 2019/12/13 15:30
 * @description 对象循环相互引用问题
 */
public class Question {
    public Object question = null;

    /**
     * a.question = b;这行b被a引用，计数器为1，同时question也引用了b，此时计数器为2
     * 同理a的计数器也为2
     * a = null;这句话a计数器减去1，结果为1
     * b = null;b的结果也为1
     * 所以a和b永远不会被回收。
     */
    public static void testGC(){
        Question a = new Question();
        Question b = new Question();
        a.question = b;
        b.question = a;
        a = null;
        b = null;
        System.gc();
    }
}
