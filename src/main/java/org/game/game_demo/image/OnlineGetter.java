package org.game.game_demo.image;

import java.net.MalformedURLException;

public interface OnlineGetter {
    void getMessage(String saveDir,String fileName) throws MalformedURLException;
}
