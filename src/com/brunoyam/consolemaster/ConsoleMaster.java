package com.brunoyam.consolemaster;

import com.brunoyam.consolemaster.config.Config;

public class ConsoleMaster {

    public static void main(String[] args) {

        Config.getInstance().init(args);

        Thread thread = new Thread(Config.getInstance().getCommandExecutor());
        thread.start();

        Config.getInstance().getUserInterface().begin();

    }

}
