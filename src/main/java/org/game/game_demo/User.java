package org.game.game_demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    @Value("${game.user.can_say}")
    private boolean canSay;

    public User(@Value("${game.user.can_say}") boolean canSay){
        this.canSay = canSay;
        if(canSay){
            System.out.println("我会说话");
        }
    }
}
