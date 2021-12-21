package HelloWorld.HelloWorld;

import java.util.List;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id; 
    private String username;
    private String email;
    private List<String> roles;


    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {

        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;

    }


    public String getAccessToken()
    {
        return token;
    }
    public void setAccessToken(String token)
    {
        this.token = token;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(long Id)
    {
        this.id = Id;

    }

    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getUserName()
    {
        return username;
    }
    public void setUserName(String username)
    {
        this.username = username;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<String> getRoles()
    {
        return roles;
    } 

    public void setRoles(List<String> roles)
    {
        this.roles = roles;

    }

    
}
