package org.game.game_demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.game.game_demo.image.ImageGetter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class ImageController {

    private static final Logger log = LogManager.getLogger(ImageController.class);
    private final ImageGetter imageGetter;

    public ImageController(ImageGetter imageGetter) {
        this.imageGetter = imageGetter;
    }

    @GetMapping("/image")
    public ResponseEntity<String> download(@RequestParam(defaultValue = "demo.png") String name) {
        File dir = new File("downloads");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            imageGetter.getMessage(dir.getPath(), name);
            return ResponseEntity.ok().body("已保存到: " + dir.getAbsolutePath() + File.separator + name);
        } catch (IOException e) {
            log.error("保存失败",e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
