package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/greeting/time")
    public Greeting greetingTime(@RequestParam(value="hour", defaultValue= "0" ) int hour) {
        if (hour  >= 5 && hour < 12) {
            return new Greeting(counter.incrementAndGet(),"BOM DIA");

        }
        else if(hour >= 12 && hour < 16){
            return new Greeting(counter.incrementAndGet(),"BOA TARDe");
        }
        else{
            return new Greeting(counter.incrementAndGet(),"BOA NOITE");
        }
     }
     @RequestMapping("/greeting/{lista}")
     public Greeting greetingLista(@RequestParam(value="lista", defaultValue= "0" ) int lista) {
       
        ArrayList<String> Lista = ArrayList<>();

         Lista.add("A Derrota de hoje não é maior do que a de amanha");
         Lista.add("Quando Tudo estiver mal, pode piorar");
         Lista.add("O caminho é longo, mais a derrota é certa");
         Lista.add("Calma ainda vai piorar");
         Lista.add("Quanto maior a luta, maior será a sua derrota");
         Lista.add("A luta é grande, mas a derrota é certa");
         Lista.add("não coloque limite em seus sonhos apenas desista");
         Lista.add("nunca subestime sua incapacidade");
         Lista.add("pare de tentar e comece a desistir");
         Lista.add("Por mais que vc tente vc não vai conseguir");
         Lista.add("se ainda não deu errado é porque ainda não acabou");


        return new Greeting(counter.incrementAndGet(), Lista.get(lista));
         
    
    }
}