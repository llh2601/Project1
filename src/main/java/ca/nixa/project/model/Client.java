package ca.nixa.project.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="clients")
public class Client {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer id;
 	
 private String nom;
 private String prenom;
 private String telephone;
 private Date datePriseContact;
 
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Date getDatePriseContact() {
	return datePriseContact;
}
public void setDatePriseContact(Date datePriseContact) {
	this.datePriseContact = datePriseContact;
}
	
}

