package sawant.mihir.reactivesamples.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;


@Service
public class BasicWebClient {


    @PostConstruct
    public void createWebClient(){
         var apiFetch = WebClient.create("https://meme-api.herokuapp.com/gimme");

        Mono<Gimme> gimmeMono = apiFetch.get()
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Gimme.class);




    }
}
