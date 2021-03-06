package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Profile;
import java.util.concurrent.TimeUnit;


@Component
@Profile({"test","default"})
// @Profile({"test"}) // question bonus Q7
@Scope("singleton")
public class DelayMakerFastBean implements DelayMaker {
	
	public DelayMakerFastBean ()
	{
	}

    public int wait_for_a_moment() {
		
                try {
					TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
					return 1 ;

    }

}
