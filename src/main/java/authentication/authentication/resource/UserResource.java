package authentication.authentication.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import authentication.authentication.model.User;
import authentication.authentication.repository.UserRepository;
import authentication.authentication.service.CreateUserService;

@RestController
@RequestMapping("/users")
public class UserResource {

  @Autowired
  private UserRepository repository;

  @Autowired
  private CreateUserService createUserService;

  @GetMapping("/nomes")
  public List <User> findAll() {
    List<User> list = repository.findAll();
    return list;
  }

  

  @PostMapping("/create")
  public User create(@RequestBody User user) {
    return createUserService.create(user);
  }

  @PutMapping("/{id}")
  public User update(@RequestBody User obj){
    User objSaved = createUserService.update(obj);
    return createUserService.update(objSaved);

  }

  @DeleteMapping("/{id}")
  //@ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){
    createUserService.delete(id);
  }

}
