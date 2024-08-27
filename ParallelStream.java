package com.leanStream;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ParallelStream {
    //sequential stream task are executed in 1 core sequentially so performace wise not good and keeping order of
    //execution maintained
    //to utilize mulitple cores in non ordered way we use parallel stream
    //Normally java code has one stream of processing where it is executed singally
    // Whereas by using the parallel streams we can divide the code into multiple streams that are executed in parallel
    // on separate cores and final result is combination of individual outcomes

    //normal stream execute in single thread and single core
    public static void main(String[] args) {

        long start=0;
        long end=0;
//        start=System.currentTimeMillis();
//        IntStream.range(1,1000).forEach(System.out::println);
//        end=System.currentTimeMillis();
//        System.out.println("plain stream took: "+(end-start));
//        System.out.println("====================");
//
//        start=System.currentTimeMillis();
//        IntStream.range(1,1000).parallel().forEach(System.out::println);
//        end=System.currentTimeMillis();
//        System.out.println("parallel stream took : "+(end -start));

//        IntStream.range(1,10).forEach(e->System.out.println(Thread.currentThread().getName()+" "+e));
//        IntStream.range(1,10).parallel().forEach(e->System.out.println(Thread.currentThread().getName()+" "+e));

    start=System.currentTimeMillis();
    List<Employee> l=EmployeeDB.getEmployee();
    Double avg=l.stream().map(e->e.getSalary()).mapToDouble(i->i).average().getAsDouble() ;
    end=System.currentTimeMillis();
    System.out.println("normal stream execution time "+(end-start)+" avg "+avg);
        start=System.currentTimeMillis();
        Double avgWithP=l.stream().parallel().map(e->e.getSalary()).mapToDouble(i->i).average().getAsDouble() ;
        end=System.currentTimeMillis();
        System.out.println("parallel stream execution time "+(end-start)+" avg is "+avgWithP);
//


    }

}
