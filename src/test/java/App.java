//import jdk.jshell.JShell;
//import jdk.jshell.JShellException;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class App {
//    public static void main(String[] args) throws IOException {
//        try (JShell js = JShell.create(); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            js.onSnippetEvent(snip -> {
//                if (snip.status() == jdk.jshell.Snippet.Status.VALID) {
//                    System.out.println("➜ " + snip.value());
//                }
//                else {
//                    JShellException exception = snip.exception();
//                    if (exception != null) {
//                        String message = exception.getMessage();
//                        System.out.println("message = " + message);
//                    }
//                    System.out.println("snip = " + snip);
//             "a".replace("a","b");
//                }
//            });
//
//            System.out.print("> ");
//            for (String line = br.readLine(); line != null; line = br.readLine()) {
//                js.eval(js.sourceCodeAnalysis().analyzeCompletion(line).source());
//                System.out.print("> ");
//            }
//        }
//    }
//
//}
