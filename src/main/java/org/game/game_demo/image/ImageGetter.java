package org.game.game_demo.image;

import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Data
@Component
public class ImageGetter implements OnlineGetter{
    private static final Logger log = LogManager.getLogger(ImageGetter.class);
    @Value("${game.image_url.url}")
    private String imageUrl;

    @Override
    public void getMessage(String saveDir,String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(getImageUrl()), new File(saveDir, fileName));
        } catch (IOException e) {
            log.error("下载图片{}并将其保存到{}时发生异常{}",fileName,saveDir,e);
        }
    }
}
