/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viacheslav Konstyantyn
 */
public class Consumer implements Runnable{
    Container p;
    private int id;
    static int next = 0;
    Consumer(Container p, int id) {
        this.p = p;
        this.id = id;
    }
    public void run() {
        for (int i=1; i<=10; i++) {
            try {
                Thread.sleep((int)(100*Math.random()));
            }
            catch (InterruptedException e) {}
            while (Consumer.next != this.id) {
               try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {}
            }
            p.getPair(this.id);
        }
    }
}
