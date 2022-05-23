package com.dwcj.extendeddemos.multithreading;

import org.dwcj.controls.TextBox;
import org.dwcj.events.ButtonPushEvent;

public class Input1Thread1 implements Runnable {
    private TextBox input1;
    private boolean doReset=false;


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int x=0;
            if (this.doReset)
                this.doReset = false;
            else
                x = Integer.valueOf(input1.getText());
            x=x+1;
            input1.setText(String.valueOf(x));
        }

    }

    public void setInput1(TextBox input1) {
        this.input1 = input1;
    }

    public void onReset(ButtonPushEvent buttonPushEvent) {
        this.doReset = true;
    }
}
