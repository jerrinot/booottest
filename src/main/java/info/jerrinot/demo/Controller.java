package info.jerrinot.demo;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@RestController
public class Controller {

    @RequestMapping("/")
    String home() {
        String resource = "myResource";
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        try {
            Enumeration<URL> resources = tccl.getResources(resource);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                System.out.println(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Hello World!";
    }

}