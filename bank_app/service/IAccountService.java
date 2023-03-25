package gr.aueb.cf.ch18.exercise.service;

import gr.aueb.cf.ch18.exercise.dto.AccountDTO;
import gr.aueb.cf.ch18.exercise.model.Account;
import gr.aueb.cf.ch18.exercise.service.exceptions.InsufficientAmountException;
import gr.aueb.cf.ch18.exercise.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnExistsException;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnNotValidException;

import java.util.List;

public interface IAccountService {

    /**
     * Creates an account based on the data carried by the {@link  AccountDTO}
     *
     * @param accountDTO    the DTO object that contains the data
     *
     * @return   the resulting {@link  Account}
     *
     * @throws SsnExistsException if account with this ssn already exists
     */
    Account create(AccountDTO accountDTO) throws SsnExistsException;

    /**
     * Delete account using iban
     *
     * @param iban the iban of the account to be deleted
     */
    void delete(String iban);

    /**
     * Deposits a certain amount at an account\
     *
     * @param accountDTO the object that contains the data
     *
     * @param amount the amount to be deposited
     *
     * @return the account after the deposit
     *
     * @throws InsufficientAmountException if the amount is 0 or less
     *
     * @throws SsnNotValidException if the ssn is not valid
     */
    Account  deposit(AccountDTO accountDTO,double amount)
            throws InsufficientAmountException,SsnNotValidException;

    /**
     * Withdraws a certain amount of money from an account
     *
     * @param accountDTO the object that contains the data
     *
     * @param amount the amount to be withdrawn
     *
     * @return the account's state after the withdrawal
     *
     * @throws InsufficientBalanceException if the amount is greater than the balance
     *
     * @throws SsnNotValidException if the ssn is not valid
     */
    public Account withdraw(AccountDTO accountDTO, double amount) throws InsufficientBalanceException, SsnNotValidException;

    /**
     * Gets an account's state using ssn
     * @param ssn the ssn of the account
     *
     * @return account's state
     *
     * @throws SsnNotValidException if the ssn is not valid
     */
    Account getAccountState(String ssn) throws SsnNotValidException;

    /**
     * Gets all accounts in the list
     *
     * @return a list with all accountss
     */
    public List<Account> getAll();

    /**
     * Gets balance using ssn
     *
     * @param ssn   the ssn of the account
     *
     * @return  the balance of the account
     *
     * @throws SsnNotValidException
     */
    public double getBalance(String  ssn) throws SsnNotValidException;

    /**
     * Gets the iban of an account using ssn
     *
     * @param ssn the account's ssn
     *
     * @return the account's iban
     *
     * @throws SsnNotValidException if ssn is not valid
     */
    public String getIban(String ssn) throws SsnNotValidException;



}
