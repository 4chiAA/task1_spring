package bootcamp.neuefische.task1_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World!";
    }
}
