package gr.aueb.cf.ch18.exercise.dao;

import gr.aueb.cf.ch18.exercise.model.Account;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnNotValidException;

import java.util.List;

public interface IAccountDAO {

    /**
     * Creates a new {@link Account} instance in the data source
     *
     * @param account
     *              the account to be created
     * @return
     *          the created account
     */
    Account create(Account account);


    /**
     * Deletes an {@link Account} instance from the data source
     *
     * @param iban
     *           the {@link Account#iban} of the account
     *           to be deleted
     */
    void delete(String iban);

    /**
     * Deposits a certain amount of money
     *          in a {@link Account#balance}
     *
     * @param ssn
     *             of account
     * @param amount
     *              the amount to be deposited
     * @return
     *          the account
     */
    Account  deposit(String ssn,double amount);

    /**
     * Withdraws a certain amount of money
     *          from  a {@link Account#balance}
     *
     * @param ssn
     *              of account
     * @param amount
     *              the amount to be withdrawn
     * @return
     *         the account
     */
    Account  withdraw(String  ssn ,double amount);

    /**
     * Gets the account state of a {@link Account}
     *
     * @param ssn
     *           of account
     * @return
     *         the account
     */
    Account getAccountState(String ssn)throws SsnNotValidException;

    /**
     * Checks if a ssn is valid
     *
     * @param ssn the ssn to be checked
     *
     * @return true if it is valid
     */
    public boolean isSsnValid(String ssn);

    /**
     * Checks if a ssn exists already
     *
     * @param ssn the ssn to be checked
     *
     * @return  true if ssn already exists
     */
    public boolean ssnExists(String ssn);

    /**
     *
     * @return All accounts in the List
     */
    public List<Account> getAll();


    /**
     * Finds an account in the list based on the ssn
     *
     * @param ssn the ssn of the account
     *
     * @return the position of the account in the {@link  List}
     */
    int getIndexBySsn(String ssn);

    /**
     * Gets account  using the ssn
     *
     * @param ssn the ssn of the account
     *
     * @return the account with the specific ssn
     */
    public Account getAccountBySsn(String ssn);

    /**
     * Gets balance using ssn
     *
     * @param ssn the ssn of the account's
     *
     * @return the balance of the account
     */
    public double getBalance(String ssn);

    /**
     * Gets iban using ssn
     *
     * @param ssn   the ssn of the account
     *
     * @return the iban's account
     */
    public String getIban(String ssn);
}
