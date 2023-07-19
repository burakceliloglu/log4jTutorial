import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyTimerLoggings {
    private static final Logger logger = LogManager.getLogger(MyTimerLoggings.class);
    private static Runnable loggerRunnable;
    private static Thread loggerThread;

    private static boolean stopLoggers = false;

    public static void printDebugLogs() {
        loggerRunnable = () -> {
            while (true){
                if (stopLoggers){
                    return;
                }
                logger.debug("This is debug level.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        loggerThread = new Thread(loggerRunnable);
        loggerThread.start();
    }

    public static void printInfoLogs(){
        loggerRunnable = () -> {
            while (true){
                if (stopLoggers){
                    return;
                }
                logger.info("This is info level.");
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        loggerThread = new Thread(loggerRunnable);
        loggerThread.start();
    }

    public static void printWarningLogs(){
        loggerRunnable = () -> {
            while (true){
                if (stopLoggers){
                    return;
                }
                logger.warn("This is warning level.");
                try {
                    Thread.sleep(3600000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        loggerThread = new Thread(loggerRunnable);
        loggerThread.start();
    }

    public static void stopLogger(){
        stopLoggers = !stopLoggers;
    }
}
