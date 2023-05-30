package com.exam.finkansawbolesfonctions.servicesdialquizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.encasderreur.UserNotFoundException;
import com.exam.tablesdiawli.Utilisateur;
import com.exam.fonctionsautomatique.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository theuserrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur theuser=this.theuserrepository.findByUsername(username);
		
		if(theuser==null) {
			System.out.println("user not found");
			try {
				throw new UserNotFoundException(username);
			} catch (UserNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		return theuser;
	}

	
}
