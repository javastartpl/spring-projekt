package pl.javastart.movieclub.web.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.javastart.movieclub.domain.genre.GenreService;
import pl.javastart.movieclub.domain.movie.MovieService;
import pl.javastart.movieclub.web.BaseWebTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieManagementController.class)
class MovieManagementControllerTest extends BaseWebTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService movieService;
    @MockBean
    GenreService genreService;

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldShowMovieFormForAdmin() throws Exception {
        mockMvc.perform(get("/admin/dodaj-film"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/movie-form"))
                .andExpect(model().attributeExists("movie"))
                .andExpect(model().attributeExists("genres"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void shouldNotShowMovieFormForUser() throws Exception {
        mockMvc.perform(get("/admin/dodaj-film"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldAddMovieByAdmin() throws Exception {
        Resource poster = new ClassPathResource("test-files/chucky.jpeg");
        assertNotNull(poster);
        MockMultipartFile posterMultiPart = new MockMultipartFile(
                "poster",poster.getFilename(),
                MediaType.MULTIPART_FORM_DATA_VALUE,
                poster.getInputStream());
        assertNotNull(posterMultiPart);

        MultiValueMap<String, String> movieParams = prepareNewMovieParams();
        mockMvc.perform(multipart("/admin/dodaj-film")
                        .file(posterMultiPart)
                        .params(movieParams)
                        .with(csrf()))
                .andExpect(redirectedUrl("/admin"))
                .andExpect(flash().attribute(AdminController.NOTIFICATION_ATTRIBUTE, "Film Laleczka Chucky został zapisany"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void shouldNotAddMovieByUser() throws Exception {
        Resource poster = new ClassPathResource("test-files/chucky.jpeg");
        assertNotNull(poster);
        MockMultipartFile posterMultiPart = new MockMultipartFile(
                "poster",poster.getFilename(),
                MediaType.MULTIPART_FORM_DATA_VALUE,
                poster.getInputStream());
        assertNotNull(posterMultiPart);

        MultiValueMap<String, String> movieParams = prepareNewMovieParams();
        mockMvc.perform(multipart("/admin/dodaj-film")
                        .file(posterMultiPart)
                        .params(movieParams)
                        .with(csrf()))
                .andExpect(status().isForbidden());
    }

    private static MultiValueMap<String, String> prepareNewMovieParams() {
        MultiValueMap<String, String> movieParams = new LinkedMultiValueMap<>();
        movieParams.add("title", "Laleczka Chucky");
        movieParams.add("originalTitle", "Childs play");
        movieParams.add("shortDescription", "Straszna laleczka");
        movieParams.add("description", "Film o morderczej lalce");
        movieParams.add("youtubeTrailerId", "abc123");
        movieParams.add("releaseYear", "1987");
        movieParams.add("genre", "Horror");
        movieParams.add("promoted", "true");
        return movieParams;
    }
}
