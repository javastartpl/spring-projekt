package pl.javastart.movieclub.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoginController.class)
class LoginControllerTest extends BaseWebTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Should allow unauthenticated user to access custom login form")
    void shouldAllowCustomLoginForm() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login-form"));
    }

    @Test
    @WithMockUser(username = "abcuser", password = "abc123", roles = "USER")
    void shouldLogoutAuthenticatedUser() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(authenticated());
        mockMvc.perform(get("/logout"))
                .andExpect(redirectedUrl("/login?logout"))
                .andExpect(unauthenticated());
    }
}
