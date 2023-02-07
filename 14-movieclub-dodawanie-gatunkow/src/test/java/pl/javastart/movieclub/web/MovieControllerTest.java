package pl.javastart.movieclub.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.javastart.movieclub.domain.movie.MovieService;
import pl.javastart.movieclub.domain.movie.dto.MovieDto;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService movieService;

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
                true);
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
}