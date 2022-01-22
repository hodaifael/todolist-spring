package com.example.ToDoList.WS;

import com.example.ToDoList.beans.Projet;
import com.example.ToDoList.services.ProjetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/projet")
public class ProjetWs {
    private final ProjetServices projetServices;
    @Autowired
    public ProjetWs(ProjetServices projetServices){
        this.projetServices=projetServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjetsByTicket () {
        List<Projet> medcins = projetServices.findAllProjets();
        return new ResponseEntity<>(medcins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById (@PathVariable("id") Long id) {
        Optional<Projet> Projet = projetServices.findProjetById(id);
        return new ResponseEntity(Projet, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Projet> addProjet(@RequestBody Projet Projet) {
        System.out.println("hello"+Projet.getUser_p().getId());
        Projet p = projetServices.addProjet(Projet);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet Projet) {
        Projet p = projetServices.updateProjet(Projet);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjet(@PathVariable("id") Long id) {
        projetServices.deleteProjet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



