
public class ChainPattern {
    public static void main(String[] args) {

        Logger logger0 = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage(" Safe and sound ", Level.INFO);
        logger0.writeMessage("Debugging mode is ongoing ", Level.DEBUG);
        logger0.writeMessage("System has felt down! ", Level.ERROR);
    }

}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger{
    int priority;
    public Logger(int priority) {this.priority = priority;}

    Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }
    public void writeMessage(String message, int level) {
        if(level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}

class SMSLogger extends Logger {
    public SMSLogger(int priority) {super(priority);}
    public void write(String message) {
        System.out.println("SMS: " + message);
    }
}

class FileLogger extends Logger {
    public FileLogger(int priority) {super(priority);}
    public void write(String message) {
        System.out.println("Writing in file: " + message);
    }
}
class EmailLogger extends Logger{
    public EmailLogger(int priority) {super(priority);}
    public void write(String message) {
        System.out.println("E-mail message: " + message);
    }
}