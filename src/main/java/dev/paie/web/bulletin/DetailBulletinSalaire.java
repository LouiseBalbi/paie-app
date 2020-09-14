package dev.paie.web.bulletin;

import java.util.List;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Periode;

public class DetailBulletinSalaire {
	
	private Periode periode;
	private String nomEntreprise;
	private String siret;
	private String matricule;
	private double salaireBase;
	private double primeExceptionnelle;
	private List<Cotisation> cotisationsNonImposables;
	private double netImposable;
	private List<Cotisation> cotisationsImposables;
	private double netAPayer;
	
	
	
	/**
	 * @param periode
	 * @param nomEntreprise
	 * @param siret
	 * @param matricule
	 * @param salaireBase
	 * @param primeExceptionnelle
	 * @param cotisationNonImposables
	 * @param netImposable
	 * @param cotisationImposables
	 * @param netAPayer
	 */
	public DetailBulletinSalaire(BulletinSalaire bulletinSalaire) {
		super();
		this.periode = bulletinSalaire.getPeriode();
		this.nomEntreprise = bulletinSalaire.getRemunerationEmploye().getEntreprise().getDenomination();
		this.siret = bulletinSalaire.getRemunerationEmploye().getEntreprise().getSiret();
		this.matricule = bulletinSalaire.getMatricule();
		this.salaireBase = bulletinSalaire.getSalaireBase();
		this.primeExceptionnelle = bulletinSalaire.getPrimeExeptionnelle();

		for(Cotisation cotisation: bulletinSalaire.getRemunerationEmploye().getProfilRemuneration().getCotisations()) {
			if(cotisation.getImposable()) {
				this.cotisationsImposables.add(cotisation);
			} else {
				this.cotisationsNonImposables.add(cotisation);
			}
		}
		this.netImposable = bulletinSalaire.getNetImposable();
		this.netAPayer = bulletinSalaire.getNetAPayer();
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
	 * @return the nomEntreprise
	 */
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	/**
	 * @param nomEntreprise the nomEntreprise to set
	 */
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	/**
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}
	/**
	 * @param siret the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
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
	 * @return the primeExceptionnelle
	 */
	public double getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	/**
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(double primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
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
	 * @return the cotisationsNonImposables
	 */
	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}
	/**
	 * @param cotisationsNonImposables the cotisationsNonImposables to set
	 */
	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}
	/**
	 * @return the cotisationsImposables
	 */
	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}
	/**
	 * @param cotisationsImposables the cotisationsImposables to set
	 */
	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
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
