package dev.paie.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;

@Service
public class BulletinSalaireService {
	
	private BulletinSalaireRepository BulletinRepo;

	/**
	 * @param bulletinRepo
	 */
	public BulletinSalaireService(BulletinSalaireRepository bulletinRepo) {
		super();
		BulletinRepo = bulletinRepo;
	}
	
	public List<BulletinSalaire> listerBulletinsSalaire(Integer numreoPage, Integer taille){
		return BulletinRepo.findAll(PageRequest.of(numreoPage, taille)).getContent();
	}


}
