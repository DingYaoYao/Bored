package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class controller {
   // @GetMapping(value = {"/index",""})
   @RequestMapping(value = {"/index",""}, method = RequestMethod.GET)
    public String index(){
       System.out.print("123213");
        return "index";
    }
}
