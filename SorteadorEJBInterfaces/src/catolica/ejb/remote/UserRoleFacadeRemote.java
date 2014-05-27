/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package catolica.ejb.remote;

import catolica.ejb.entities.UserRole;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Casa
 */
@Remote
public interface UserRoleFacadeRemote {

    void create(UserRole userRole);

    void edit(UserRole userRole);

    void remove(UserRole userRole);

    UserRole find(Object id);

    List<UserRole> findAll();

    List<UserRole> findRange(int[] range);

    int count();
    
}
