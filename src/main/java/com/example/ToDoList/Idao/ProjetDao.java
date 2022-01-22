package com.example.ToDoList.Idao;

import com.example.ToDoList.beans.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetDao extends JpaRepository<Projet,Long> {
}
