package dev.paie.web.employe;



import dev.paie.entite.Employe;



public class CreerEmployeResponseDto extends CreerEmployeRequestDto{
	
	private Integer id;

	
	public CreerEmployeResponseDto(Employe emp) {
		id = emp.getId();
		this.matricule = emp.getMatricule();
		this.setEntrepriseId(emp.getEntreprise().getId());
		this.setProfilId(emp.getProfil().getId());
		this.setGradeId(emp.getGrade().getId());
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
