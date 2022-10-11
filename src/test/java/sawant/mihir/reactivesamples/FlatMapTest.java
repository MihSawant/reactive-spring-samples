package sawant.mihir.reactivesamples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

class Book{
    int id;
    String name;

    public Book(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class FlatMapTest {

    @Test
    public void bookTest(){
        var books = Flux.just(
                new Book(300, "Reactive-Spring"),
                new Book(200, "Spring Start Here"),
                new Book(100, "Effective-Java")
        ).flatMap(book -> this.delayReply(book.getId()));

        StepVerifier.create(books).expectNext(100, 200, 300).verifyComplete();

    }

    public Flux<Integer> delayReply(int delayTime){
        return Flux.just(delayTime).delayElements(Duration.ofMillis(delayTime));
    }


}
