package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner; // to limit the useless output that pollute the expected output

// source :
// // https://www.baeldung.com/spring-boot-console-appa
// https://www.mkyong.com/spring-boot/spring-boot-non-web-application-example/
// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-command-line-runner

@SpringBootApplication
public class DemoApplication
  implements CommandLineRunner {
 
    // private static Logger LOG = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
	private CalculatriceRemote calcGeneric ;
	
	@Autowired
    private CalculatriceMemoireBean calcMemoire ; // par défaut, avec @Autowired, Spring injecte un CalculatriceMemoireBean (si c'est un component) dans calcMemoire
	
	@Autowired
    private CalculatriceJetableBean calcJetable ; // par défaut, avec @Autowired, Spring injecte un CalculatriceMemoireBean (si c'est un component) dans calcMemoire

	@Autowired
	private CalculatriceMemoireBean calcMemoireLocale ;
	
	@Autowired
	private CalculatriceJetableBean calcJetableLocale ;

	// Question B - uncomment the DemoApplication  constructor
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
  
    // injection par setter - mais comment sait-il qu'il faut faire par setter ?
	
  
  
    @Override
    public void run(String... args) {

	// LOG.info("EXECUTING : command line runner");
		System.out.println( calcMemoire.whatsyourname() ) ;
		System.out.println( calcJetable.whatsyourname() ) ;
 
		System.out.println( calcMemoireLocale.whatsyourname() ) ;
		System.out.println( calcJetableLocale.whatsyourname() ) ;


 /*
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
        */


    }

// https://www.mkyong.com/spring/spring-bean-scopes-examples/ : prototype versus singleton

/*
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// return "Greetings from Spring Boot!";
	}

        public void run(String... args) {
          System.out.println( "Hello World" );
    }
*/

/*

// https://www.boraji.com/spring-singleton-scope-example-using-scope-annotation

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      AccountService service1 = context.getBean("accountService", AccountService.class);
      service1.setAccountHolder("BORAJI");
      System.out.println(service1.getAccountHolder());

      AccountService service2 = context.getBean("accountService", AccountService.class);
      System.out.println(service2.getAccountHolder());
      context.close();
   }
}

*/



}
