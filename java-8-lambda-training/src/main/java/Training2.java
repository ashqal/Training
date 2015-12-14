public class Training2 {
    public interface Function<T,R> {
        R apply(T t);
    }
    public Training2(){
        Function<Long,Long> func = x -> x + 1;
        Long result = func.apply(12L);
        System.out.println("result:" + result);
    }
    public static void main(String[] args) {
        new Training2();
    }
}
