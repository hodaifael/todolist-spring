package com.example.ToDoList.WS;

import com.example.ToDoList.beans.Projet;
import com.example.ToDoList.beans.Tache;
import com.example.ToDoList.services.TacheServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/tache")
public class TacheWs {
    private final TacheServices tacheServices;
    @Autowired
    public TacheWs(TacheServices tacheServices){
        this.tacheServices=tacheServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Tache>> getAllTachesByTicket () {
        List<Tache> taches = tacheServices.findAllTaches();
        return new ResponseEntity<>(taches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTacheById (@PathVariable("id") Long id) {
        Optional<Tache> tache = tacheServices.findTacheById(id);
        return new ResponseEntity(tache, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Tache> addTache(@RequestBody Tache tache) {
       Tache t = tacheServices.addTache(tache);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tache> updateTache(@RequestBody Tache tache) {
        Tache t = tacheServices.updateTache(tache);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTache(@PathVariable("id") Long id) {
        tacheServices.deleteTache(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



