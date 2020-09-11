package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

@Service
public class ProfilService {
	
	private ProfilRepository profilRepo;

	/**
	 * @param profilRepo
	 */
	public ProfilService(ProfilRepository profilRepo) {
		super();
		this.profilRepo = profilRepo;
	}
	
	public Optional<ProfilRemuneration> recupererProfil(Integer id){
		return this.profilRepo.findById(id);
	}

}
