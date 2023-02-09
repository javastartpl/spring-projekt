package pl.javastart.movieclub.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.javastart.movieclub.domain.user.UserService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegistrationController.class)
class RegistrationControllerTest extends BaseWebTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void shouldAllowAccessToRegistrationForm() throws Exception {
        mockMvc.perform(get("/rejestracja"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldRedirectToHomepageAfterSuccessfullRegistration() throws Exception {
        mockMvc.perform(post("/rejestracja")
                        .with(csrf())
                        .param("username", "abc")
                        .param("password", "xyz"))
                .andExpect(redirectedUrl("/"));
    }
}
