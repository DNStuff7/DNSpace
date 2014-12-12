package com.exadel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exadel.user.base.MySQLInteraction;
import com.exadel.user.base.User;
 
@Controller
//@RequestMapping("/")
public class UserController {
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String printUsers(ModelMap model) {
		MySQLInteraction sql = new MySQLInteraction();
		List<User> users = sql.load();
        model.addAttribute("message", users);
        model.addAttribute("isEdit", false);
        return "users";
    }
    
    @RequestMapping(value = "users", method = RequestMethod.POST, params="action=Add")
    public String addUser(ModelMap model, @RequestParam String fname, @RequestParam String lname, @RequestParam String email) {
    	User user = new User();
    	user.setFirstName(fname);
    	user.setLastName(lname);
    	user.setEmail(email);
    	MySQLInteraction sql = new MySQLInteraction();
    	sql.save(user);
		List<User> users = sql.load();
        model.addAttribute("message", users);
        model.addAttribute("isEdit", false);
        return "users";
    }
    
    @RequestMapping(value = "users", method = RequestMethod.POST, params="action=Delete")
    public String delUser(ModelMap model, @RequestParam int id) {
    	MySQLInteraction sql = new MySQLInteraction();
    	sql.delete(id);
		List<User> users = sql.load();
        model.addAttribute("message", users);
        model.addAttribute("isEdit", false);
        return "users";
    }
    
    @RequestMapping(value = "users", method = RequestMethod.POST, params="action=Edit")
    public String editUser(ModelMap model, @RequestParam int id) {
    	MySQLInteraction sql = new MySQLInteraction();
    	User user = sql.getUser(id);
    	model.addAttribute("idEdit", id);
    	model.addAttribute("editFname", user.getFirstName());
    	model.addAttribute("editLname", user.getLastName());
    	model.addAttribute("editEmail", user.getEmail());
		List<User> users = sql.load();
        model.addAttribute("message", users);
        model.addAttribute("isEdit", true);
        return "users";
    }
    
    @RequestMapping(value = "users", method = RequestMethod.POST, params="action=Save")
    public String saveUser(ModelMap model, @RequestParam int idEdit, @RequestParam String fname, @RequestParam String lname, @RequestParam String email) {
    	MySQLInteraction sql = new MySQLInteraction();
    	User user = new User(); 
    	user.setUserID(idEdit);
    	user.setFirstName(fname);
    	user.setLastName(lname);
    	user.setEmail(email);
    	sql.update(user);
		List<User> users = sql.load();
        model.addAttribute("message", users);
        model.addAttribute("isEdit", true);
        return "users";
    }
}

