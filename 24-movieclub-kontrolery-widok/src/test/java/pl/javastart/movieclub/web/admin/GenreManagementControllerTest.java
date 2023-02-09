package pl.javastart.movieclub.web.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.javastart.movieclub.domain.genre.GenreService;
import pl.javastart.movieclub.web.BaseWebTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GenreManagementController.class)
class GenreManagementControllerTest extends BaseWebTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GenreService genreService;

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldShowGenreFormForAdmin() throws Exception {
        mockMvc.perform(get("/admin/dodaj-gatunek"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    void shouldNotShowGenreFormForUser() throws Exception {
        mockMvc.perform(get("/admin/dodaj-gatunek"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldAddGenreByAdmin() throws Exception {
        mockMvc.perform(post("/admin/dodaj-gatunek")
                        .with(csrf())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Thriller")
                .param("description", "Filmy trzymające w napięciu"))
                .andExpect(redirectedUrl("/admin"))
                .andExpect(flash().attribute(AdminController.NOTIFICATION_ATTRIBUTE, "Gatunek Thriller został zapisany"));
    }
}
