package com.example.ToDoList.WS;

import com.example.ToDoList.beans.Collaborateur;
import com.example.ToDoList.beans.User;
import com.example.ToDoList.services.CollaborateurServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/collaborateur")
public class CollaborateurWs {
    private final CollaborateurServices collaborateurServices;
    @Autowired
    public CollaborateurWs(CollaborateurServices collaborateurServices){
        this.collaborateurServices=collaborateurServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Collaborateur>> getAllCollaborateursByTicket () {
        List<Collaborateur> collaborateur = collaborateurServices.findAllCollaborateurs();
        return new ResponseEntity<>(collaborateur, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collaborateur> getCollaborateurById (@PathVariable("id") Long id) {
        Optional<Collaborateur> Collaborateur = collaborateurServices.findCollaborateurById(id);
        return new ResponseEntity(Collaborateur, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Collaborateur> login (@RequestBody Collaborateur collaborateur) {
        Collaborateur c = collaborateurServices.findByLoginAndPassword(collaborateur);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Collaborateur> addCollaborateur(@RequestBody Collaborateur collaborateur) {
        Collaborateur c = collaborateurServices.addCollaborateur(collaborateur);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Collaborateur> updateCollaborateur(@RequestBody Collaborateur Collaborateur) {
        Collaborateur c = collaborateurServices.updateCollaborateur(Collaborateur);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCollaborateur(@PathVariable("id") Long id) {
        collaborateurServices.deleteCollaborateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



