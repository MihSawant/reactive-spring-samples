package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class DoOnTest {

    @Test
    public void doOnCallTest(){
        var flux = Flux.create(c ->{
            c.next(1);
            c.next(2);
            c.next(3);
            c.error(new IllegalStateException("Something Went Wrong !!"));
            c.complete();
        })
                .doOnEach(System.out::println)
                .doOnError(error -> System.out.println("Error: "+error))
                .doOnComplete(() -> System.out.println("Finished :)"));


        StepVerifier.create(flux).expectNext(1, 2, 3)
                .expectError(IllegalStateException.class)
                .verify();


    }
}
