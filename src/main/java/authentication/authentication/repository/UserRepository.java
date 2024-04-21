package authentication.authentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import authentication.authentication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);

}
