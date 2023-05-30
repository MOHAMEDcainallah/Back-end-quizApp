package com.exam.finkansawbolesfonctions.servicesdialquizz;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.tablesdiawli.Utilisateur;
import com.exam.tablesdiawli.UserRole;
import com.exam.fonctionsautomatique.RoleRepository;
import com.exam.fonctionsautomatique.UserRepository;
import com.exam.finkansawbolesfonctions.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public Utilisateur createUser(Utilisateur user, Set<UserRole> userRoles) throws Exception {
		
		Utilisateur theUser=this.userRepository.findByUsername(user.getUsername());
		
		if(theUser!=null) {
			System.out.println("This username is already exit");
			throw new Exception("this username already exist try again");
		}
		
		else {
			for(UserRole userrole:userRoles) {
				this.roleRepository.save(userrole.getRole());
			}
			user.getUserRole().addAll(userRoles);
			theUser=this.userRepository.save(user);
		}
		return theUser;
	}

    public Utilisateur findUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}

	public void deleteUser(Long id) {
		
		 this.userRepository.deleteById(id);
	}

}