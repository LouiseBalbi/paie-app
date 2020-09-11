package dev.paie.web.bulletin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.BulletinSalaire;

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
	
	

	

	
}
