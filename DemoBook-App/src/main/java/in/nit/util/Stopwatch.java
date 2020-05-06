package in.nit.util;

import java.net.HttpRetryException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class Stopwatch {
static int interval=10;
static Timer timer;

	/*
	 * public static void main(String[] args) { countDown(); }
	 */

public static void countDown(final HttpSession ses) {
    
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    
  

    timer.scheduleAtFixedRate(new TimerTask() {

        public synchronized void run() {
        	

            System.out.println(setInterval());
           
            ses.setAttribute("time", setInterval());

        }
    }, delay, period);
}

private static synchronized final int setInterval() {
	
	
    if (interval == 1)
        timer.cancel();
    return --interval;
}	
}
