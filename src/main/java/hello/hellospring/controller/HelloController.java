package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","waaaaaaahhhh");
        System.out.println(model);
        return "hello";
    }

    @GetMapping("q")
    public String query(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-name";
    }

    public static class Hello{
        private String name = "";
        public String getName(){
            return name;
        }
        public void setName(String s){
            this.name = s;
        }
    }

    @GetMapping("obj")
    @ResponseBody
    public Hello obj(@RequestParam("name") String name){
        Hello h = new Hello();
        h.setName(name);
        return h;
    }
}
