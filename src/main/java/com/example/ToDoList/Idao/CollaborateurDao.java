package com.example.ToDoList.Idao;

import com.example.ToDoList.beans.Collaborateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaborateurDao extends JpaRepository<Collaborateur,Long> {
    Collaborateur findByLoginAndPassword(String nom, String password);

}
