package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;
import dev.paie.web.grade.GradeReponseDto;

@Service
public class GradeService {
	
	private static final String NB_MOIS_ANNEE = "12";

	private GradeRepository gradeRepo;

	
	/**
	 * @param gradeRepo
	 */
	public GradeService(GradeRepository gradeRepo) {
		super();
		this.gradeRepo = gradeRepo;
	}



	public Optional<Grade> recupererGrade(Integer id){
		return this.gradeRepo.findById(id);
	}
	
	public List<GradeReponseDto> listerGrades() {

		List<GradeReponseDto> listeDto = new ArrayList<>();

		List<Grade> listeGrade = gradeRepo.findAll();

		for (Grade grade : listeGrade) {
			BigDecimal salaireAnnuel = grade.getNbHeuresBase().multiply(grade.getTauxBase()).multiply(new BigDecimal(NB_MOIS_ANNEE));
			listeDto.add(new GradeReponseDto(grade.getCode(), salaireAnnuel));
		}
		return listeDto;
	}
}
