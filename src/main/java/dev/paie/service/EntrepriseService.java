package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

@Service
public class EntrepriseService {
	
	private EntrepriseRepository entrepriseRepo;

	/**
	 * @param entrepriseRepo
	 */
	public EntrepriseService(EntrepriseRepository entrepriseRepo) {
		super();
		this.entrepriseRepo = entrepriseRepo;
	}
	

	public Optional<Entreprise> recupererEntreprise(Integer id){
		return this.entrepriseRepo.findById(id);
	}
}
