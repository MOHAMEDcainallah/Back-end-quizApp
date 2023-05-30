package com.exam.fonctionsautomatique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.tablesdiawli.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

	public Utilisateur findByUsername(String username);

}
