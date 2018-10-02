package com.example.demo;

import java.util.logging.* ;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.Random;
import org.springframework.context.annotation.Profile;


@Component
@Scope("singleton") // pour info, calcMemoire => @Scope("prototype")
@Qualifier("jetable")
public class CalculatriceJetableBean implements CalculatriceRemote {

    private int id ;        
    private int  z ; // memoire

	@Autowired
	private Compteur the_compteur ;
	
	public CalculatriceJetableBean ()
	{
		initBean() ;
	}

    public void initBean()
    {
        Logger logger = Logger.getLogger(CalculatriceJetableBean.class.getName());
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
       return "CalculatriceJetable : " + this.getId() ;
    }

    public int additionner(int x, int y)
    {
  	z = z + x + y ;
        return z ;
    }

    public void Detruire() {
        Logger logger = Logger.getLogger(CalculatriceJetableBean.class.getName());
        logger.log(Level.INFO, "EXA3415 - destruction instance : " + id ) ;
    }

}
