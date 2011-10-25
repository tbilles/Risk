package risk.common;

import java.io.PrintStream;

import javax.swing.JTextArea;

public class RiskIO {
    private static JTextArea clientOutput = new JTextArea();
    private static JTextArea serverOutput = new JTextArea();

    public static void clientPrintln(Object o) {
        clientOutput.append(o.toString() + "\n");
    }

    public static void serverPrintln(Object o) {
        serverOutput.append(o.toString() + "\n");
    }

    public static JTextArea getClientTextArea() {
        return clientOutput;
    }

    public static JTextArea getServerTextArea() {
        return serverOutput;
    }

}
