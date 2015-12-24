import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by Asha on 15/12/24.
 * chapter 4
 */
public class Training4 {
    public Training4() {
        System.out.println("\n====== 4.12");
        Performance performance = new StrawBerryMusicFestival();
        List<String> names = performance.getAllMusicians().map(Training3.Artist::getName).collect(toList());
        System.out.println(performance.getName() + "," + names);

    }

    public interface Performance {
        String getName();
        Stream<Training3.Artist> getMusicians();
        default Stream<Training3.Artist> getAllMusicians(){
            return getMusicians().flatMap( artist -> Stream.concat(Stream.of(artist),artist.getMembers()));
        }
    }

    public class StrawBerryMusicFestival implements Performance {

        List<Training3.Artist> artists;

        public StrawBerryMusicFestival() {
            artists = asList(
                    new Training3.Artist("Asha","China")
                            .addMember(new Training3.Artist("zz","China"))
                            .addMember(new Training3.Artist("dachui","hangzhou"))
                    , new Training3.Artist("Jay Chou","China Taiwan")
                    , new Training3.Artist("Eason Chen","HK").addMember(new Training3.Artist("Linxi","HK"))
            );
        }

        @Override
        public String getName() {
            return "StrawBerry";
        }

        @Override
        public Stream<Training3.Artist> getMusicians() {
            return artists.stream();
        }
    }

    public static void main(String[] args) {
        new Training4();
    }
}
