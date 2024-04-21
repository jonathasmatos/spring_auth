package authentication.authentication.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import authentication.authentication.model.User;
import authentication.authentication.repository.UserRepository;

@Service
public class CreateUserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

  public User create(User obj) {

    User existsUser = userRepository.findByUsername(obj.getUsername());

    if (existsUser != null) {
      throw new Error("Usuario Existente!");
    }

    obj.setPassword(passwordEncoder().encode(obj.getPassword()));

    User createdUser = userRepository.save(obj);

    return createdUser;
  }

  public User update(@RequestBody User obj) {
		
		User objSaved =  findById(obj.getId());

    if (!obj.getId().equals(objSaved.getId()) ) {
			throw new Error("Já existe um usuário cadastrado com este userName.");
		}
		
		
		BeanUtils.copyProperties(obj, objSaved, "id", "password", "username");
		
		return userRepository.save(objSaved);
	}
  

}
