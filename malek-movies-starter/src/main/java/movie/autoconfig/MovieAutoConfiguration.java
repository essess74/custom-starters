package movie.autoconfig;

import movie.intializer.MovieInitializer;
import movie.repository.MovieRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "movie")
public class MovieAutoConfiguration {
    @Bean
    @ConditionalOnProperty(name = "initialize-movies")
    public MovieInitializer movieInitializer(MovieRepository movieRepository) {
        return new MovieInitializer(movieRepository);
    }
}
