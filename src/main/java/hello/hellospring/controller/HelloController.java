package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") //뷰라는 템플릿을 조작해 사용
    public String hellomvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") // 템플릿 엔지과 다른점은 문자 그대로 내려간다는 것
    @ResponseBody // http에서 바디부에 직접 데이터를 넣겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 문자가 아닌 객체 반환
    }

    static class Hello { // Json 형태 (key:value)
        private String name;

        public String getName() { // java bin 표준규약
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
