import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by Asha on 15/12/15.
 *
 */
public class Training3 {
    public class Artist {
        private String name;
        private String country;

        private List<Artist> members;

        public Artist(String name, String country) {
            this.name = name;
            this.country = country;
            members = new ArrayList<>();
        }

        public Artist addMember(Artist artist){
            members.add(artist);
            return Artist.this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Stream<Artist> getMembers() {
            return members.stream();
        }

        @Override
        public String toString() {
            return "Artist{" +
                    "name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", members:" + members.size() +
                    '}';
        }
    }

    public class Album{
        String name;
        int length;

        public Album(String name, int length) {
            this.name = name;
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        @Override
        public String toString() {
            return "Album{" +
                    "name='" + name + '\'' +
                    ", length=" + length +
                    '}';
        }
    }

    public Training3() {
        System.out.println("====== 1");
        // 1.a
        List<Integer> values = asList(1,2,3,4);
        System.out.println(addUp(values.stream()));

        // 1.b
        List<Artist> artists = asList(
                new Artist("Asha","China").addMember(new Artist("zz","China")).addMember(new Artist("dachui","hangzhou"))
                , new Artist("Jay Chou","China Taiwan")
                , new Artist("Eason Chen","HK").addMember(new Artist("Linxi","HK"))
        );
        List<String> details = artistDetail(artists);
        System.out.println(details);

        // 1.c
        List<Album> albums = asList(new Album("Green",2)
                , new Album("Sun",9)
                , new Album("Love is over",1)
                , new Album("Go away",3));
        List<Album> eps = albums.stream().filter(album -> album.getLength() <= 3 ).collect(toList());
        System.out.println(eps);

        System.out.println("====== 2");
        // 2
        int totalMembers = 0;
        for( Artist artist : artists ){
            Stream<Artist> members = artist.getMembers();
            int count = (int) members.count();
            System.out.println(artist.toString() );
            totalMembers += count;
        }
        System.out.println(totalMembers);

        totalMembers = artists.stream()
                .map( artist -> artist.getMembers().count() )
                .reduce(0L, Long::sum ).intValue();
        System.out.println(totalMembers);

        System.out.println("====== 4");
        // 4




    }

    private List<String> artistDetail(List<Artist> artists){
        return artists.stream().map( artist -> artist.getName() + " from " + artist.getCountry() ).collect(toList());
    }

    private int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, (acc,element) -> acc + element);
    }

    public static void main(String[] args) {
        new Training3();
    }
}
