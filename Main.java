package com.leanStream;

import java.util.ArrayList;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // In stream we have to type of operations
    //Intermediate and terminal operation
    //Intermediate : map(), filter(), distinct(), sorted(), limit(), skip()
    //Terminal : forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()
    public static void main(String[] args) {

        //find and print duplicate numbers in an array if it contains multiple duplicates
        int ar[]={1,2,3,2,1,5,6};
        //grouping applies on oobject so we use boxed
        Arrays.stream(ar).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting())).entrySet().stream().filter(e->e.getValue()>1).forEach(System.out::println);

        //given a list of names rgoup them by their first letter and count the number of names in each group
        String names[]={"Abhi","Ram","Bill","Ajay","Bansi"};
        Map<Character,Long>map=Arrays.stream(names).collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));

        //given a list of words filter and print palindromes
        List<String>words=List.of("malam","anjo","olo","se");
        List<String>palind=words.stream().filter(w->w.equals(new StringBuilder(w).reverse().toString())).collect(Collectors.toList());
        System.out.println(palind);
        //find the frequ of each character in a string
        String word="rajatra";
        Map<Character,Long>mapa=word.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(mapa);

        //sort map basd on value
        LinkedHashMap<Integer,String>lh=new LinkedHashMap<>(16,0.50f,true);
        lh.put(1,"one");
        lh.put(2,"two");
        lh.put(4,"four");
        lh.get(2);
        System.out.println(lh); //2 would move to end of linked list
        Map<String, Integer> hm = new HashMap<>();
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);
        hm.put("d", 4);
        hm.put("a", 5);
        //System.out.println(hm);
        Map<String, Integer> temp = hm.entrySet().stream().sorted((i1,i2)->{
            return i1.getValue()-i2.getValue();
        }).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),(e1,e2)->e2,LinkedHashMap::new));

        System.out.println(temp);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Student s1=new Student(1,"abhi","Mechanical",234,"Male" ,21,Arrays.asList("9340345","21213312332"));
        Student s2=new Student(2,"ravi","Computer", 43,"Female",15,Arrays.asList("329340345","21213312423"));
        Student s3=new Student(3,"kavi","Computer", 10,"Male",34,Arrays.asList("9332340345","21213311223"));
        Student s4=new Student(4,"raki","Electrical", 521,"Male",64,Arrays.asList("9424340345","2121323123"));
        Student s5=new Student(5,"ajobhi","Electrical", 1,"Female",43,Arrays.asList("934242q40345","2132133123"));
        Student s6=new Student(6,"haihi","Mechanical",32, "Male",22,Arrays.asList("9323140345","2123133123"));
        Student s7=new Student(7,"rpmi","Mechanical", 545,"Female", 32,Arrays.asList("93403232345","2312133123"));
        Student s8=new Student(8,"rwmi","Electrical", 53,"Female",21, Arrays.asList("3493403232345","2312133123"));
        Student s9=new Student(9,"wapmi","Electrical", 353,"Male",22,Arrays.asList("341293403232345","2312133123"));

        //if we have a map of name and student
        HashMap<String,Student>hmp=new HashMap<>();
        hmp.put(s1.getName(),s1);
        hmp.put(s2.getName(),s2);
        hmp.put(s3.getName(),s3);
        hmp.put(s4.getName(),s4);
        List<Student>ans=hmp.entrySet().stream().map(Map.Entry::getValue).filter(s->s.rank>40).collect(Collectors.toList());
        System.out.println(ans+" ----------- ");
       List<Student>l=new ArrayList<Student>();

        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);
        l.add(s6);
        l.add(s7);
        l.add(s8);
        l.add(s9);

        //we need a map which shows pass students and fail student pass are the one whose rank <40 and others are fail
        Map<String,List<Student>>result=l.stream().collect(Collectors.groupingBy(s->s.rank<40?"Pass":"Fail"));
        System.out.println(result);
        //In the collectors.tomap function we have the argument as  keyMapper ,valueMapper,mergetfunction in case of repeated key ,map in which the value is inserted
        //need to form a map from list of students having key as dept and value as the id of first student haveing that specific department
        HashMap<String,Integer>hmap=l.stream().collect(Collectors.toMap(Student::getDept,Student::getId,(v1,v2)->v1,LinkedHashMap::new));
        System.out.println(hmap);

        //finc students with duplicate subjects
        List<Integer>mylist=Arrays.asList(1,2,3,4,2,4,2,4,6,7,1);
        HashSet<Integer>dup=new HashSet<Integer>();
        List<Integer>duplicates=mylist.stream().filter(s->!dup.add(s)).collect(Collectors.toList());
        System.out.println(duplicates);
        //1) find the list of student who have the rank in between 10 to 200
        List<Student>withRankFilter=l.stream().filter((s)->s.getRank()>10 && s.getRank()<200).collect(Collectors.toList());
        System.out.println(withRankFilter);
        //2) find the list of student working in cs department in sort order of theri name
        List<Student>list=l.stream().filter((s)->s.getDept().equals("Computer")).sorted((a1, a2)->a1.getName().compareTo(a2.getName())).collect(Collectors.toList());
        System.out.println(list);
        //3) find all the department names
        List<String>departments=l.stream().map((s)->s.getDept()).distinct().collect(Collectors.toList());
        System.out.println(departments);
        //4) find all contactnumbers
        List<String>contact=l.stream().flatMap((s)->s.getContact().stream()).collect(Collectors.toList());
        System.out.println(contact);
        //5) group the students by the department name
        Map<String,List<Student>>std=l.stream().collect(Collectors.groupingBy(Student::getDept));
        System.out.println(std);
        //6) if we the count of students along with the departmenat name
        Map<String,Long>stdnt=l.stream().collect(Collectors.groupingBy((s)->s.getDept(),Collectors.counting()));
        System.out.println(stdnt);
        //7) the max student present in which department
        Map.Entry<String,Long>e=l.stream().collect(Collectors.groupingBy((s)->s.getDept(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(e);
        //8) find the average age of mail and femail
        Map<String,Double>avg=l.stream().collect(Collectors.groupingBy((stt)->stt.getGender(),Collectors.averagingInt((ss)->ss.getAge())));
        System.out.println(avg);
        //9) find the highest rank(min value) in each department
        Map<String,Optional<Student>>info=l.stream().collect(Collectors.groupingBy((s)->s.getDept(),Collectors.minBy((e1, e2)->e1.getRank()-e2.getRank())));
        //Collectors.minBy(Comparator.comparing(Student::getRank());
        System.out.println(info);
        //10) find the student who has the second rank
        List<Student>secrank=l.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).limit(1).collect(Collectors.toList());
        System.out.println(secrank);
    }
}