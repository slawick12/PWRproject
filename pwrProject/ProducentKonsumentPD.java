import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viacheslav Konstyantyn
 */
public class ProducentKonsumentPD {
    public static void main(String args[]) {
        Container container = new Container();
        FirstManufacturer man1 = new FirstManufacturer(container);
        SecondManufacturer man2 = new SecondManufacturer(container);
        
        
        List consumers = Arrays.asList(
        					new Consumer(container, 0),
        					new Consumer(container, 1),
        					new Consumer(container, 2));
        
        
        List <Thread> threads =  Arrays.asList(
        		new Thread(man1),
        		new Thread(man2),
        		new Thread((Runnable) consumers.get(0)),
        		new Thread((Runnable) consumers.get(1)),
        		new Thread((Runnable) consumers.get(2)));
        
        for(Thread thread : threads) 
        	thread.start();
        
    }
}
