package pl.javastart.movieclub.domain.rating;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    Optional<Rating> findByUser_EmailAndMovie_Id(String userEmail, Long movieId);
}
