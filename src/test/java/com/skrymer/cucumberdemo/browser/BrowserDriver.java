package com.skrymer.cucumberdemo.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by skrymer on 2/12/17.
 */
public class BrowserDriver {
  private static final String SYSTEM_PROP_CUCUMBER_BROWSER = "cucumber.browser";
  private static final String SYSTEM_PROP_CUCUMBER_REMOTE_URL = "cucumber.remote.url";
  private static WebDriver mDriver;

  public synchronized static WebDriver getCurrentDriver() {
    if (mDriver==null) {
      try {
        mDriver = createDriver();
      } finally{
        Runtime.getRuntime().addShutdownHook(
            new Thread(new BrowserCleanup()));
      }
    }
    return mDriver;
  }

  private static WebDriver createDriver() {
    String browser = System.getProperty(SYSTEM_PROP_CUCUMBER_BROWSER);

    if(browser == null || browser.isEmpty()){
      return new ChromeDriver();
    }

    switch (browser) {
      case "local_chrome" : return new ChromeDriver();
      case "remote_chrome" : return newRemoteDriver();
      default: return new ChromeDriver();
    }
  }

  private static WebDriver newRemoteDriver() {
    String remoteUrl = System.getProperty(SYSTEM_PROP_CUCUMBER_REMOTE_URL);

    try {
      return new RemoteWebDriver(new URL(remoteUrl), DesiredCapabilities.chrome());
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return null;
    }
  }

  private static class BrowserCleanup implements Runnable {
    public void run() {
      System.out.println("Closing the browser");
      close();
    }
  }

  static void close() {
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
