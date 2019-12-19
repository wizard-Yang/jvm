package main.per.sjyang.垃圾收集器和内存分配策略.对象4种引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author saijun.yang
 * @date Created in 2019/12/16 19:39
 * @description 对象的四种引用
 */
public class RenferenceFour {
    public static void main(String[] args) {
        //强引用
        Person p = new Person();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        //软引用(必要时，p会被设置为null,即p = null;)
        SoftReference<Person> softReference = new SoftReference<Person>(p1);
        //弱引用
        WeakReference<Person> weakReference = new WeakReference<Person>(p2);
        //虚引用
        PhantomReference<Person> personPhantomReference = new PhantomReference<Person>(p3, new ReferenceQueue<Person>());
    }
}
class Person{
    String name = "sjyang";
}
