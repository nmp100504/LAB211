/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author PC
 */
public class Login {
void VietnameseSystem() {
        Locale Vietnam = new Locale("vi", "VN");
        loginSystem(Vietnam);
    }

    void EnglishSystem() {
        Locale America = new Locale("en", "US");
        loginSystem(America);
    }
    
    private void loginSystem(Locale locale){
        Account a = new Account();
        ResourceBundle handleLanguage = ResourceBundle.getBundle("language", locale);
        Capcha handle = new Capcha();
        
        String account = a.getAcountNumber(handleLanguage.getString("accountNumber"), 
                handleLanguage.getString("inputAcountError"));
        String password = a.getPassword(handleLanguage.getString("Password"), 
                handleLanguage.getString("inputPasswordError"));
        handle.handleCapcha(handleLanguage.getString("Capcha"), handleLanguage.getString("CapchaError"), 
                handleLanguage.getString("inputCapcha"));
        
        boolean checkAcount = checkAccount(account);
        boolean checkPassword = checkPassword(account, password);
        if(checkAcount && checkPassword){
            System.out.println(handleLanguage.getString("loginSuccess"));
        }else{
            System.out.println(handleLanguage.getString("loginFail"));
        }
    }
    
     boolean checkAccount(String AccountNumber){
        AccountList listAcount = new AccountList();
        ArrayList<Account> accountList = listAcount.database();
        if(accountList.isEmpty()){
            return false;
        }else{
            for (Account account : accountList) {
                if(account.getAcount().equals(AccountNumber)){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean checkPassword(String AccountNumber, String password){
        AccountList listAcount = new AccountList();
        ArrayList<Account> accountList = listAcount.database();
        if(accountList.isEmpty()){
            return false;
        }else{
            for (Account account : accountList) {
                if(account.getAcount().equals(AccountNumber) && account.getPasswords().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
}
