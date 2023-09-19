package InternetProgram.Test.Test5;

public class Run {
    public static void main(String[] args) {
        new Thread(new WebServer()).start();
    }
}
