package apple.ambrosia.market;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class SpringMain extends SpringBootServletInitializer {
    private static SpringMain instance;

    public SpringMain() {
        instance = this;
    }

    public static SpringMain get() {
        return instance;
    }
}