package com.camila.authe.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Por favor completar el campo")
	@Email(message="El correo ingresado no es correcto")
    private String email;
	@NotBlank(message="Por favor completar el campo")
	@Size(min=8, message= "Password debe contener minimo 8 caracteres")
    private String password;
    @Transient
    @NotBlank(message="Por favor completar el campo")
    @Size(min=8, message= "Password debe contener minimo 8 caracteres")
    private String passwordConfirmation;
  
    
    
    //GETTERS Y SETTERS
    
    
    
    
    @Column(updatable=false)
    private Date createdAt;
   
	private Date updatedAt;
    
    
    
    public User() {
    	
    } 






    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



}                              
