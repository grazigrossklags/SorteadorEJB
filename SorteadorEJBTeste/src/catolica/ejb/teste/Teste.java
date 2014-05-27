/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package catolica.ejb.teste;

import catolica.ejb.entities.Role;
import catolica.ejb.entities.User;
import catolica.ejb.entities.UserRole;
import catolica.ejb.remote.RoleFacadeRemote;
import catolica.ejb.remote.UserFacadeRemote;
import catolica.ejb.remote.UserRoleFacadeRemote;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Casa
 */
public class Teste {
    
private static final String JNDI_NAME
            = "java:global/SorteadorEJB/SorteadorEJB-ejb/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        InitialContext ctx;
        Properties props = new Properties();
        try {
            props.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs",
                    "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state",
                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");           
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

            ctx = new InitialContext(props);                        
            UserFacadeRemote user = (UserFacadeRemote) ctx.lookup(JNDI_NAME + "UserFacade");                
            RoleFacadeRemote role = (RoleFacadeRemote) ctx.lookup(JNDI_NAME + "RoleFacade");
            UserRoleFacadeRemote userRole = (UserRoleFacadeRemote) ctx.lookup(JNDI_NAME + "UserRoleFacade");
            
//            System.out.println("Deleting users...");
//            List<User> ltu = user.findAll();
//            for(User uuu: ltu) {
//                user.remove(uuu);
//            }
//            System.out.println("");
//            
//            System.out.println("Deleting roles...");
//            List<Role> ltr = role.findAll();
//            for(Role rrr: ltr) {
//                role.remove(rrr);
//            }
//            System.out.println("");
//            
//            System.out.println("Deleting UserRoles...");
//            List<UserRole> userRoleLst = userRole.findAll();
//            for(UserRole uurr: userRoleLst) {
//                userRole.remove(uurr);
//            }
            System.out.println("");
            
            System.out.println("Creating user....");
            User uu = new User();
            uu.setName("Lucas");
            user.create(uu);
            System.out.println("User created!");
            System.out.println("");
            
            System.out.println("Creating role....");
            Role rr = new Role();
            rr.setName("Spy");
            role.create(rr);
            System.out.println("Role created!");  
            System.out.println("");
            
            System.out.println("Adding Role to user");
            List<Role> ltr2 = role.findAll();
            for (Role rr2: ltr2) {
                List<User> ltu2 = user.findAll();
                for (User uu2: ltu2) {
                    UserRole uR2 = new UserRole();
                    uR2.setUserId(uu2.getId());
                    uR2.setRoleId(rr2.getId());
                    userRole.create(uR2);
                }
            }
            
            List<User> listuser = user.findAll();            
            User u;
            System.out.println("=== Users ===");
            for (int i = 0; i < listuser.size(); i++) {
                u = (User) listuser.get(i);
                System.out.println("ID: " + u.getId() + " - Nome: " + u.getName());                
            }  
            System.out.println("Total of users: " + user.count());                                    
            
            System.out.println("");
            System.out.println("=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=");
            System.out.println("");
                        
            List<Role> listrole = role.findAll();            
            Role r;
            System.out.println("=== Roles ===");
            for (int i = 0; i < listrole.size(); i++) {
                r = (Role) listrole.get(i);
                System.out.println("ID: " + r.getId() + " - Nome: " + r.getName());                
            }  
            System.out.println("Total of roles: " + role.count());
            
            System.out.println("");
            System.out.println("=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=");
            System.out.println("");
                        
            List<UserRole> ltur = userRole.findAll();            
            UserRole uR;
            System.out.println("=== Roles ===");
            for (int i = 0; i < ltur.size(); i++) {
                uR = (UserRole) ltur.get(i);
                System.out.println("Role ID: " + uR.getRoleId() + " - User ID: " + uR.getUserId());                
            }  
            System.out.println("Total of roles: " + role.count());
            System.out.println("");
            
        } catch (NamingException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

