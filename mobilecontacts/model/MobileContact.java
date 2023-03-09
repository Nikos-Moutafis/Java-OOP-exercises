package gr.aueb.cf.ch18.mobilecontacts.model;

public class MobileContact extends AbstractEntity{
    private UserDetails userDetails;
    private String phoneNumber;

    public MobileContact(){}

    public UserDetails getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "MobileContact{" +
                "id = " + getId() + ", " +
                "userDetails=" + userDetails +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileContact that = (MobileContact) o;

       /* if (getUserDetails() != null ? !getUserDetails().equals(that.getUserDetails()) : that.getUserDetails() != null)
            return false;
        return getPhoneNumber().equals(that.getPhoneNumber());*/
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
//        int result = getUserDetails() != null ? getUserDetails().hashCode() : 0;
//        result = 31 * result + getPhoneNumber().hashCode();
        return getId().hashCode();
    }
}
