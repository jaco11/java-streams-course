package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  private List<Car> carsList;
  private List<Person> personList;

  public Lecture7() throws IOException {
    this.carsList = MockData.getCars();
    this.personList = MockData.getPeople();
  }

  @Test
  public void count() throws Exception {
    final long female = personList.stream()
        .filter(person -> person.getGender().equalsIgnoreCase("female"))
        .count();
    final long male = personList.stream()
        .filter(person -> person.getGender().equalsIgnoreCase("male"))
        .count();
    System.out.println(female);
    System.out.println(male);

    assertThat(female + male).isEqualTo(1000);
  }

  @Test
  public void min() throws Exception {
    final double min = carsList.stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .min()
        .getAsDouble();

    System.out.println(min);

  }

  @Test
  public void max() throws Exception {
    final double max = carsList.stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .max()
        .getAsDouble();

    System.out.println(max);
  }


  @Test
  public void average() throws Exception {

    final double averagePrice = carsList.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .getAsDouble();

    System.out.println(averagePrice);

  }

  @Test
  public void sum() throws Exception {

    final double sum = carsList.stream()
        .mapToDouble(Car::getPrice)
        .sum();

    BigDecimal bigDecimal = BigDecimal.valueOf(sum);
    System.out.println(bigDecimal);

  }

  @Test
  public void statistics() throws Exception {

    final DoubleSummaryStatistics statistics = carsList.stream()
        .mapToDouble(Car::getPrice).summaryStatistics();

    System.out.println(statistics);

  }

}