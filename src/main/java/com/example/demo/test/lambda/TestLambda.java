package com.example.demo.test.lambda;

import com.example.demo.pojo.Hero;
import com.example.demo.service.HeroChecker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLambda {
    private List<Hero> list = new Hero ().getHeros ();
    public static void main(String[] args) {
        List<Hero> list = new Hero ().getHeros ();
        System.out.println (list.toString ());
        // filter (list);
        HeroChecker heroChecker = new HeroChecker () {
            @Override
            public boolean test(Hero h) {
                return (h.hp>100 && h.damage<50);
            }
        };
        // 把new HeroChcekcer，方法名，方法返回类型信息去掉
        // 只保留方法参数和方法体
        // 参数和方法体之间加上符号 ->
        HeroChecker c2 = (Hero h) -> {
            return h.hp > 100 && h.damage < 50;
        };

        // 把return和{}去掉
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;

        // 把 参数类型和圆括号去掉
        HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;

        // 把c4作为参数传递进去
        // filter2(list, c4);

        // 直接把表达式传递进去
        // filter2(list, h -> h.hp > 100 && h.damage < 50);
        HeroChecker heroChecker1 = h -> h.hp>100 && h.damage<50;
        // filter2 (list,heroChecker);
        // filter2 (list,heroChecker1);
        //引入Comparator，指定比较的算法
        Comparator<Hero> c = (h1, h2) -> {
            //按照hp进行排序
            if(h1.hp>=h2.hp)
                return 1;  //正数表示h1比h2要大
            else
                return -1;
        };
        Comparator<Hero> c1 = (h1,h2) -> h1.hp>=h2.hp?1:-1;

        // Collections.sort(list,c1);

        Collections.sort(list,Hero::compareTo);

        Hero hero = new Hero ();
        System.out.println (list.toString ());
    }

    @Test
    public void test1(){
        System.out.println (list.toString ());
        // filter2 (list,h->h.hp>100&h.damage<50);
        // filter2 (list,h->TestLambda.testHero (h));
        // filter2 (list,TestLambda::testHero);
    }

    @Test
    public void test2(){
        System.out.println (list.toString ());
        TestLambda testLambda = new TestLambda ();
        filter2 (list,testLambda::testHero);
    }

    @Test
    public void test3(){
        System.out.println (list.toString ());
        // filter2 (list,h->h.matched ());
        filter2 (list,Hero::matched);
    }

    @Test
    public void test4() {
        System.out.println (list.toString ());
        for (Hero h : list) {
            if (h.hp > 100 && h.damage < 50)
                System.out.println (h.name);
        }
        list.stream ().filter (h -> h.hp > 100 && h.damage < 50).forEach (h -> System.out.println (h.name));
    }

    /**
     * 使用一个普通方法，在for循环遍历中进行条件判断，筛选出满足条件的数据
     * hp>100 && damage<50
     * @param list
     */
    public static void filter(List<Hero> list){
        for (Hero hero : list) {
            if (hero.hp>100&&hero.damage<50){
                System.out.println (hero);
            }
        }
    }

    public void filter2(List<Hero> list,HeroChecker HeroChecker){
        for (Hero hero : list) {
            if (HeroChecker.test (hero)){
                System.out.println (hero);
            }
        }
    }

    public boolean testHero(Hero h) {
       return h.hp>100 && h.damage<50;
    }

    public static List getList(Supplier<List> s){
      return s.get();
    }
}
