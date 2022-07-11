package space.gavinklfong.demo.streamapi;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*
  This class is an example of Predicate example
  Predicate is an interface in java 8 which helps in code managebility
  and unit test them
  it is having a method called test()
  Predicate is predefined functional interface is having several methods
  like isEqual()
 */

public class PredicateJava8 {

    public static void main(String[] args) {

        int[] nums = {2,3,1,5,6,7,8,9,12};

        IntPredicate p = n -> n>5;

        Arrays.stream(nums).filter(p).forEach(System.out::println);

        //Arrays.stream(nums).filter(o -> o>5).forEach(System.out::println);

        System.out.println("********************After Negate************");

        Arrays.stream(nums).filter(p.negate()).forEach(System.out::println);

    }
}
