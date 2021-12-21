package HelloWorld.HelloWorld;

import org.springframework.security.core.userdetails.UserDetails;

public interface usersService {
    

    public abstract UserDetails  loadUserByUserName(String userName);
}
