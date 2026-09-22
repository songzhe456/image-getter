package org.game.game_demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GameDemoApplication {

    private static final Logger log = LogManager.getLogger(GameDemoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GameDemoApplication.class, args);
        try {
            User user = ctx.getBean(User.class);
            log.info("用户创建成功！");
        } catch (BeansException be) {
            log.error("用户创建失败！原因：",be);
        }

    }
}
