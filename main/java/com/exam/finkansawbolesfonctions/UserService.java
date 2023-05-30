package com.exam.finkansawbolesfonctions;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.tablesdiawli.Utilisateur;

import com.exam.tablesdiawli.UserRole;

@Service
public interface UserService {
	
	public Utilisateur createUser(Utilisateur user, Set<UserRole>userRoles) throws Exception;
    
	public Utilisateur findUser(String username);
	
	public void deleteUser(Long id);
}