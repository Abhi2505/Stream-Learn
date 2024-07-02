package com.leanStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDB {
    public static List<Employee> getEmployee(){
        List<Employee>emp=new ArrayList<>();
        for(int i=1;i<1000;i++){
            emp.add(new Employee(i,"Emp+"+i,'A',Double.valueOf(new Random().nextInt(1000))));
        }
        return emp;
    }
}
