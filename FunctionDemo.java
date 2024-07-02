package com.leanStream;

import java.util.function.Function;

public class FunctionDemo {
    //Function is also a predefined Functional interface having only one abstract method
    //the only abstract method of function demo is apply(T t)
    //it takes one input and reutnr one output ie not of fixed specific type like in case of predicate
    //Function<Integer,Integer> in generic we define input, output data type
    //just like predicate join we have
    //what is functional chaining
    //2 ways for functional chaining
    //1) and then
    //2) compose
    public static void main(String[] args) {
        Function<Integer,Integer> squareme= i->i*i;
        System.out.println(squareme.apply(5));
        Function<Integer,Integer>doubleit=i->i*2;
        System.out.println("double value "+doubleit.apply(4));
        Function<Integer,Integer>cubeit=i->i*i*i;
        System.out.println("cube value is "+cubeit.apply(4));
        System.out.println("first double then cube "+ doubleit.andThen(cubeit).apply(3));
        System.out.println("first cubing "+ doubleit.compose(cubeit).apply(2));
        //multiple function can be changed together also like f1.andThen(f2).andThen(f3)

    }
}
