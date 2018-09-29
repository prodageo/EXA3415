package com.example.demo;

import java.util.logging.* ;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.Random;


@Component
@Scope("singleton") // pour info, calcMemoire => @Scope("prototype")
@Qualifier("jetable")
public class CalculatriceJetableBean implements CalculatriceRemote {

    private int  z ; // memoire
    private int id ;        

	public CalculatriceJetableBean ()
	{
		initBean() ;
	}

    public void initBean()
    {
        Random randomGenerator = new Random();
        id = randomGenerator.nextInt(10000);
        Logger logger = Logger.getLogger(CalculatriceJetableBean.class.getName());
        logger.log(Level.INFO, "EXA1415 - Initialisation instance : " + id ) ;
        // comment obtenir un identifiant d'une instance
        // http://openejb.apache.org/3.0/lookup-of-other-ejbs-example.html
    }

    public int getId()
    {
       return id ;
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
        logger.log(Level.INFO, "EXA1415 - destruction instance : " + id ) ;
    }

}
