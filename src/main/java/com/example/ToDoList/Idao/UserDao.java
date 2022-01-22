package com.example.ToDoList.Idao;

import com.example.ToDoList.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findByLoginAndPassword(String nom, String password);
}
