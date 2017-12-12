package movie.intializer;

import movie.model.Movie;
import movie.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class MovieInitializer implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public MovieInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                        .thenMany(
                                movieRepository.saveAll(Flux.fromStream(Stream.of("The punisher", "Game of thronse").map(name -> {
                                    final Movie toReturn = new Movie();
                                    toReturn.setName(name);
                                    return toReturn;
                                }))))
                        .thenMany(movieRepository.findAll())
                        .subscribe(System.out::println);
    }
}
