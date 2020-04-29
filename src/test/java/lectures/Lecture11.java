package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    StringBuilder stringBuilder = new StringBuilder();
    for (String name : names) {
      if (!stringBuilder.toString().isEmpty()) {
        stringBuilder.append(", ");
      }
      stringBuilder.append(name);
    }
    System.out.println(stringBuilder.toString());

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    final String joinStr = names.stream().collect(Collectors.joining());
    System.out.println(joinStr);
    final String joinWithDelimiter = names.stream().collect(Collectors.joining(","));
    System.out.println(joinWithDelimiter);
    final String joiningDelimiterUpperCase = names.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining("|"));
    System.out.println(joiningDelimiterUpperCase);
  }
}
