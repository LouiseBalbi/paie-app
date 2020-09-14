package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;
import dev.paie.web.profilRemuneration.ProfilRemunerationReponseDto;

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
	
	public List<ProfilRemuneration> listerProfils() {

		List<ProfilRemuneration> list = new ArrayList();

		List<ProfilRemuneration> listProfils = profilRepo.findAll();

		for (ProfilRemuneration profil : listProfils) {
			list.add(profil);
		}
		return list;
	}

}
