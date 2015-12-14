import java.util.function.Supplier;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
public class Training2 {
    public interface Function<T,R> {
        R apply(T t);
    }

    public Training2(){
        Function<Long,Long> func = x -> x + 1;
        System.out.println(String.format("result:%d",func.apply(12L)));
        Supplier<DateFormat> supplier = () -> new SimpleDateFormat("dd-MM-YYYY");
        int i = 0;
        while ( i++ < 10 ) {
            new Thread(() -> {
                ThreadLocal<DateFormat> local = ThreadLocal.withInitial(supplier);
                DateFormat formatter = local.get();
                String date = formatter.format(new Date());
                System.out.println(String.format("Thread:%s Date:%s",Thread.currentThread(),date));
            }).start();
        }
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // do nothing.
        }
    }
    public static void main(String[] args) {
        new Training2();
    }
}
