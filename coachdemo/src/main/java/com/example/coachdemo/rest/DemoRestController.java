package com.example.coachdemo.rest;

import com.example.coachdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    private Coach myCoach;
    private Coach antoherCoach;

//    @Autowired
//    public DemoRestController(final Coach theCoach) {
//        myCoach = theCoach;
//    }
    @Autowired
    public DemoRestController(@Qualifier("trackCoach")Coach theCoach,@Qualifier("trackCoach") Coach otherCoach ) {
        myCoach = theCoach;
        antoherCoach = otherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check() {
        return "Comparing theCoach and otherCoach <br />["+ myCoach.getClass() + "]<br /> vs\n[" + antoherCoach.getClass() + "] , the result is " + (myCoach == antoherCoach);
    }
}
