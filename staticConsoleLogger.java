public class staticConsoleLogger
{
    // to track type of log
    public enum LogLevel
    {
        COMMENT, WARNING, ERROR
    }
    // private constructor
    private staticConsoleLogger() {}

    // log method
    public static void log(LogLevel level, String message)
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
        staticConsoleLogger.log(staticConsoleLogger.LogLevel.COMMENT, "Comment1");
        staticConsoleLogger.log(staticConsoleLogger.LogLevel.WARNING, "Warning1");
        staticConsoleLogger.log(staticConsoleLogger.LogLevel.ERROR, "Error1");
    }
}
