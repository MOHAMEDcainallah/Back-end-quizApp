package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.encasderreur.UserWithSameUsernameFoundException;
import com.exam.tablesdiawli.Role;
import com.exam.tablesdiawli.Utilisateur;
import com.exam.tablesdiawli.UserRole;
import com.exam.finkansawbolesfonctions.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncorder;
	
	@PostMapping("/")
	public Utilisateur createNewUser(@RequestBody Utilisateur theuser) throws Exception {
		try {
		Utilisateur user=this.userService.findUser(theuser.getUsername());
		if(user!=null) {
			throw new UserWithSameUsernameFoundException(theuser.getUsername());
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		theuser.setProfile("default.png");
		theuser.setPassword(this.bcryptPasswordEncorder.encode(theuser.getPassword()));
		Set<UserRole> userroles=new HashSet<>();
		Role role=new Role();
		role.setRoleName("USER");
		UserRole userrole=new UserRole();
		userrole.setRole(role);
		userrole.setUser(theuser);
		userroles.add(userrole);
		return this.userService.createUser(theuser, userroles);
		
	}
	
	@GetMapping("/{username}")
	public Utilisateur getUser(@PathVariable("username") String username) {
		return this.userService.findUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable("userId")Long userId) {
		this.userService.deleteUser(userId);
		return "user with userid "+userId+" is deleted successfully";
	}

}
