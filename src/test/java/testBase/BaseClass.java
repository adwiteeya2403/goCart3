package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups={"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
        
		//loading a file
		FileReader file= new FileReader(".//src//test//resources//config.properties"); 
		p= new Properties();
		p.load(file);
		
		//Loading log4j2 file
		logger= LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		
			DesiredCapabilities capabilities= new DesiredCapabilities();
			logger.info("launching windows remotely");
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WINDOWS);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No Macthing Browser");
			}
			
			logger.info("launching browser remotely");
			//browser
			switch (br.toLowerCase()) 
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("edge");break;
			default:System.out.println("No Matching browser");return;
			}
			 driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")){
		switch(br.toLowerCase()) {
		case "chrome": driver= new ChromeDriver();
		break;
		case "edge": driver= new EdgeDriver();
		break;
		default: System.out.println("no matching browser");
		return;
		   }
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();		
	}
	
	@AfterClass(groups={"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomNumber() {
	     String number=RandomStringUtils.randomNumeric(10);
	     return number;
	}
	
	public String randomAlphabet() {
		String letter=RandomStringUtils.randomAlphabetic(20);
		return letter;
	}
	
	public String randomAlphaNumeric() {
		String alphaNumeric=RandomStringUtils.randomAlphanumeric(20);
		return alphaNumeric;
	}
	
	public String captureScreen(String tname) throws IOException{
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp +".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
}
