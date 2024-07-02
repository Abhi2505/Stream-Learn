package com.leanStream;

import java.util.function.Predicate;

public class PredicateFunctionDemo {
    //predicate is a predefined functional interface (having only 1 abstract and any no of default and static methods)
    // in java . the only abstract method is public boolean test(T t) . Is used in stream .filter(()->condition);
    public static void main(String[] args) {
        Predicate<String> p=(String s)->s.length()>4;
        //input to predicate can be anything Predicate<String>,Predicate<Employee> return type for predicate is always boolean
        //code reusability is one of the advantage of using the predicate
        System.out.println(p.test("rajendra"));
        System.out.println(p.test("raju"));
        //what is predicate joining
        //if we want to aggregate mulitple prdeicate to get a single output then we can chain them and use
        //Three ways to join 1) ANd 2) Or 3) Negate
        Predicate<String>checklength=(String s)->s.length()>3;
        Predicate<String>checkEvenLength=(String s)->s.length()%2==0;
        System.out.println(checklength.and(checkEvenLength).test("om"));
        System.out.println(checklength.negate().test("om"));
        System.out.println(checklength.or(checkEvenLength).test("ramesh"));
    }
}
