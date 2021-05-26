package mobile.hectordevelopers.keita.dto;

import javax.validation.constraints.NotBlank;

/*created by Hector Developers
06-08-2019
*/

public class LoginDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}