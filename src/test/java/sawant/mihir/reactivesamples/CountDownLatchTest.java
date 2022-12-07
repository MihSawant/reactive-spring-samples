package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    @Test
    public void simpleLatchTest(){
      CountDownLatch c = new CountDownLatch(5);

        var data = Flux.just(1, 2, 3, 4, 5)
                .doOnEach(d -> c.countDown());

        StepVerifier.create(data)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5).verifyComplete();
        Assert.isTrue(c.getCount() == 0);
    }
}
