package com.fredy.projectbackend.Security;



import com.fredy.projectbackend.Models.User;
import com.fredy.projectbackend.Models.UserRole;
import com.fredy.projectbackend.Repositories.RoleRepository;
import com.fredy.projectbackend.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findByUsername(user.getUsername());

        if(localUser!= null){
            LOG.info("User {} already exists", user.getUsername());
        }else{
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            localUser=userRepository.save(user);
        }
        return localUser;
    }
}
