package com.example.demo;

import java.util.logging.* ;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.Random;
import org.springframework.context.annotation.Profile;

// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-command-line-runner
@Component
@Scope("prototype")
@Qualifier("memoire")
public class CalculatriceMemoireBean implements CalculatriceRemote {

    private int id = 0 ;
    private int  z ; // memoire

	
	@Autowired
	private Compteur the_compteur ;

	public CalculatriceMemoireBean ()
	{
		initBean() ;
	}
	
    public void initBean()
    {
        Logger logger = Logger.getLogger(CalculatriceMemoireBean.class.getName());
    }

    public int getId()
    {
	   if ( id == 0 ) {
		   id = the_compteur.get() ; 
		}
       return  id ;
    }
	
    public String whatsyourname()
    {
       return "CalculatriceMemoire : "  + this.getId() ;
   }
	

    public int additionner(int x, int y)
    {	
  	z = z + x + y ;
        return z ;
    }

    public void Detruire() {
        Logger logger = Logger.getLogger(CalculatriceMemoireBean.class.getName());
        logger.log(Level.INFO, "EXA3415 - destruction instance : " + id ) ;
    }

}

