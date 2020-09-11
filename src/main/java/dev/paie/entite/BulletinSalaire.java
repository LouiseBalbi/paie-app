package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
public class BulletinSalaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne
	private Periode periode;
	
	private BigDecimal primeExceptionnelle;
	
	private LocalDate dateCreation;
	private String matricule;
	private double salaireBase;
	private double salaireBrut;
	private double netImposable;
	private double netAPayer;
	private double primeExeptionnelle;
	private double retenueSalarialNonImposable = 0;
	private double retenueSalarialImposable = 0;

	
	
	
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the retenueSalarialNonImposable
	 */
	public double getRetenueSalarialNonImposable() {
		return retenueSalarialNonImposable;
	}
	/**
	 * @param retenueSalarialNonImposable the retenueSalarialNonImposable to set
	 */
	public void setRetenueSalarialNonImposable(double retenueSalarialNonImposable) {
		this.retenueSalarialNonImposable = retenueSalarialNonImposable;
	}
	/**
	 * @return the retenueSalarialImposable
	 */
	public double getRetenueSalarialImposable() {
		return retenueSalarialImposable;
	}
	/**
	 * @param retenueSalarialImposable the retenueSalarialImposable to set
	 */
	public void setRetenueSalarialImposable(double retenueSalarialImposable) {
		this.retenueSalarialImposable = retenueSalarialImposable;
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
	/**
	 * @return the primeExeptionnelle
	 */
	public double getPrimeExeptionnelle() {
		return primeExeptionnelle;
	}
	/**
	 * @param primeExeptionnelle the primeExeptionnelle to set
	 */
	public void setPrimeExeptionnelle(double primeExeptionnelle) {
		this.primeExeptionnelle = primeExeptionnelle;
	}

	private void calculateAndSetSalaireBase () {
		this.salaireBase = this.remunerationEmploye.getGrade().getNbHeuresBase().doubleValue() * this.remunerationEmploye.getGrade().getTauxBase().doubleValue();
	}
	
	private void calculateAndSetSalaireBrut () {
		this.salaireBrut = this.salaireBase + this.primeExeptionnelle;
	}
	
	public void calculateTousSalaires () {
		this.calculateAndSetSalaireBase();
		this.calculateAndSetSalaireBrut();
		this.calculateTotalRetenueSalarial();
		this.calculateNetImpossable();
		this.calculateNetAPayer();
	}
	
	public void calculateTotalRetenueSalarial () {
		for(Cotisation cotisation: this.remunerationEmploye.getProfilRemuneration().getCotisations()) {
			if(!cotisation.getImposable() && cotisation.getTauxSalarial() != null) {
				this.retenueSalarialNonImposable += cotisation.getTauxSalarial().doubleValue() * this.salaireBrut;
			} else if (cotisation.getTauxSalarial() != null){
				this.retenueSalarialImposable += cotisation.getTauxSalarial().doubleValue() * this.salaireBrut;
			}
		}
	}
	
	public void calculateNetImpossable () {
		this.netImposable = this.salaireBrut - this.retenueSalarialNonImposable;
	}
	
	public void calculateNetAPayer () {
		this.netAPayer = Math.round((this.netImposable - this.retenueSalarialImposable)* 100.0)/100.0;
	}
	
	
}
