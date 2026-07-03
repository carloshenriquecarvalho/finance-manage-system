package br.com.nexus.finance_manage_system.user;

import br.com.nexus.finance_manage_system.security.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


}
