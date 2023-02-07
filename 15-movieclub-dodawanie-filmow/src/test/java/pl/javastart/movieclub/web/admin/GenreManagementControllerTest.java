package pl.javastart.movieclub.web.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.javastart.movieclub.domain.genre.GenreService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GenreManagementController.class)
class GenreManagementControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GenreService genreService;

    @Test
    void shouldShowGenreForm() throws Exception {
        mockMvc.perform(get("/admin/dodaj-gatunek"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAddGenre() throws Exception {
        mockMvc.perform(post("/admin/dodaj-gatunek")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Thriller")
                .param("description", "Filmy trzymające w napięciu"))
                .andExpect(redirectedUrl("/admin"))
                .andExpect(flash().attribute(AdminController.NOTIFICATION_ATTRIBUTE, "Gatunek Thriller został zapisany"));

    }
}
