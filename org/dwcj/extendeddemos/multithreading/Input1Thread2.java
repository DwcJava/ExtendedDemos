package org.dwcj.extendeddemos.multithreading;

import org.dwcj.controls.TextBox;
import org.dwcj.events.ButtonPushEvent;

public class Input1Thread2 implements Runnable {
    private TextBox input1;
    private TextBox input2;
    private boolean doReset=false;


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            input1.setText("1");

            int x=0;
            if (this.doReset)
                this.doReset = false;
            else
                x = Integer.valueOf(input2.getText());
            x=x+1;
            input2.setText(String.valueOf(x));

        }

    }

    public void setInput1(TextBox input1) {
        this.input1 = input1;
    }

    public void setInput2(TextBox input2) {
        this.input2 = input2;
    }

    public void onReset(ButtonPushEvent buttonPushEvent) {
        this.doReset = true;
    }
}
