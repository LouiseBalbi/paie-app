package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Employe;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.exception.PaieException;
import dev.paie.repository.BulletinSalaireRepository;

@Service
public class BulletinSalaireService {
	
	private BulletinSalaireRepository BulletinRepo;
	private PeriodeService periodeService;

//	/**
//	 * @param bulletinRepo
//	 */
//	public BulletinSalaireService(BulletinSalaireRepository bulletinRepo) {
//		super();
//		BulletinRepo = bulletinRepo;
//	}

	/**
 * @param bulletinRepo
 * @param periodeService
 */
public BulletinSalaireService(BulletinSalaireRepository bulletinRepo, PeriodeService periodeService) {
	super();
	BulletinRepo = bulletinRepo;
	this.periodeService = periodeService;
}



	public List<BulletinSalaire> listerBulletinsSalaire(Integer numreoPage, Integer taille){
		return BulletinRepo.findAll(PageRequest.of(numreoPage, taille)).getContent();
	}

	@Transactional
	public BulletinSalaire creerBulletinSalaire(LocalDate dateCreation, Integer periodeId, String matricule) {
		
		List<String> messagesErreurs = new ArrayList<>();

		Optional<Periode> opPeriode = periodeService.recupererPeriode(periodeId);
		
		

		if (!opPeriode.isPresent()) {
			messagesErreurs.add("Les données ne sont pas correctes");
		}


		if (!messagesErreurs.isEmpty()) {
			throw new PaieException(messagesErreurs);
		}

		BulletinSalaire bull = new BulletinSalaire();
		bull.setDateCreation(dateCreation);
		bull.setMatricule(matricule);
		bull.setPeriode(opPeriode.get());
		

		return BulletinRepo.save(bull);
	}
	
	
	public Optional<BulletinSalaire> recupererBulletin(Integer id){
		return this.BulletinRepo.findById(id);
	}


}
