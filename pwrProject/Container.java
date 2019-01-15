
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viacheslav Konstyantyn
 */
public class Container {
    private ArrayList numbers = new ArrayList(4);
    private ArrayList chracters = new ArrayList(4);
    synchronized public void inputNumber(int number) {
        if (this.numbers.size() > 3) {
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }
        System.out.println("Do pojemnika wstawiana jest liczba: " + number);
        this.numbers.add(number);
        notify();
    }
    synchronized public void inputCharacter(int character) {
        if (this.chracters.size() > 3) {
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }
        System.out.println("Do pojemnika wstawiana jest literka: " + (char)(character));
        this.chracters.add((char)(character));
        notify();
    }
    synchronized public void getPair(int id) {
        while (true) {
            if (this.numbers.size() == 0 || this.chracters.size() == 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {}
            } else {
                System.out.println("Z pojemnika pobierana jest liczba: " + numbers.remove(numbers.size() - 1) + ". Przez konsumenta id: " + id + ".");
                System.out.println("Z pojemnika pobierana jest literka: " + (char)chracters.remove(chracters.size() - 1) + ". Przez konsumenta id: " + id + ".");
                Consumer.next = (Consumer.next + 1) % 3;
                notify();
                break;
            }
        }
    }
}