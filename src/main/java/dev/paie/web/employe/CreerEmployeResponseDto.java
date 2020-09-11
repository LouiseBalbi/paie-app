package dev.paie.web.employe;



import dev.paie.entite.Employe;



public class CreerEmployeResponseDto {
	
	private Integer id;
	private String Matricule;
	private String Entreprise;
	private String Grade;
	private String Profil;

	
	public CreerEmployeResponseDto(Employe emp) {
		id = emp.getId();
		Matricule = emp.getMatricule();
		Entreprise = emp.getEntreprise().getDenomination();
		Grade = emp.getGrade().getCode();
		Profil = emp.getProfil().getCode();
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


	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return Matricule;
	}


	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		Matricule = matricule;
	}


	/**
	 * @return the entreprise
	 */
	public String getEntreprise() {
		return Entreprise;
	}


	/**
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(String entreprise) {
		Entreprise = entreprise;
	}


	/**
	 * @return the grade
	 */
	public String getGrade() {
		return Grade;
	}


	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}


	/**
	 * @return the profil
	 */
	public String getProfil() {
		return Profil;
	}


	/**
	 * @param profil the profil to set
	 */
	public void setProfil(String profil) {
		Profil = profil;
	}
	
	
	

}
