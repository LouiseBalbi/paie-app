package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

@Service
public class PeriodeService {

	private PeriodeRepository periodeRepo;

	/**
	 * @param periodeRepo
	 */
	public PeriodeService(PeriodeRepository periodeRepo) {
		super();
		this.periodeRepo = periodeRepo;
	}
	
	public Optional<Periode> recupererPeriode(Integer id){
		return this.periodeRepo.findById(id);
	}
	
	public List<Periode> listerPeriode() {
		return periodeRepo.findAll();
	}
}
