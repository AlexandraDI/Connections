/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import jpautils.EntityManagerHelper;

/**
 *
 * @author alex
 */
public class DaoEM {
    protected final EntityManager em = EntityManagerHelper.getEntityManager();        
    
    public void closeEM() {        
        em.close();
    }
}
