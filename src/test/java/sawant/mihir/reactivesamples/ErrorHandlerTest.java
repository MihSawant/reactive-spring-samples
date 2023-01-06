package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ErrorHandlerTest {

    @Test
    public void onResumeTest(){
        var values = Flux.just(1, 2, 3);
        values.flatMap(v -> {
           if(v == 2){
               return Flux.error(new IllegalStateException("Something Went Wrong !"));
           }
           return Flux.just(v);
        });

        Flux<Integer> integerFlux = values.onErrorResume(IllegalStateException.class, e -> Flux.just(3, 2, 1));

    }
}
