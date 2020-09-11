package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Employe;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.exception.PaieException;
import dev.paie.repository.EmployeRepository;


@Service
public class EmployeService {
	
	private EmployeRepository employeRepo;
	private EntrepriseService entrepriseService;
	private ProfilService profilService;
	private GradeService gradeService;
	
	public EmployeService(EmployeRepository employeRepo, EntrepriseService entrepriseService, ProfilService profilService, GradeService gradeService) {
		super();
		this.employeRepo=employeRepo;
		this.entrepriseService=entrepriseService;
		this.profilService=profilService;
		this.gradeService=gradeService;
	}
	
	@Transactional
	public Employe creerEmploye(String matricule, Integer entrepriseId, Integer profilId, Integer gradeId) {
		
		List<String> messagesErreurs = new ArrayList<>();

		Optional<Entreprise> opEntreprise = entrepriseService.recupererEntreprise(entrepriseId);
		Optional<ProfilRemuneration> opProfil = profilService.recupererProfil(profilId);
		Optional<Grade> opGrade = gradeService.recupererGrade(profilId);
		

		if (!opEntreprise.isPresent() || !opProfil.isPresent() || !opGrade.isPresent()) {
			messagesErreurs.add("Les données ne sont pas correctes");
		}


		if (!messagesErreurs.isEmpty()) {
			throw new PaieException(messagesErreurs);
		}

		Employe emp = new Employe();
		emp.setMatricule(matricule);
		emp.setEntreprise(opEntreprise.get());
		emp.setProfil(opProfil.get());
		emp.setGrade(opGrade.get());
		

		return employeRepo.save(emp);
	}
	

}
