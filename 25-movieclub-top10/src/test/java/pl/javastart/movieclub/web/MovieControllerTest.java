package pl.javastart.movieclub.web;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.javastart.movieclub.domain.movie.MovieService;
import pl.javastart.movieclub.domain.movie.dto.MovieDto;
import pl.javastart.movieclub.domain.rating.RatingService;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest extends BaseWebTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService movieService;
    @MockBean
    RatingService ratingService;

    @Test
    void shouldFindMovie() throws Exception {
        MovieDto movie1 = new MovieDto(
                1L,
                "Laleczka Chucky",
                "Chucky",
                "Bardzo straszny",
                "Bardzo bardzo straszny film",
                "abc123",
                1987,
                "Horror",
                true,
                "poster.png",
                8.8,
                123);
        when(movieService.findMovieById(1L)).thenReturn(Optional.of(movie1));
        mockMvc.perform(get("/film/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("movie"))
                .andExpect(model().attribute("movie", movie1));
    }

    @Test
    void shouldNotFindMovie() throws Exception {
        when(movieService.findMovieById(1L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/film/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldFindTopMovies() throws Exception {
        when(movieService.findTopMovies(10)).thenReturn(Mockito.anyList());
        mockMvc.perform(get("/top10"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("movies"))
                .andExpect(view().name("movie-listing"));
    }
}
