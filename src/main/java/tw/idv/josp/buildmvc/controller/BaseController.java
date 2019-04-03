package tw.idv.josp.buildmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    @GetMapping(path = {"/","index"})
    public String getIndexPage(){
            return "index";
        }

    @RequestMapping(value = "/getinfo")
    public @ResponseBody String getInfo(){
        return "Hello World!";
    }

}
