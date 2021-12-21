package HelloWorld.HelloWorld;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;



@Repository
public interface usersRepository extends JpaRepository<users,Long> {
    
    users findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
