package pl.javastart.movieclub.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.javastart.movieclub.domain.rating.RatingService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RatingController.class)
class RatingControllerTest extends BaseWebTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RatingService ratingService;

    @Test
    @WithMockUser(username = "some@user.com", roles = "USER")
    void shouldAddRatingForExistingUser() throws Exception {
        final String referer = "http://localhost:8080/film/1";
        performAddRating(referer).andExpect(redirectedUrl(referer));
    }

    @Test
    void shouldRejectRatingForUnauthenticated() throws Exception {
        final String referer = "http://localhost:8080/film/1";
        performAddRating(referer)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    private ResultActions performAddRating(String referer) throws Exception {
        return mockMvc.perform(post("/ocen-film")
                .with(csrf())
                .param("movieId", "1")
                .param("rating", "8")
                .header("referer", referer));
    }

}
