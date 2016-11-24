package io.github.zelinskyi;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ThreadService {
    
    private ExecutorService executors = Executors.newFixedThreadPool(20);
    
    
    @PreDestroy
    public void init() {
        executors.submit(new Runnable() {
            public void run() {
                System.out.println("Hello");
            }
        });
        executors.submit(new Runnable() {
            public void run() {
                System.out.println("Hello");
            }
        });
        
    }
    
}
