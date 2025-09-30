package camati.example.user_management_rbac.config;

import camati.example.user_management_rbac.application.services.user.UserService;
import camati.example.user_management_rbac.application.services.user.UserServiceImp;
import camati.example.user_management_rbac.domain.repositories.RoleRepository;
import camati.example.user_management_rbac.domain.repositories.UserRepository;
import camati.example.user_management_rbac.infrastructure.persistence.mappers.UserMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

 
 

  @Bean
  public UserService userService(UserRepository userRepository, RoleRepository roleRepository) {
    return new UserServiceImp(userRepository, roleRepository);
  }
}
