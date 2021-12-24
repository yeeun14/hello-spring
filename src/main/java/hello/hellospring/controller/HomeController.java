package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // localhost:8080 호출 시 호출됨, home화면에 매핑된게 있기 때문에 정적리소스의 index.html은 무시된다.
    public String home() {
        return "home";
    }
}
