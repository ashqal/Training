import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by Asha on 15/12/24.
 * chapter 4
 */
public class Training4 {

    public static class Artists{
        private List<Training3.Artist> artists;

        public Artists(List<Training3.Artist> artists) {
            this.artists = artists;
        }

        public Optional<Training3.Artist> getArtist(int index){
            if (index < 0 || index >= artists.size())
                return Optional.empty();
            return Optional.of(artists.get(index));
        }

        public String getArtistName(int index){
            return getArtist(index).map(Training3.Artist::getName).orElse("unknown");
        }

    }

    public Training4() {
        System.out.println("\n====== 4.12 1");
        StrawBerryMusicFestival performance = new StrawBerryMusicFestival();
        List<String> names = performance.getAllMusicians().map(Training3.Artist::getName).collect(toList());
        System.out.println(performance.getName() + "," + names);

        System.out.println("\n====== 4.12 2");
        Artists artists = new Artists(performance.getArtists());
        System.out.println(artists.getArtistName(8));
        System.out.println(artists.getArtistName(1));

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

        public List<Training3.Artist> getArtists() {
            return artists;
        }

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
