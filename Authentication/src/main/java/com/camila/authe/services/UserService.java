package com.camila.authe.services;

import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.camila.authe.models.User;
import com.camila.authe.repositories.UserRepo;



@Service
public class UserService {

   @Autowired
   private final UserRepo userRepo;
    
   public UserService(UserRepo userRepo) {
	   this.userRepo= userRepo;
   }
   
 //ENCONTRAR USUARIO A TRAVÉS DE EMAIL                    
 	public User encontrarPorEmail(String email) {
 		return userRepo.findByEmail(email);
 	}
 	
 	public User encontrarUserPorId(Long id) {
 		Optional<User> user = userRepo.findById(id);
 		if(user.isPresent()) {
 			return user.get();
 		}
 		return null;
 	}

 	//REGISTRAR AL USUARIO
 	public User registroUsuario(User user, BindingResult resultado) {

 		User usuarioRegistrado = userRepo.findByEmail(user.getEmail());

 		if (usuarioRegistrado != null) {
 			resultado.rejectValue("email", "Matches", "Correo electronico ya existe");
 		}
 		if (!user.getPassword().equals(user.getPasswordConfirmation())) {
 			resultado.rejectValue("password", "Matches", "Password no coincide");
 		}
 		if (resultado.hasErrors()) {
 			return null;
 		}
 		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
 		user.setPassword(hashed);
 		return userRepo.save(user);

 	}

 	//AUTENTICAION DEL USUARIO (LOGIN)
 	public boolean authenthicateUser(String email, String password, BindingResult resultado) {

 		User usuarioRegistrado = userRepo.findByEmail(email);

 		if (usuarioRegistrado == null) {
 			resultado.rejectValue("email", "Matches", "Email no valido");
 			return false;
 		} else {
 			if (BCrypt.checkpw(password, usuarioRegistrado.getPassword())) {
 				return true;
 			} else {
 				resultado.rejectValue("password", "Matches", "Password no valido");
 				return false;
 			}
 		}
 	}

	}




