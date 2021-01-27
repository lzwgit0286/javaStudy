package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class genericTest {
    /**
     * 理解为G<?>是G<A>,G<B>的共同父类
     */
    @Test
    public void test(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<String> list2 = Arrays.asList("a","b","c");
        List<?> list = list1;
        list = list2;
        Object o = (String)list.get(0);
        print(list1);
        print(list2);
//        print(list);
    }

    /**
     * 协变和逆变
     */
    @Test
    public void test2(){
        List<? extends Person> pigs = new ArrayList<Student>();

        List<? super Student> list = new ArrayList<Student>();
        Object o = list.get(0);
        list.add(new Student());
//        list.add(new Person());
    }


    public void print(List<?> list){
       Iterator<?> iterator = list.iterator();
       while (iterator.hasNext()){
            Object t = iterator.next();
           System.out.println(t);
       }

    }
}
