package mobile.hectordevelopers.keita.response;

/*created by Hector Developers
06-08-2019
*/

import mobile.hectordevelopers.keita.enums.UserType;

public class ApiResponse {

    private int status;
    private String message;
    private Object result;
    private UserType userType;
    private String email;
    private String firstname;
    private long id;

    public ApiResponse(int status, String message, Object result, UserType userType, String email, String firstname, long id) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.userType = userType;
        this.email = email;
        this.firstname = firstname;
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public Object getResult() {
        return result;
    }

    public String getFirstname() {

        return firstname;
    }

    public Long getId() {
        return id;
    }
}