package com.example.Instagrambackend.Config;

import com.example.Instagrambackend.Model.CustomSpringEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;

@Component
public class TransactionalEventListener implements ApplicationListener<CustomSpringEvent> {
    @org.springframework.transaction.event.TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println(event.getMessage());
        System.out.println("Handling event inside a transaction After Rollback.");
    }

//  @org.springframework.transaction.event.TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
//    public void handleCustom(CustomSpringEvent event) {
//        System.out.println("Handling event inside a transaction BEFORE Rollback.");
//    }


}
