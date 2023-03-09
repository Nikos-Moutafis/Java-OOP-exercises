package gr.aueb.cf.ch18.mobilecontacts.dto;

public class UserDetailsDTO {
    private long userDetailsId;
    private String firstname;
    private String lastname;

    public  UserDetailsDTO(){}

    public long getUserDetailsId() {
        return userDetailsId;
    }
    public void setUserDetailsId(long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
