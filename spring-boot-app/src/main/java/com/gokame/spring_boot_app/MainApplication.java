// package com.gokame.spring_boot_app;

// import java.util.concurrent.atomic.AtomicLong;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.gokame.restservice.Greeting;

// // start application here
// @SpringBootApplication
// @RestController
// public class MainApplication {
//     public static void main(String[] args) {
//       SpringApplication.run(MainApplication.class, args);
//     }
//     @GetMapping("/hello")
//     public String hello(@RequestParam(defaultValue = "World") String name) {
//       return String.format("Hello %s!", name);
//     }


//     // below works in this class but not in another class
//         private static final String TEMPLATE = "Hello, %s!";
//     private final AtomicLong counter = new AtomicLong();

//     @GetMapping("/greeting")
//     public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
//         return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
//     }
// }