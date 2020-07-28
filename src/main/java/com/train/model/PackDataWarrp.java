package com.train.model;

public class PackDataWarrp {

    private void parse(PackData msg) {

        if (msg.isInUse()) {
            throw new IllegalStateException(msg + " This message is already in use.");
        }
        msg.recycle();

    }

}
