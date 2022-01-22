package com.example.ToDoList.services;

import com.example.ToDoList.Idao.ProjetDao;
import com.example.ToDoList.beans.Projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProjetServices {

    private final ProjetDao projetDao;
    @Autowired
    public ProjetServices(ProjetDao projetDao){
        this.projetDao=projetDao;
    }

    public Projet addProjet(Projet projet) {
        return projetDao.save(projet);
    }
    public List<Projet> findAllProjets(){
        return projetDao.findAll();

    }
    public Projet updateProjet(Projet projet){
        return projetDao.save(projet);
    }
    public Optional<Projet> findProjetById (long id){
        return projetDao.findById(id);
    }
    public void deleteProjet(long id){
        projetDao.deleteById(id);
    }


}
