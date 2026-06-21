public class Logger {

    // Step 1: private static instance of itself
    private static Logger instance;

    // Optional: keep a simple log count to prove state is shared
    private int logCount = 0;

    // Step 2: private constructor prevents external instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: public static method to get the single instance
    // (thread-safe lazy initialization using synchronized)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "]: " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}