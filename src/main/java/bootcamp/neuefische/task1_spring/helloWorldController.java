package bootcamp.neuefische.task1_spring;

import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class helloWorldController {

    private List<Message> messageList = new ArrayList<>();

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("/messages")
    public List<Message> getMessages(){
        return messageList;
    }

    @PostMapping()
    public Message postMessage(@RequestBody Message message){
        messageList.add(message);
        return message;
    }

    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable String id){
        Message message = messageList.stream()
                        .filter(m1 -> m1.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("Message mit der id \"" + id + "\" wurde nicht gefunden!"));
        messageList.removeIf(m2 -> m2.getId().equals(id));
        return "Ihre Message \"" + message.getMessage() + "\" wurde gelöscht!";
    }
}
