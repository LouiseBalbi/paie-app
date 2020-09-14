package dev.paie.web.bulletin;

import java.time.LocalDate;

import com.sun.istack.NotNull;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;

public class CreerBulletinSalaireResponseDto {
	

	private LocalDate dateCreation;
	
	private Integer id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String matricule;
	private double salaireBrut;
	private double netImposable;
	private double netAPayer;
	
	
	public CreerBulletinSalaireResponseDto(BulletinSalaire bulletin) {
		id=bulletin.getId();
		dateDebut=bulletin.getPeriode().getDateDebut();
		dateFin=bulletin.getPeriode().getDateFin();
		salaireBrut=bulletin.getSalaireBrut();
		netImposable=bulletin.getNetImposable();
		netAPayer=bulletin.getNetAPayer();
	}
	
	
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
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}


	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}


	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
	/**
	 * @return the salaireBrut
	 */
	public double getSalaireBrut() {
		return salaireBrut;
	}
	/**
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(double salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	/**
	 * @return the netImposable
	 */
	public double getNetImposable() {
		return netImposable;
	}
	/**
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(double netImposable) {
		this.netImposable = netImposable;
	}
	/**
	 * @return the netAPayer
	 */
	public double getNetAPayer() {
		return netAPayer;
	}
	/**
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(double netAPayer) {
		this.netAPayer = netAPayer;
	}
	
	

}
