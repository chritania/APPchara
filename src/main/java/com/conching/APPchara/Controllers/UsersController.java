package com.conching.APPchara.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.conching.APPchara.Model.Users;
import com.conching.APPchara.NotFoundException.UsersNotFoundException;
import com.conching.APPchara.Repository.UsersRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UsersController {

    UsersRepository repo;

    public UsersController(UsersRepository repo){
        this.repo = repo;
    }

    //httpp://127.0.0.1/users
    //Get all users
    @GetMapping("/users")
    public List<Users>getusers(){
        return repo.findAll();
    }
    
    //Get on user
    //http://127.0.0.1:8080/users/2
    @GetMapping("/users/{id}")
    public Users geUsersById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new UsersNotFoundException(id));
    }

    //http:127.0.0.1:8080/users/new
    @PostMapping("/users/new")
    public String addUsers(@RequestBody Users newUsers){
        repo.save(newUsers);
        return "A new users is added. Yey!";
    }

    //Update endpoint
    //http://127.0,0.1:8080/users/edit/1
    @PutMapping("/users/edit/{id}")
    public Users updateUsers(@PathVariable Long id,
    @RequestBody Users newUsers){
        return repo.findById(id)
        .map(users ->{
            users.setUserName(newUsers.getUserName());
            users.setAddress(newUsers.getAddress());
            users.setContactNumber(newUsers.getContactNumber());
            return repo.save(users);
        }).orElseGet(()->{
            return repo.save(newUsers);
        });
    }

    //Delete endpoint
    //http:///127.0.0.1:8080/users/delete/1
    @DeleteMapping("/users/delete/{id}")
    public String deleteUsers(@PathVariable Long id){
        repo.deleteById(id);
        return "A users is deleted!";
    }
}