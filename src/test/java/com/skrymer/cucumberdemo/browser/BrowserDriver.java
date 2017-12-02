package com.skrymer.cucumberdemo.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;

/**
 * Created by skrymer on 2/12/17.
 */
public class BrowserDriver {
  private static WebDriver mDriver;

  public synchronized static WebDriver getCurrentDriver() {
    if (mDriver==null) {
      try {
        System.setProperty("webdriver.chrome.driver", "/home/skrymer/coding/github/cucumber-demo/chromedriver_linux64/chromedriver");
        mDriver = new ChromeDriver();
      } finally{
        Runtime.getRuntime().addShutdownHook(
            new Thread(new BrowserCleanup()));
      }
    }
    return mDriver;
  }

  private static class BrowserCleanup implements Runnable {
    public void run() {
      System.out.println("Closing the browser");
      close();
    }
  }

  public static void close() {
    try {
      getCurrentDriver().quit();
      mDriver = null;
      System.out.println("Closing the browser");
    } catch (UnreachableBrowserException e) {
      System.out.println("cannot close browser: unreachable browser");
    }
  }

  public static void loadPage(String url){
    System.out.println("Directing browser to:" + url);
    getCurrentDriver().navigate().to(url);
  }
}
