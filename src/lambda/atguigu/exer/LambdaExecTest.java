package lambda.atguigu.exer;

import org.junit.Test;

public class LambdaExecTest {

    @Test
    public void test1(){
     String s = "lzw";
     s = trans(s, (x -> x.toUpperCase()));
     System.out.println(s);
    s = trans("明月几时有，把酒问青天", (x -> x.substring(2,5)));
    System.out.println(s);
    }

    /**
     * 计算2个long的和，计算2个long的积
     * @return
     */
    @Test
    public void test2(){
        calNumber(10, 10, (x1, x2) -> x1 + x2);
        calNumber(10, 10, (x1, x2) -> x1 * x2);
        calNumber(10, 10, new Calculate<Long, Long>() {
            @Override
            public Long cal(Long t1, Long t2) {
                return t1/t2;
            }
        });
    }

    public void calNumber(long n1, long n2, Calculate<Long, Long> calculate){
        System.out.println(calculate.cal(n1, n2));
    }



    public String trans(String s, MyFunction my){
       return my.transfer(s);
    }
}
