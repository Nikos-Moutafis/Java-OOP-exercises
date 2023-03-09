package gr.aueb.cf.ch18.mobilecontacts.service;

import gr.aueb.cf.ch18.mobilecontacts.dao.IMobileContactDAO;
import gr.aueb.cf.ch18.mobilecontacts.dao.MobileContactDAOImpl;
import gr.aueb.cf.ch18.mobilecontacts.dto.MobileContactDTO;
import gr.aueb.cf.ch18.mobilecontacts.dto.UserDetailsDTO;
import gr.aueb.cf.ch18.mobilecontacts.service.exceptions.ContactNotFoundException;
import gr.aueb.cf.ch18.mobilecontacts.service.exceptions.PhoneNumberAlreadyExistsException;
import gr.aueb.cf.ch18.mobilecontacts.service.exceptions.UserIdAlreadyExistsException;

public class Main {

    public static void main(String[] args) {
        //Create DTOs for contact and userDetails
        MobileContactDTO mobileContactDTO = new MobileContactDTO();
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        //set contact's DTO
        mobileContactDTO.setMobileContactID(1L);
        mobileContactDTO.setPhoneNumber("123456789");

        //set userDetailsDTO
        userDetailsDTO.setFirstname("Nikos");
        userDetailsDTO.setLastname("Moutafis");
        userDetailsDTO.setUserDetailsId(1L);

        //set contact's DTO
        mobileContactDTO.setUserDetailsDTO(userDetailsDTO);

        //Create second DTO for contact and userDetails
        MobileContactDTO mobileContactDTO1 = new MobileContactDTO();
        UserDetailsDTO userDetailsDTO1 = new UserDetailsDTO();

        //set second's contact's DTO
        mobileContactDTO1.setMobileContactID(2L);
        mobileContactDTO1.setPhoneNumber("123456789");

        //set second's userDetailsDTO
        userDetailsDTO1.setFirstname("Andreas");
        userDetailsDTO1.setLastname("Niniadis");
        userDetailsDTO1.setUserDetailsId(2L);

        //set  second's contact's DTO
        mobileContactDTO1.setUserDetailsDTO(userDetailsDTO1);

        //Create third DTOs for contact and userDetails
        MobileContactDTO mobileContactDTO2 = new MobileContactDTO();
        UserDetailsDTO userDetailsDTO2 = new UserDetailsDTO();

        //set third's contact's DTO
        mobileContactDTO2.setMobileContactID(3L);
        mobileContactDTO2.setPhoneNumber("987654321");

        //set third's userDetailsDTO
        userDetailsDTO2.setFirstname("Marios");
        userDetailsDTO2.setLastname("Papakonstantinou");
        userDetailsDTO2.setUserDetailsId(3L);

        //set  third's contact's DTO
        mobileContactDTO2.setUserDetailsDTO(userDetailsDTO2);




        //Create DAO instance
        IMobileContactDAO iMobileContactDAO =  new MobileContactDAOImpl();

        //Inject DAO instance
        IMobileContactService iMobileContactService = new MobileContactServiceImpl(iMobileContactDAO);
        try {
            //Insert first contact
            iMobileContactService.insertMobileContact(mobileContactDTO);

           // iMobileContactService.insertMobileContact(mobileContactDTO1); PhoneNumberAlreadyExistsException because they have the same number

            //Get contact successfully with phoneNumber
            System.out.println(iMobileContactService.getContact("123456789"));

            //set new number for contact
            mobileContactDTO.setPhoneNumber("21341");
            //System.out.println(iMobileContactService.getContact("21341"));ContactNotFoundException because the contact hasn't been updated

            //Update the contact and get it successfully
            iMobileContactService.updateContact(mobileContactDTO);
            System.out.println(iMobileContactService.getContact("21321674"));

            //insert second contact, now it can be inserted because it doesn't have same number with first contact anymore
            iMobileContactService.insertMobileContact(mobileContactDTO1);

            //Insert third contact
            iMobileContactService.insertMobileContact(mobileContactDTO2);

            //Get all three contacts
            System.out.println(iMobileContactService.getAllContacts());
        }catch (PhoneNumberAlreadyExistsException | UserIdAlreadyExistsException  | ContactNotFoundException e){
            System.out.println("error");
        }

    }
}
