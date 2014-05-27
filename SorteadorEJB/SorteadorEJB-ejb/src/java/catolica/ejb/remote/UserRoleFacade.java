/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package catolica.ejb.remote;

import catolica.ejb.entities.UserRole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Casa
 */
@Stateless
public class UserRoleFacade extends AbstractFacade<UserRole> implements catolica.ejb.remote.UserRoleFacadeRemote {
    @PersistenceContext(unitName = "SorteadorEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRoleFacade() {
        super(UserRole.class);
    }
    
}
