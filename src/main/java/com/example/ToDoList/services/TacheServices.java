package com.example.ToDoList.services;

import com.example.ToDoList.Idao.TacheDao;
import com.example.ToDoList.beans.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TacheServices {

    private final TacheDao tacheDao;
    @Autowired
    public TacheServices(TacheDao tacheDao){
        this.tacheDao=tacheDao;
    }

    public Tache addTache(Tache tache) {
        return tacheDao.save(tache);
    }
    public List<Tache> findAllTaches(){
        return tacheDao.findAll();

    }
    public Tache updateTache(Tache tache){
        return tacheDao.save(tache);
    }
    public Optional<Tache> findTacheById (long id){
        return tacheDao.findById(id);
    }
    public void deleteTache(long id){
        tacheDao.deleteById(id);
    }


}
