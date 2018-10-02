package com.example.demo;

import java.util.logging.* ;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.Random;


@Component
@Scope("singleton")
public class Compteur {

    private int increment ;

	public Compteur ()
	{
		increment = 0 ;
	}

    public int get()
    {
	   increment = increment + 1 ;
       return increment ;
    }

}
