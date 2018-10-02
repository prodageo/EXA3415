/*
Enoncé
* http://prodageo.insa-rouen.fr/wiki/pmwiki.php?n=CASI.EXA3415

Mode opératoire
* Pour lancer l'application (en mode console dans un terminal), executer la commande suivante (dite commande A)
** > mvn -q spring-boot:run
** l'option -q (comme ''quiet'') permet de ne pas afficher les traces maven.
* Pour lancer l'application dans sa configuration de production, lancer la commande suivante (commande B) :
** > mvn -q spring-boot:run -Dspring.profiles.active=prod
                                                                                                         
*/


 package com.example.demo;


import org.springframework.boot.SpringApplication;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner; // to limit the useless output that pollute the expected output
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

// source :
// https://www.baeldung.com/spring-boot-console-appa
// https://www.mkyong.com/spring-boot/spring-boot-non-web-application-example/
// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-command-line-runner

@SpringBootApplication
public class DemoApplication
  implements CommandLineRunner {
 
    private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);
	private CalculatriceRemote calcGeneric ;
	
	@Autowired
    private CalculatriceMemoireBean calcMemoire ; // par défaut, avec @Autowired, Spring injecte un CalculatriceMemoireBean (si c'est un component) dans calcMemoire
	
	@Autowired
    private CalculatriceJetableBean calcJetable ; // par défaut, avec @Autowired, Spring injecte un CalculatriceMemoireBean (si c'est un component) dans calcMemoire

	@Autowired
	private CalculatriceMemoireBean calcMemoireLocale ;
	
	@Autowired
	private CalculatriceJetableBean calcJetableLocale ;

	@Autowired
	private CalculatriceJetableBean calcAinitialiser ;

	@Autowired
	private DelayMaker the_delay_maker ;
	
	public DemoApplication ( @Qualifier("jetable") CalculatriceRemote aCalc )
	{
        System.out.println( "Hello World" );
		calcGeneric = aCalc ;
		System.out.println( calcGeneric.whatsyourname() ) ;
	}
	
    public static void main(String[] args) {
        // LOG.info("STARTING THE APPLICATION");
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run( args );
		// LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {

	LOG.info("EXECUTING : command line runner");
		System.out.println( calcMemoire.whatsyourname() ) ;
		int the_time = the_delay_maker.wait_for_a_moment() ;
		System.out.println( "Delai : " + the_time ) ;
		
		System.out.println( calcJetable.whatsyourname() ) ;
 
		System.out.println( calcMemoireLocale.whatsyourname() ) ;
		System.out.println( calcJetableLocale.whatsyourname() ) ;

		if ( calcAinitialiser != null )
		{ System.out.println ( calcAinitialiser.whatsyourname() ) ; }
	
		else
		{ System.out.println ( "calcAinitialiser est null" ) ; }

    }
  }