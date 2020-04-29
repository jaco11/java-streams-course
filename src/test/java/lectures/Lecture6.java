package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.Test;

public class Lecture6 {

  /**
   * Java Predicate. Predicates in Java are implemented with interfaces.
   * Predicate<T> is a generic functional interface representing a single argument function
   * that returns a boolean value. It is located in the java. ...
   * It contains a test(T t) method that evaluates the predicate on the given argument
   */

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    final Integer any = Arrays.stream(numbers)
        .filter(n -> n < 10)
        .findAny()
        .get();

    System.out.println(any);

  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final int first = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findFirst()
        .get();

    System.out.println(first);
    assertThat(first).isEqualTo(6);
  }

}

