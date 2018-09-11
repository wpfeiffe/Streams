import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import static java.util.stream.Collectors.toList;

public class HelloJava9Main
{
    public static void main(String[] args)
    {
//        System.out.println("This is a test");
//        System.out.println("Hello Java 9");
//
//        Thread th = new Thread(new Runnable()
//        {
//            public void run()
//            {
//                System.out.println("In another thread");
//            }
//        });
//
//        Thread th2 = new Thread(() -> System.out.println("In another thread 2"));
//
//        th.start();
//
//        th2.start();
//
//        System.out.println("In the main thread");
        loopPrint(args);
    }

    public static void loopPrint(String[] args)
    {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        for (int i = 0; i < numbers.size(); i++)
//        {
//            System.out.println("The value at " + i + " is " + numbers.get(i));
//        }
//
//        int j = 0;
//        for (int number : numbers)
//        {
//
//            System.out.println("The value at " + j + " is " + number);
//            j++;
//        }

//        numbers.forEach(value -> System.out.println("The value at is " + value));
//        numbers.forEach(System.out::println);
//        numbers.forEach(HelloJava9Main::formatInt);
//
//        numbers.stream()
//                .map(String::valueOf)
//                .forEach(System.out::println);
//        numbers.stream()
//                .map(e -> String.valueOf(e))
//                .map(String::toString)
//                .forEach(System.out::println);
//
//        System.out.println(
//        numbers.stream()
//                .reduce(0, (total, e) -> Integer.sum(total, e)));

//        3.e.
//        System.out.println(
//        numbers.stream()
//                .reduce(0, Integer::sum));

//        3.e.iv
//        System.out.println(
//                numbers.stream()
//                .map(String::valueOf)
//                //.reduce("", (carry, str) -> carry.concat(str)));
//                .reduce("", String::concat));

//        3.f.
//        System.out.println(
//                numbers.stream()
//                        .filter(e -> e % 2 == 0)
//                        .mapToInt(e -> e * 2)
//                        .sum());

//        3.g. Parallel
//        TimeIt.code(() ->
//        System.out.println(
//                numbers.stream()
//                        .filter(e -> e % 2 == 0)
//                        .mapToInt(HelloJava9Main::compute)
//                        .sum()));
//
//        TimeIt.code(() ->
//        System.out.println(
//                numbers.parallelStream()
//                        .filter(e -> e % 2 == 0)
//                        .mapToInt(HelloJava9Main::compute)
//                        .sum()));


//        4 Streams

//        4.e,f. Reduce
//        System.out.println(
//                numbers.stream()
//                        .filter(e -> e % 2 == 0)
//                        .map(e -> e * 2.0)
//                        .reduce(0.0, (carry, e) -> carry + e));

//        4.f Sum
//        System.out.println(
//                numbers.stream()
//                        .filter(e -> e % 2 == 0)
//                        .mapToDouble(e -> e * 2.0)
//                        .sum());


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        // double the even values and put in a list

//        // wrong way!!  We are mutating doubleOfEven which might be shared by multiple threads, EVIL!!
//        List<Integer> doubleOfEven = new ArrayList<>();
//        numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .map(e -> e * 2)
//                .forEach((e -> doubleOfEven.add(e)));

//        System.out.println(doubleOfEven);

//        4.f.ii collect reducer outputing to different collection type List, Set
//        List<Integer> doubleOfEven =
//            numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .map(e -> e * 2)
//                .collect(toList());
//
//        System.out.println(doubleOfEven);

//        Set<Integer> doubleOfEven =
//            numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .map(e -> e * 2)
//                .collect(Collectors.toSet());
//
//        System.out.println(doubleOfEven);

        List<Person> people = createPeople();

//        // 4.f.e
//        // create a Map with name and age as key, and the person as value
//        System.out.println(
//                people.stream()
//                        .collect(Collectors.toMap(
//                                person -> person.getName() + "-" + person.getAge(),
//                                person -> person
//                        )));

//        4.f.v
//        // create a Map where name if the key and value is all the people with that name
//        System.out.println(
//                people.stream()
//                        .collect(Collectors.groupingBy(Person::getName))); // groupingBy does the work of creating the map of lists, each list of objects for a person by name

//         create a Map where name if the key and value is all the people with that name
//        System.out.println(
//                people.stream()
//                        .collect(Collectors.groupingBy(Person::getName,
//                                mapping(Person::getAge, toList())))); // groupingBy does the work of creating the map of lists, each list of objects for a person by name


//        Given and ordered list, find the double of the first even number greater than 3
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20);
//
//        int result = 0;
//
//        for (int e : numbers) {
//             if (e > 3 && e % 2 == 0)
//             {
//                 result = e * 2;
//                 break;
//             }
//        }
//        System.out.println(result);
//
        System.out.println(
        numbers.stream()
                .filter(HelloJava9Main::isGT3)
                .filter(HelloJava9Main::isEven)
                .map(HelloJava9Main::doubleIt)
                .findFirst());

//        System.out.println(
//            Stream.iterate(100, e -> e + 1));

//        int k = 121;
//        int n = 51;
//
//        System.out.println(computNk(k, n));


    }

    public static int computNk(int k, int n) {
//        int result = 0;
//        int index = k;
//        int count = 0;
//        while(count < n)
//        {
//            if (index % 2 == 0 && Math.sqrt(index) > 20)
//            {
//                result += index * 2;
//                count++;
//            }
//
//            index++;
//        }
//        return result;

        return Stream.iterate(k, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(n)
                .sum();
    }

    
    public static boolean isGT3(int number) {
        System.out.println("In the isGT3 method");
        return number > 3;
    }

    public static boolean isEven(int number) {
        System.out.println("In the isEven method");
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("In the doubleIt method");
        return number * 2;
    }

    public static void formatInt(Integer i)
    {
        System.out.println("The value is " + i);
    }

    public static int compute(int number)
    {
        try{Thread.sleep(1000);} catch (Exception e) {}
        return number * 2;
    }

    public static List<Person> createPeople()
    {
        return Arrays.asList(
            new Person("Sara", Gender.FEMALE, 20),
            new Person("Sara", Gender.FEMALE, 22),
            new Person("Bob", Gender.MALE, 20),
            new Person("Paula", Gender.FEMALE, 32),
            new Person("Paul", Gender.MALE, 32),
            new Person("Jack", Gender.MALE, 2),
            new Person("Jack", Gender.MALE, 72),
            new Person("Jill", Gender.FEMALE, 12)
        );
    }
}
