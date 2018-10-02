package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Profile;
import java.util.concurrent.TimeUnit;


@Component
@Profile({"prod"})
@Scope("singleton")
public class DelayMakerLongBean implements DelayMaker {
	
	public DelayMakerLongBean ()
	{
	}

    public int wait_for_a_moment() {
               try {
					TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
				return 10 ;
    }

}
