package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;



@Controller
public class UsersController {


    private static HashMap<Integer, UserEntity> hash_map = new HashMap<Integer, UserEntity>();

    @RequestMapping("/users")
    @ResponseBody
    public HashMap<Integer, UserEntity> getList(){

        return hash_map;
    }
    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public String getOne(@PathVariable int id){


        return "User: Name: "+ hash_map.get(id).getName() + " Age: "+ hash_map.get(id).getAge();
    }
    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public String remove(@PathVariable int id){

        hash_map.remove(id);
        return "User with id "+ id + " deleted";
    }
    @RequestMapping("/users/add")
    @ResponseBody
    public String add(@RequestParam String name, @RequestParam Integer age){
        int temp =1;
        for (int key:hash_map.keySet())
        {
            temp = key;
        }

        if(!hash_map.containsKey(temp)){
            hash_map.put(temp,new UserEntity(name,age));
            temp++;
        }
        else {
            temp++;
            hash_map.put(temp,new UserEntity(name,age));

        }


        return "User " + name +" "+ age+" added";

    }


}
