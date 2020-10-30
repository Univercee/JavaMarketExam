/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import entities.User;
import exceptions.IncorrectValueException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jktvr19_ostromogilskii_laptops.App.Role;
import managers.UserManager;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */
public class UILogin {
//log in
    public static long login(){
        String login;
        String password;
        long userId = UserManager.guest();
            
        Print.alert("Имя пользователя:", " ");
        login = Scan.getString();
        Print.alert("Пароль:", " ");
        password = Scan.getString();
        for(User u : UserManager.get()){
            if(u.getLogin().equals(login)){
                if(u.getPassword().equals(password)){
                    userId = u.getId();
                }
                break;
            }
        }
        return userId;
    }
    
//registeration
    public static void registration(){
        try {
            String login;
            String password;
            String confirmPassword;
            User user = new User();;
            user.setRole(Role.USER);
            user.setMoney(10000);
            
            //get user name
            Print.alert("Введите имя пользователя:", " ");
            login = Scan.getString();
            for(User u : UserManager.get()){
                if(u.getLogin().equals(login)){
                    Print.errorln("Пользователь с таким именем уже зарегистрирован");
                    return;
                }
            }
            user.setLogin(login);
            
            //get password
            Print.alert("Введите пароль:", " ");
            password = Scan.getString();
            user.setPassword(password);
            
            //confirm password
            Print.alert("Подтвердите пароль:", " ");
            confirmPassword = Scan.getString();
            if(!password.equals(confirmPassword)){
                Print.errorln("Пароли не совпадают");
                return;
            }
            
            //success registration
            UserManager.add(user);
            System.out.println("Пользователь зарегистрирован");
        }catch (IncorrectValueException e) {
            Print.errorln(e.toString());
        }
    }
}