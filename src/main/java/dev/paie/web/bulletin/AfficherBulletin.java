package dev.paie.web.bulletin;

import java.time.LocalDate;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;


public class AfficherBulletin {

	
	private LocalDate dateCreation;
	private Periode periode;
	private String matricule;
	private double salaireBrut;
	private double salaireBase;
	private double netImposable;
	private double netAPayer;
	
	/**
	 * @param periode
	 * @param dateCreation
	 * @param matricule
	 * @param salaireBrut
	 * @param netImposable
	 * @param netAPayer
	 * @param salaireBase
	 */
	public AfficherBulletin(BulletinSalaire bulletinSalaire) {
		bulletinSalaire.calculateTousSalaires();
		periode = bulletinSalaire.getPeriode();
		matricule =bulletinSalaire.getMatricule();
		salaireBrut=bulletinSalaire.getSalaireBrut();
		netImposable=bulletinSalaire.getNetImposable();
		netAPayer=bulletinSalaire.getNetAPayer();
		salaireBase = bulletinSalaire.getSalaireBase();
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
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}

	/**
	 * @param periode the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
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
	 * @return the salaireBase
	 */
	public double getSalaireBase() {
		return salaireBase;
	}

	/**
	 * @param salaireBase the salaireBase to set
	 */
	public void setSalaireBase(double salaireBase) {
		this.salaireBase = salaireBase;
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
