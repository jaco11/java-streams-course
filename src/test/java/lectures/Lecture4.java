package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture4 {

  /** Removing duplicates in a list (Distinct)
   *
   * @throws Exception
   */
  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    final List<Integer> distinctNumbers = numbers.stream()
        .distinct()
        .collect(Collectors.toList());
    assertThat(distinctNumbers).isEqualTo(ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    assertThat(distinctNumbers).hasSize(9);
    System.out.println(distinctNumbers);
  }

  /**
   * Removing duplicates in a list with Collectors. Collectors.toSet
   * @throws Exception
   */
  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    Set<Integer> numbersSet = numbers.stream().collect(Collectors.toSet());
    System.out.println(numbersSet);
    assertThat(numbersSet).hasSize(9);

  }
}
