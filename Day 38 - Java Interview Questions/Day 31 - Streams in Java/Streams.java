import java.util.*;
import java.util.stream.Collectors;

public class Streams
{
    public static void main(String[] args)
    {
        List<Integer>arr = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

//        Even Numbers
        List<Integer>even = arr.stream().filter(n -> n%2==0).toList();
        System.out.println(even);

//        Odd Numbers
        List<Integer>odd = arr.stream().filter(n -> n%2!=0).collect(Collectors.toList());
        System.out.println(odd);

//        Square of Even Numbers > 5
        List<Integer>sqevn5 = arr.stream().filter(n -> n>5).filter(n -> n%2==0).map(n -> n*n).toList();
        System.out.println(sqevn5);

//        Sum of All Numbers
        int sum = arr.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);


        // Sum of All Numbers with lambda Expression
        int sumNoIdentity = arr.stream().reduce(0,Integer::sum);
        System.out.println(sumNoIdentity);

        // Sum of All Numbers without Identity using Optional for Empty List Handling
        Optional<Integer>sumopt = arr.stream().reduce((a, b)->a+b);
        System.out.println(sumopt);

        int summ = arr.stream().mapToInt(a->a).sum();
        System.out.println("Sum using mapToInt: "+summ);

//        Find maximum number

        int maxx = arr.stream().max(Integer::compareTo).get();
        System.out.println(maxx);


//        Find Minimum Number
        int minn = arr.stream().min(Integer::compareTo).get();
        System.out.println(minn);

//        Find Minimum -- Safer Version for Handling Empty Lists
        List<Integer>arr2 = Arrays.asList();
       int min2 = arr2.stream().min(Integer::compareTo).orElse(-1);
        System.out.println(min2);

//      Maximum using Reduce
        Integer maxxx = arr.stream().reduce(Integer.MIN_VALUE,Integer::max);
        System.out.println(maxxx);

        Optional<Integer>maxxOpt = arr.stream().reduce(Integer::max);
        System.out.println(maxxOpt);

        Integer maxxOrElse = arr.stream().reduce(Integer::max).orElse(Integer.MIN_VALUE);
        System.out.println(maxxOrElse);


        OptionalInt minMapp = arr.stream().mapToInt(x -> x).min();
        System.out.println(minMapp);


//        Remove Duplicates in the List - Keep Only Distinct Values
        List<Integer>arr3 = Arrays.asList(1,1,2,3,5,6,7);
        List<Integer> dis = arr3.stream().distinct().toList();
        System.out.println(dis);

//        sort array elements in ascending Order
        List<Integer> arr4 = Arrays.asList(1,4,3,2,5,7,8,6,9);
        List<Integer>sortAsc = arr4.stream().sorted().toList();
        System.out.println(sortAsc);

//        sort array elements in descending order
        List<Integer>sortDesc = arr4.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortDesc);


//        sum of all even numbers

        int sumEven = arr.stream().filter(n -> n%2 == 0).reduce(0,Integer::sum);
        System.out.println(sumEven);

//        sum of all odd numbers
        int sumEven2 = arr.stream().filter(n -> n%2!=0).reduce(0,(a,b)->(a+b));
        System.out.println(sumEven2);

//        Sum of Squares of Even Numbers - Filter + Map + Reduce
        int sumEvnSq = arr.stream().filter(n -> n%2==0).map(n-> n*n).reduce(0,Integer::sum);
        System.out.println(sumEvnSq);

        //        Sum of Squares of Even Numbers - Filter + Map + Reduce - without Identity Optional for Handling empty
        List<Integer>arr5 = Arrays.asList();
        Optional<Integer> result = arr5.stream().filter(n -> n%2==0).map(n -> n*n).reduce(Integer::sum);
        System.out.println(result);
        result.ifPresent(System.out::println);
        System.out.println(result.isPresent());

//        safer version - Sum of Squares of Even Numbers
        int res = arr5.stream().filter(n -> n%2 ==0).map(n ->n*n).reduce(Integer::sum).orElse(-1);
        System.out.println(res);

//        product of all numbers
        int prod = arr.stream().reduce(1,(a,b)->a*b);
        System.out.println(prod);

//      Without identity
        prod = arr.stream().reduce((a,b)->a*b).orElse(-1);
        System.out.println(prod);

        Optional<Integer>prodOpt = arr.stream().reduce((a,b)->a*b);
        System.out.println(prodOpt);

        //        Find First Element Greater than 7
        int eleGt7 = arr.stream().filter(n -> n>7).findFirst().get();
        System.out.println(eleGt7);

        //        Find First Element Greater than 1000 -Handling Non Existing case using orElse
        int eleGt1000 = arr.stream().filter(n -> n>1000).findFirst().orElse(-1);
        System.out.println(eleGt1000);

        //        Find First Element Greater than 1000 -Handling Non Existing case using Optional Data Type

        Optional<Integer>eleGt1000Opt = arr.stream().filter(n -> n>1000).findFirst();
        System.out.println(eleGt1000Opt);

//        Check If any number is greater than 10
        List<Integer>nums = Arrays.asList(3,5,7,12,4);
        boolean result_check = nums.stream().anyMatch(n -> n>10);
        System.out.println(result_check);

//        Check if all numbers are even
        boolean even_check = nums.stream().allMatch(n -> n%2==0);
        System.out.println(even_check);

//        Check if None are Negative
        boolean negative_check = nums.stream().noneMatch(n -> n<0);
        System.out.println(negative_check);

//        Check if none are positive
        boolean postive_check = nums.stream().noneMatch(n -> n>0);
        System.out.println(postive_check);

//        count number of elements greater than 5
        nums = Arrays.asList(1,6,3,8,2,9);
        long count = nums.stream().filter(n -> n>5).count();
        System.out.println(count);

//        Convert list to Map
        List<String>names = Arrays.asList("Surya","Mahesh","Kiran");
        Map<String,Integer>map = names.stream().collect(Collectors.toMap(name -> name,name ->name.length()));
        System.out.println(map);


//        Reduce Practice
//        product of all numbers
        nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int product = nums.stream().reduce(1,(a,b)->a*b);
        System.out.println(product);

//        Find Sum of Squares
        int sumOfSquares = nums.stream().map(n -> n*n).mapToInt(n->n).sum();
        System.out.println(sumOfSquares);

        sumOfSquares = nums.stream().map(n -> n*n).reduce(0,Integer::sum);
        System.out.println(sumOfSquares);

//        Find Longest String
        Optional<String>longest_string = names.stream().reduce((a,b)->a.length()>b.length()?a:b);
        System.out.println(longest_string);

//        find shortest string
        Optional<String >shortest_string = names.stream().reduce((a,b)->a.length()<b.length()?a:b);
        System.out.println(shortest_string);

        System.out.println(nums);

//        find minimum number in list
        Optional<Integer>min_num = nums.stream().reduce((a,b)->a<b?a:b);
        System.out.println(min_num);

        int min_number = nums.stream().reduce(Integer.MAX_VALUE,Integer::min);
        System.out.println(min_number);

        min_number = nums.stream().reduce(Integer::min).orElse(-1);
        System.out.println(min_number);

        min_num = nums.stream().reduce(Integer::min);
        System.out.println(min_num);

        System.out.println(nums);

//        Find Maximum number in list
        Optional<Integer>max_num=nums.stream().reduce((a,b)->a>b?a:b);
        System.out.println(max_num);

        int max_number = nums.stream().reduce(Integer.MIN_VALUE,Integer::max);
        System.out.println(max_number);

        max_num = nums.stream().reduce(Integer::max);
        System.out.println(max_num);

        max_number = nums.stream().reduce(Integer::max).orElse(-1);
        System.out.println(max_number);


//        Concatenate all strings
        System.out.println(names);
        String mix = names.stream().reduce("",(a,b)->a+b);
        System.out.println(mix);

//        max/min practice
        OptionalInt min_integer = nums.stream().mapToInt(n -> n).min();
        System.out.println(min_integer);

        int min = nums.stream().min(Integer::compareTo).orElse(-1);
        System.out.println(min);


//      Least/Min Number
        List<Integer>numbers = Arrays.asList(1,1,1,1,5,7,73,2,240,111,2,3,7,6,-1,100,45,120,240,111);
        System.out.println(numbers);

        int least = numbers.stream().sorted().findFirst().orElse(-1);
        System.out.println(least);

//      Second least number
        int second_least = numbers.stream().sorted().skip(2).findFirst().get();
        System.out.println(second_least);

//      Highest/Max number
        int highest = numbers.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(-1);
        System.out.println(highest);

//      Second Highest number
        int second_highest = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println(second_highest);

//        Smallest Even Number
        int smallest_even = numbers.stream().filter(n -> n%2==0).mapToInt(n ->n).min().orElse(-1);
        System.out.println(smallest_even);

//        smallest odd number
        int smallest_odd = numbers.stream().filter(n -> n%2!=0).mapToInt(n -> n).min().orElse(-1);
        System.out.println(smallest_odd);

//        second smallest Even
        int sec_smallest_even = numbers.stream().filter(n -> n%2==0).sorted().skip(1).findFirst().orElse(-1);
        System.out.println(sec_smallest_even);

//        second highest even
        int sec_highest_even = numbers.stream().filter(n -> n%2==0).sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println(sec_highest_even);


        System.out.println(numbers);

//        highest num
        int highnum=  numbers.stream().reduce(Integer::max).orElse(-1);
        System.out.println(highnum);

        highnum = numbers.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(-1);
        System.out.println(highnum);

        //        longest string
        System.out.println(names);

        String long_string =  names.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(long_string);

        System.out.println(numbers);

//        Remove Duplicates in Numbers
        List<Integer>distinct_numbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct_numbers);

        distinct_numbers = numbers.stream().distinct().toList();
        System.out.println(distinct_numbers);

//        count distinct numbers
        long distinct_num_count = numbers.stream().distinct().count();
        System.out.println(distinct_num_count);


        names = Arrays.asList("Mahesh","Kiran","Surya","Mahesh","Kiran");

        System.out.println(names);

        List<String>distinct_names = names.stream().distinct().toList();
        System.out.println(distinct_names);

//        count distinct names
        long distinct_name_count = names.stream().distinct().count();
        System.out.println(distinct_name_count);

//        Remove Duplicates& Sort
        List<Integer>distinct_sort = numbers.stream().distinct().sorted().toList();
        System.out.println(distinct_sort);

//        Numbers Sorted Ascending Order
        List<Integer>sorted_numbers = numbers.stream().sorted().toList();
        System.out.println(sorted_numbers);

//        Numbers Sorted Descending Order
        List<Integer>sorted_desc_numbers = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sorted_desc_numbers);

        System.out.println(names);

//        Find First String Starting with "S"
        System.out.println(names);

        String namewiths = names.stream().filter(s->s.startsWith("S")).findFirst().orElse("");
        System.out.println(namewiths);

//        Find First String Ends with "n"
        String nameendswithn = names.stream().filter(s -> s.endsWith("n")).findFirst().orElse("");
        System.out.println(nameendswithn);

        nameendswithn = names.stream().filter(s -> s.endsWith("n")).findAny().orElse("");
        System.out.println(nameendswithn);

//      Any Negative
        boolean anyneg = numbers.stream().anyMatch(n -> n<0);
        System.out.println(anyneg);

//        All Positive
        boolean allpos = numbers.stream().allMatch(n -> n>0);
        System.out.println(allpos);

//        None Zero
        boolean noneZero = numbers.stream().noneMatch(n -> n==0);
        System.out.println(noneZero);

//        Any String length > 10
        boolean anyStringGt10Len = names.stream().anyMatch(s -> s.length()>10);
        System.out.println(anyStringGt10Len);

//        Count Practice
        Long count_even = numbers.stream().filter(n -> n%2==0).count();
        System.out.println(count_even);

//        count distinct numbers
        Long count_distinct = numbers.stream().distinct().count();
        System.out.println(count_distinct);

    }

}
