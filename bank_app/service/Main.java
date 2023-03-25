package gr.aueb.cf.ch18.exercise.service;

import gr.aueb.cf.ch18.exercise.dao.AccountDAOImpl;
import gr.aueb.cf.ch18.exercise.dao.IAccountDAO;
import gr.aueb.cf.ch18.exercise.dto.AccountDTO;
import gr.aueb.cf.ch18.exercise.dto.UserDTO;
import gr.aueb.cf.ch18.exercise.service.exceptions.InsufficientAmountException;
import gr.aueb.cf.ch18.exercise.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnExistsException;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnNotValidException;

public class Main {

    public static void main(String[] args) {
        ///Create DTO for account and User
        AccountDTO accountDTO = new AccountDTO();
        UserDTO userDTO = new UserDTO();

        //Set Account's DTO
        accountDTO.setAccountId(1L);
        accountDTO.setBalance(1200);
        accountDTO.setIban("gr");

        //Set User's/Holder's DTO  details
        userDTO.setFirstname("Nikos");
        userDTO.setLastname("Moutafis");
        userDTO.setSsn("GR");

        //Set Account's DTO with userDTO
        accountDTO.setUserDTO(userDTO);

        //Create second DTO for account and user
        AccountDTO accountDTO1 = new AccountDTO();
        UserDTO userDTO1 = new UserDTO();

        //Set second's Account's DTO
        accountDTO1.setAccountId(2L);
        accountDTO1.setBalance(30000);
        accountDTO1.setIban("064");

        //Set  second's User's/Holder's DTO  details
        userDTO1.setFirstname("Vasilis");
        userDTO1.setLastname("Papakonstantinou");
        userDTO1.setSsn("GR1");

        //Set second's Account's DTO with userDTO
        accountDTO1.setUserDTO(userDTO1);




        //Create DAO instance
        IAccountDAO iAccountDAO = new AccountDAOImpl();
        IAccountService iAccountService = new AccountServiceImpl(iAccountDAO);

        try {
            iAccountService.create(accountDTO);

          iAccountService.create(accountDTO1); //SsnExistsException a because an account with ssn : GR already exists

            //deposit and get balance(with ssn) after deposit
            iAccountService.deposit(accountDTO,5800);
            System.out.println("successful deposit");
            System.out.println("balance after deposit : " + iAccountService.getBalance("GR"));

            System.out.println(iAccountService.getIban("GR"));// Get iban using ssn
//          iAccountService.getIban("eager"); SsnNotValidException because there isn't account with eager ssn

            //Gets account's state using ssn
            System.out.println( iAccountService.getAccountState("GR"));

            //Withdraw and get balance(with ssn)  after withdraw
            iAccountService.withdraw(accountDTO,6900);
            System.out.println("balance after withdraw : " + iAccountService.getBalance("GR"));
//          iAccountService.withdraw(accountDTO,4500); InsufficientBalanceException because balance is smaller than  withdrawal amount

//           iAccountService.deposit(accountDTO,0); InsufficientAmountException because the amount to be deposited is 0 or less


            System.out.println(iAccountService.getBalance("GR1"));
            iAccountService.withdraw(accountDTO1,1500);
            System.out.println(iAccountService.getBalance("GR1"));
            iAccountService.deposit(accountDTO1,25000);
            System.out.println(iAccountService.getBalance("GR1"));
            iAccountService.withdraw(accountDTO1,1239);
            System.out.println(iAccountService.getBalance("GR1"));
            iAccountService.deposit(accountDTO,100) ;
        System.out.println(iAccountService.getBalance("GR"));

        }catch (InsufficientAmountException | SsnNotValidException | InsufficientBalanceException | SsnExistsException e){
            System.out.println("error");
        }
    }
}
