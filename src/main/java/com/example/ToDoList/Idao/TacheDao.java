package com.example.ToDoList.Idao;

import com.example.ToDoList.beans.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheDao extends JpaRepository<Tache,Long> {
}
