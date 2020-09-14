package dev.paie.web.bulletin;

import java.time.LocalDate;

import com.sun.istack.NotNull;

import dev.paie.entite.Periode;

public class CreerBulletinSalaireRequestDto {
	
	
	@NotNull
	private LocalDate dateCreation;
	
	@NotNull
	private Integer periodeId;
	
	@NotNull
	private String matricule;

	/**
	 * @return the dateCreation
	 */
	public LocalDate getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}



	/**
	 * @return the periodeId
	 */
	public Integer getPeriodeId() {
		return periodeId;
	}

	/**
	 * @param periodeId the periodeId to set
	 */
	public void setPeriodeId(Integer periodeId) {
		this.periodeId = periodeId;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	

}
