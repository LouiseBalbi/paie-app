package dev.paie.web.profilRemuneration;

import java.util.ArrayList;
import java.util.List;

import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;

public class ProfilRemunerationReponseDto {

	private int id;

	public ProfilRemunerationReponseDto(ProfilRemuneration profilRemu) {
		this.id = profilRemu.getId();
	

		List<Integer> listIdCotisations = new ArrayList<>();
		for (Cotisation c : profilRemu.getCotisations()) {
			listIdCotisations.add(c.getId());
		}

		List<Integer> listIdAvantages = new ArrayList<>();
		for (Avantage a : profilRemu.getAvantages()) {
			listIdAvantages.add(a.getId());
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
