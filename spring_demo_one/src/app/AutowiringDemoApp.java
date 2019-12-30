package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiringDemoApp {

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get bean from container.
        Coach theCoach = context.getBean("tennisCoach", Coach.class);


        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());


    }




}
