package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Service
public class GradeService {

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
}
