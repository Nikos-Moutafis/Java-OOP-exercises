package gr.aueb.cf.ch18.exercise.dao;

import gr.aueb.cf.ch18.exercise.model.Account;
import gr.aueb.cf.ch18.exercise.model.User;
import gr.aueb.cf.ch18.exercise.service.exceptions.SsnNotValidException;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO{

    private static final List<Account> accounts = new ArrayList<>();

    @Override
    public Account create(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public void delete(String iban) {
        accounts.removeIf((account -> account.getIban().equals(iban)));
    }

    @Override
    public Account deposit(String ssn, double amount) {
        int index = getIndexBySsn(ssn);
        if(index == -1) return null;
        Account account = accounts.get(index);
        account.setBalance(account.getBalance() + amount);
        accounts.set(index, account);
        return account;
    }

    @Override
    public Account withdraw(String ssn, double amount) {
        Account account = getAccountBySsn(ssn);
        account.setBalance(account.getBalance()-amount);
        return account;
    }

    public boolean isSsnValid(String ssn){
        User user;
        int pos = getIndexBySsn(ssn);
        if (pos == -1 ) return  false;
        Account account = accounts.get(getIndexBySsn(ssn));
        user = account.getHolder();
        if ((ssn == null) || (user.getSsn() == null)){
            return false;
        }
        return user.getSsn().equals(ssn);
    }

    @Override
    public boolean ssnExists(String ssn) {
        return getIndexBySsn(ssn) != -1;
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }


    @Override
    public Account getAccountState(String ssn) throws SsnNotValidException {
        int pos = getIndexBySsn(ssn);
        if (pos == -1) return null;
        return accounts.get(pos);
    }


    private int getIndexByIban(String iban){
        int pos = -1;
        for (int i = 0; i < accounts.size() ; i++){
            if (accounts.get(i).getIban().equals(iban)){
                pos = i;
                break;
            }
        }
        return pos;
    }

    public int getIndexBySsn(String ssn){
        int pos = -1;
        for (int i = 0; i < accounts.size() ; i++){
            if (accounts.get(i).getHolder().getSsn().equals(ssn)){
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Account getAccountBySsn(String ssn) {
        for (Account account : accounts) {
            if (account.getHolder().getSsn().equals(ssn)) {
                return account;
            }
        }
        return null;
    }

    public double getBalance(String ssn) {
        int index = getIndexBySsn(ssn);
        Account account = accounts.get(index);
        return account.getBalance();
    }

    @Override
    public String getIban(String ssn) {
        int pos = getIndexBySsn(ssn);
        return accounts.get(pos).getIban();
    }

}
