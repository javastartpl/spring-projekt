package pl.javastart.movieclub.web;

import org.springframework.context.annotation.Import;
import pl.javastart.movieclub.config.security.CustomSecurityConfig;

@Import(CustomSecurityConfig.class)
public class BaseWebTest {
}
