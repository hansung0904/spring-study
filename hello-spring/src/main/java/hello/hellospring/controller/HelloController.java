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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // ResponseBody의 의미는 http에서 head부와 body부가 있는데 body부에 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring" 으로 바뀔거야
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // cmd shift enter 하면 자동으로 닫아줌.
        hello.setName(name);
        return hello;
    }
    /*
    과거에는 XML 방식으로 많이 데이터를 보내줬었는데 XML 방식자체는 무겁기도 하고 태그를 열고 닫고 해주어야하기 때문에 번거롭다.
    그래서 JSON 방식으로 많이 데이터를 보내주게 되며 JSON Key,Value만 적어주면 데이터를 포맷해서 보여준다.
    */

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    // Getter Setter는 JavaBean 표준방식이라고 이야기하고 property 접근방식이라고 한다.


}
