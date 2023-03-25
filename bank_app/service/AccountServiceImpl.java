package gr.aueb.cf.ch18.exercise.service;

import gr.aueb.cf.ch18.exercise.dao.IAccountDAO;
import gr.aueb.cf.ch18.exercise.dto.AccountDTO;
import gr.aueb.cf.ch18.exercise.dto.UserDTO;
import gr.aueb.cf.ch18.exercise.model.Account;
import gr.aueb.cf.ch18.exercise.model.User;
import gr.aueb.cf.ch18.exercise.service.exceptions.InsufficientAmountException;
import gr.aueb.cf.ch18.exercise.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnExistsException;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnNotValidException;

import java.util.List;

public class AccountServiceImpl implements IAccountService{

    private final IAccountDAO dao;


    public AccountServiceImpl(IAccountDAO dao){
        this.dao = dao;
    }


    @Override
    public Account create(AccountDTO accountDTO) throws SsnExistsException {
        Account account;

        try{
            account = new Account();
            mapAccount(account,accountDTO);

            if (dao.ssnExists(accountDTO.getUserDTO().getSsn())){
                throw new SsnExistsException(account);
            }
            return dao.create(account);
        }catch (SsnExistsException e){
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void delete(String iban) {
        dao.delete(iban);
    }

    @Override
    public Account deposit(AccountDTO accountDTO, double amount) throws InsufficientAmountException,SsnNotValidException {
        Account account;
        try {
            account = new Account();
            mapAccount(account,accountDTO);
            if (amount <= 0){
                throw new InsufficientAmountException(amount);
            }
            if (!dao.isSsnValid(account.getHolder().getSsn())){
                throw new SsnNotValidException(account.getHolder().getSsn());
            }
            return dao.deposit(account.getHolder().getSsn(),amount);
        }catch (InsufficientAmountException | SsnNotValidException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account withdraw(AccountDTO accountDTO, double amount) throws InsufficientBalanceException, SsnNotValidException {
        Account account = new Account();
        mapAccount(account,accountDTO);

        try{
            if (!dao.isSsnValid(account.getHolder().getSsn())){
                throw new SsnNotValidException(account.getHolder().getSsn());
            }

            account = dao.getAccountBySsn(account.getHolder().getSsn());
            if ( amount > account.getBalance()) {
                throw new InsufficientBalanceException(account.getBalance(),amount);
            }

            return dao.withdraw(account.getHolder().getSsn(),amount);
        }catch (SsnNotValidException | InsufficientBalanceException e){
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public Account getAccountState(String ssn)throws SsnNotValidException {
        Account account;
        try {
            account = dao.getAccountState(ssn);
            if (account == null){
                throw  new SsnNotValidException(ssn);
            }
            return dao.getAccountState(ssn);
        }catch (SsnNotValidException e){
           e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Account> getAll() {
        return dao.getAll();
    }

    @Override
    public double getBalance(String ssn) throws SsnNotValidException {
        if (!dao.isSsnValid(ssn)) {
            throw new SsnNotValidException(ssn);
        }
        return dao.getBalance(ssn);
    }

    public int getIndexBySsn(String ssn) {
        List<Account> accounts = dao.getAll();
        for (Account account : accounts) {
            if (account.getHolder().getSsn().equals(ssn)) {
                return accounts.indexOf(account);
            }
        }
        return -1;
    }


    public String getIban(String ssn) throws SsnNotValidException {
        try {
            if (!dao.isSsnValid(ssn)) {
                throw new SsnNotValidException(ssn);
            }
            return dao.getIban(ssn);
        } catch (SsnNotValidException e) {
            e.printStackTrace();
            throw e;
        }
    }



    private void mapAccount(Account account,AccountDTO accountDTO){
        account.setId(accountDTO.getAccountId());
        account.setBalance(accountDTO.getBalance());
        account.setIban(accountDTO.getIban());
        User user = new User();
        mapUser(user,accountDTO.getUserDTO());
        account.setHolder(user);
    }

    private void mapUser(User user, UserDTO userDTO){
        user.setSsn(userDTO.getSsn());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
    }
}
