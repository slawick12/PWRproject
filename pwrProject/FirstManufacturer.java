/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viacheslav Konstyantyn
 */
public class FirstManufacturer implements Runnable {
    Container p;
    FirstManufacturer(Container p) {
        this.p = p;
    }
    public void run() {
        for (int i=1; i<=10; i++) {
            try {
                Thread.sleep((int)(100*Math.random()));
            }
            catch (InterruptedException e) {}
            p.inputNumber(i);
        }
    }
}
