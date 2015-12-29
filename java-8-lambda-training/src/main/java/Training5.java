import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * Created by Asha on 15/12/25.
 * Chapter 5
 */
public class Training5 {

    public Training5() {
        String str1 = "I love the world. He he";
        String str2 = "I love the world.";
        List<String> samples1 = asList("Waiting","For","You");

        System.out.println("\n====== 5.6 1 a");
        List<String> samples1Result = samples1.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(samples1Result);

        System.out.println("\n====== 5.6 1 b");
        int count = samples1.stream().map(String::length).reduce(0, Integer::sum);
        System.out.println(count);

        System.out.println("\n====== 5.6 1 c");
        List<Integer> resultOfFlatMap = Stream.of(asList(1,2),asList(3,4)).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(resultOfFlatMap);

        System.out.println("\n====== 5.6 2 a");
        List<String> nameList = asList("John Lennon","Paul McCarteny","George Harrison","Ringo Starr","Pete Best","Stuart Sutcliffe");
        Optional<String> longestName = nameList.stream().reduce((acc, data) -> acc.length() > data.length() ? acc : data);
        System.out.println(longestName.orElse("unknown"));

        longestName = nameList.stream().collect(maxBy(Comparator.comparing(String::length)));
        System.out.println(longestName.orElse("unknown"));

        System.out.println("\n====== 5.6 2 b");
        Stream<String> names = Stream.of("John","Paul","George","John","Paul","John");
        Map<String,Long> map = names.collect(groupingBy(name->name,counting()));
        System.out.println(map);
    }

    public static void main(String[] args) {
        new Training5();
    }
}
