package br.unicesumar.restserver.disciplina;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
@Transactional
public class DisciplinaController {
    @Autowired
    private EntityManager em;
    @RequestMapping(method = RequestMethod.GET)
        public List<Disciplina>getDisciplina(){
        return null;  
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void criarDisciplina(@RequestBody Disciplina disciplina){
        em.persist(disciplina);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void alterarDisciplina(@RequestBody Disciplina disciplina){
        em.refresh(disciplina);
    }

    @RequestMapping(value = "/disciplinas/{id}",method = RequestMethod.DELETE)
    public void excluirDisciplina(@PathVariable Long id){
        em.remove(id);
    }
    
}
