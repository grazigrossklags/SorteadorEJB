/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package catolica.ejb.remote;

import catolica.ejb.entities.Role;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Casa
 */
@Stateless
public class RoleFacade extends AbstractFacade<Role> implements RoleFacadeRemote {
    @PersistenceContext(unitName = "SorteadorEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }
    
}
