package travel.servlet;

import java.util.Collection;

import javax.persistence.EntityManager;

//@Repository
public class ProductDaoImpl {

    private EntityManager entityManager;

   // @PersistenceContext(name="travel")
    public void setEntityManager(EntityManager entityManager) {
        this. entityManager = entityManager;
    }

    public Collection loadProductsByCategory(String category) {
    	System.out.println("Entity="+entityManager);
    /*    return entityManager.createQuery("from Product p where p.category = :category")
            .setParameter("category", category).getResultList();*/
		return null;
    }
}