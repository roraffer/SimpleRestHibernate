
package com.ror.res;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ror.res.entity.Person;
import com.ror.res.listenter.LocalEntityManagerFactory;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {

	/** Method processing HTTP GET requests, producing "text/plain" MIME media
	 * type.
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET 
	@Produces("text/plain")
	public String getIt() {

		String result = getResult();
		return result;
	}

	private String getResult() {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Person p = null;
		try {  
			p =  em.find(Person.class, 1L);  
		} finally {  
			em.close();  
		}
		if (p != null) {
			return p.getName();
		} else {
			return "not found";
		}
	}
}
