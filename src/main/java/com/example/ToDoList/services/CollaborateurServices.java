package com.example.ToDoList.services;

import com.example.ToDoList.Idao.CollaborateurDao;
import com.example.ToDoList.beans.Collaborateur;

import com.example.ToDoList.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CollaborateurServices {

    private final CollaborateurDao collaborateurDao;
    @Autowired
    public CollaborateurServices(CollaborateurDao collaborateurDao){
        this.collaborateurDao=collaborateurDao;
    }

    public Collaborateur addCollaborateur(Collaborateur collaborateur) {
        return collaborateurDao.save(collaborateur);
    }
    public List<Collaborateur> findAllCollaborateurs(){
        return collaborateurDao.findAll();

    }
    public Collaborateur findByLoginAndPassword(Collaborateur collaborateur){
        return collaborateurDao.findByLoginAndPassword(collaborateur.getLogin(),collaborateur.getPassword());
    }
    public Collaborateur updateCollaborateur(Collaborateur collaborateur){
        return collaborateurDao.save(collaborateur);
    }
    public Optional<Collaborateur> findCollaborateurById (long id){
        return collaborateurDao.findById(id);
    }
    public void deleteCollaborateur(long id){
        collaborateurDao.deleteById(id);
    }


}
