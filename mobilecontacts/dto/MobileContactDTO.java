package gr.aueb.cf.ch18.mobilecontacts.dto;

public class MobileContactDTO {
    private Long mobileContactID;
    private UserDetailsDTO userDetailsDTO;
    private String phoneNumber;

    public MobileContactDTO(){}
    public Long getMobileContactID() {
        return mobileContactID;
    }
    public void setMobileContactID(Long mobileContactID) {
        this.mobileContactID = mobileContactID;
    }
    public UserDetailsDTO getUserDetailsDTO() {
        return userDetailsDTO;
    }
    public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}