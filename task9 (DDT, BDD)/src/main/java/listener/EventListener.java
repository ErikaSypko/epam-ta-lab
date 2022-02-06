package listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.TakeScreenshots;

public class EventListener implements ITestListener {
    final static Logger log = Logger.getLogger(EventListener.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test Case " + iTestResult.getName() + " is PASSED");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        TakeScreenshots.takeScreens();
        log.error("Test Case " + iTestResult.getName() + " is FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info(iTestContext.getName() + " is STARTED");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
