package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GretingController {

  private static final String template = "hello, %s!";

  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "word")String name){
      return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
