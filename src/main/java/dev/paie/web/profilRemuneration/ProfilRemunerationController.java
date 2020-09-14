package dev.paie.web.profilRemuneration;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.service.ProfilService;


@RestController
@RequestMapping("profils")
public class ProfilRemunerationController {

	private ProfilService pService;

	public ProfilRemunerationController(ProfilService pService) {
		this.pService = pService;
	}

	@GetMapping
	public ResponseEntity<?> getAllProfils() {

		List<ProfilRemuneration> listeP = pService.listerProfils();

		if (!listeP.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).header("message", "Profils trouvés").body(listeP);

		} else { // listeE.isEmpty = true
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun Profil enregistré en BDD ");
		}

	}
}
