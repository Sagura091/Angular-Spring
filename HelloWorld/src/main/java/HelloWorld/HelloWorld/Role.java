package HelloWorld.HelloWorld;

import javax.persistence.*;
 
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    public Integer getId() {
        return id;
    }
    public ERole getName()
    {
        return name;
    }
     
    // remaining getters and setters   
}