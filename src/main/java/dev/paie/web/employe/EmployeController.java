package dev.paie.web.employe;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Employe;
import dev.paie.exception.PaieException;
import dev.paie.service.EmployeService;


@RestController
@RequestMapping("employes")
public class EmployeController {
	
	private EmployeService employeService;

	/**
	 * @param employeService
	 */
	public EmployeController(EmployeService employeService) {
		super();
		this.employeService = employeService;
	}
	
	@PostMapping
	public ResponseEntity<?> employe(@RequestBody @Validated CreerEmployeRequestDto emp, BindingResult resValid) {

		if (!resValid.hasErrors()) {
			Employe employeCree = employeService.creerEmploye(emp.getMatricule(), emp.getEntrepriseId(), emp.getProfilId(), emp.getGradeId());
			CreerEmployeResponseDto employeResponse = new CreerEmployeResponseDto(employeCree);

			return ResponseEntity.ok(employeResponse);
		} else {
			return ResponseEntity.badRequest().body(" Tous les champs sont obligatoires !");
		}

	}

	@ExceptionHandler(PaieException.class)
	public ResponseEntity<List<String>> onPaieException(PaieException ex) {
		return ResponseEntity.badRequest().body(ex.getMessagesErreurs());

	}

}
