package java.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest logger;

public void onStart(ITestContext testcontext)
{
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
	String repname="Test-Report"+timestamp+".html";
	htmlReporter=new ExtentHtmlReporter(System.getProperty(("user.dir")+"/test-output/"+repname)); //specify the location
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent_config.xml");
	
	
	 extent= new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 extent.setSystemInfo("Host name", "Localhost");
	 extent.setSystemInfo("Environment", "QA");
	 extent.setSystemInfo("User", "Chandra");
	 
	 htmlReporter.config().setDocumentTitle("AutomationFramework"); //title of the report
	 htmlReporter.config().setReportName("Financial Test report");  // name of the report
	 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // chart location
	 htmlReporter.config().setTheme(Theme.DARK);
	 
}

public void onTestSuccess(ITestResult tr)
{
	
	logger=extent.createTest(tr.getName());
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	
	
	
}

public void onTestFailure(ITestResult tr)
{
	
	logger=extent.createTest(tr.getName());
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
	String screenShotPath=System.getProperty(("user.dir"),"\\creenshots\\"+tr.getName()+".png");
	
	 File f=new File(screenShotPath);
	 
	 if(f.exists())
	 {
		 
		 try {
			 
			 logger.fail("Screnshot is below"+logger.addScreenCaptureFromPath(screenShotPath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
	 }
	 
	
}

public void onTestSkipped(ITestResult tr)
{
	
	logger=extent.createTest(tr.getName());
	logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	
}

public void onFinish(ITestContext testcontext)
{
	extent.flush();
}
	
	
	
	
	
	
}
