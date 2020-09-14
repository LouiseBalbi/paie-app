package dev.paie.web.bulletin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import dev.paie.entite.BulletinSalaire;
import dev.paie.exception.PaieException;
import dev.paie.service.BulletinSalaireService;
;

@RestController
@RequestMapping("bulletins")
public class BulletinController {
	
	private BulletinSalaireService bulletinSalaireService;
	
		/**
	 * @param bulletinSalaireService
	 */
	public BulletinController(BulletinSalaireService bulletinSalaireService) {
		super();
		this.bulletinSalaireService = bulletinSalaireService;
	}
	


	@GetMapping
	public List<AfficherBulletin> listeBulletins(@RequestParam Integer start,
			@RequestParam Integer size){
		
		List<BulletinSalaire> bulletinSalaireList = this.bulletinSalaireService.listerBulletinsSalaire(start, size);
		
		List<AfficherBulletin> bulletinList = new ArrayList<>();

		
		for(BulletinSalaire bulletinSalaire : bulletinSalaireList) {
			
	
			AfficherBulletin bulletin = new AfficherBulletin(bulletinSalaire);
						
			bulletinList.add(bulletin);
				
		}

		return bulletinList;
	}
	
	


	@PostMapping
	public ResponseEntity<?> bulletins(@RequestBody CreerBulletinSalaireRequestDto bul, BindingResult resValid) {

		if (!resValid.hasErrors()) {
			BulletinSalaire bulletinCree = bulletinSalaireService.creerBulletinSalaire(bul.getDateCreation(), bul.getPeriodeId(), bul.getMatricule());
			CreerBulletinSalaireResponseDto bulletinResponse = new CreerBulletinSalaireResponseDto(bulletinCree);

			return ResponseEntity.ok(bulletinResponse);
		} else {
			return ResponseEntity.badRequest().body(" Tous les champs sont obligatoires !");
		}

	}
	
	@ExceptionHandler(PaieException.class)
	public ResponseEntity<List<String>> onPaieException(PaieException ex) {
		return ResponseEntity.badRequest().body(ex.getMessagesErreurs());
	}
	
}
