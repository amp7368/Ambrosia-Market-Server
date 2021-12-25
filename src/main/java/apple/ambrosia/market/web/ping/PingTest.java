package apple.ambrosia.market.web.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PingTest {
    @GetMapping("/ambrosia/ping")
    public String ping() {
        return "ping";
    }
}
