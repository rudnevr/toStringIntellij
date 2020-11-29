public class Application {
    String methodName(int a, int b) {
        System.out.println("int a = " + a + ";" + "int b = " + b + ";" + "String actual=new Application().methodName(a, b);");
        System.out.println("int a = " + a + ";" + "int b = " + b + ";" + "String actual=new Application().methodName(a, b);");
        return null;
    }

    Clazz acceptAndReturn(Clazz clazz) {
        System.out.println("Clazz clazz = " + clazz.toString() + ";" + "Clazz actual=new Application().acceptAndReturn(clazz);");
        return clazz;
    }
}
