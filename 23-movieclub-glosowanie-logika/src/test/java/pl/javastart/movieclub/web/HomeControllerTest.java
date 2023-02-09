package pl.javastart.movieclub.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.javastart.movieclub.domain.movie.MovieService;
import pl.javastart.movieclub.domain.movie.dto.MovieDto;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest extends BaseWebTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService movieService;

    @Test
    void homeTest() throws Exception {
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
                "poster1.png",
                9.9,
                123);
        MovieDto movie2 = new MovieDto(
                2L,
                "Teksańska masakra",
                "Texas Masacree",
                "Trochę straszny",
                "Trochę straszny ale jednak straszny",
                "xyz321",
                2000,
                "Horror",
                true,
                "poster2.png",
                4.5,
                12);
        List<MovieDto> movies = List.of(movie1, movie2);
        when(movieService.findAllPromotedMovies()).thenReturn(movies);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("movie-listing"))
                .andExpect(model().attribute("heading", "Promowane filmy"))
                .andExpect(model().attribute("movies", hasItem(movie1)))
                .andExpect(model().attribute("movies", hasSize(2)));
    }
}
