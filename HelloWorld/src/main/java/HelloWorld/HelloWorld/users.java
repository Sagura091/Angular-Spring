package HelloWorld.HelloWorld;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    })
public class users {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @NotBlank(message = "Name may not be blank")
    @Size(max = 20)
	private String username;

    @NotBlank(message = "Name may not be blank")
    @Size(max = 50)
    @Email
    private String email;


    @NotBlank(message = "Name may not be blank")
    @Size(max = 120)
	private String password;
	

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    
  public users() {
}

public users(String username, String email, String password) {
  this.username = username;
  this.email = email;
  this.password = password;
}

    public long getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Set<Role> getRoles()
    {
        return roles;
    }
    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public users orElseThrow(Object object) {
        return null;
    }


}
