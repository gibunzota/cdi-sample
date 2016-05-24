package akahane;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

/**
 * Created by n.akahane on 2016/05/24.
 */
@ApplicationScoped
public class EnglishSpeaker implements Speaker {

    @PostConstruct
    public void postConstruct() {
        System.out.println("Calc: PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Calc: PreDestroy");
    }

    @Override
    public void speak() {
        System.out.println("Hello World!!");
    }
}
