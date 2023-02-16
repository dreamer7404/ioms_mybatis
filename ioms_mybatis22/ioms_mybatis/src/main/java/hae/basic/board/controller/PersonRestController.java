package hae.basic.board.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import able.cloud.core.web.HController;
import hae.basic.board.model.Person;
import hae.basic.board.service.BoardService;
import hae.basic.board.service.PersonService;
import java.util.List;



@RestController
public class PersonRestController extends HController {
    
    private final PersonService personService;
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> selectPersonList(ModelMap model) throws Exception {
        List<Person> list = personService.selectPersonList();
        return list;
    }
    
}