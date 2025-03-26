import java.io.PrintStream;

public class consoleLogger
{
    // to track type of log
    public enum LogLevel
    {
        COMMENT, WARNING, ERROR
    }

    private static consoleLogger obj;

    private consoleLogger() {}

    // used https://www.geeksforgeeks.org/singleton-design-pattern/ example 2
    public static synchronized consoleLogger getInstance()
    {
        if (obj == null)
            obj = new consoleLogger();
        return obj;
    }

    // log method
    public void log(LogLevel level, String message)
    {
        String prefix = "";

        switch (level)
        {
            case COMMENT:
                prefix = "Comment: ";
                break;
            case WARNING:
                prefix = "Warning: ";
                System.out.println("\u001B[33m" + prefix + message + "\u001B[0m"); // Yellow
                return;
            case ERROR:
                prefix = "Error: ";
                System.out.println("\u001B[31m" + prefix + message + "\u001B[0m"); // Red
                System.exit(1);
                return;
        }
        System.out.println(prefix + message);
    }

    public static void main(String[] args)
    {
        consoleLogger logger = consoleLogger.getInstance();
        logger.log(LogLevel.COMMENT, "Comment1");
        logger.log(LogLevel.WARNING, "Warning1");
        logger.log(LogLevel.ERROR, "Error1");
    }
}
