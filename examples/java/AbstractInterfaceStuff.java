package java;

public class AbstractInterfaceStuff {
    public static void main(String[] args) {
        // HelloInterface hi = new GreeterAbstract(); // throws error "Cannot instantiate the type GreeterAbstract"
        HelloInterface hi = new HelloClass();
        hi.sayHello();
        GreeterAbstract ga = new HelloWorldClass();
        ga.sayHelloName();
        ga = new HelloWorldClass("Bob");
        ga.sayHelloName();
        String foobar = ga.foobar();
        System.out.println("foobar: " + foobar);
    }
}

interface HelloInterface {
    // String type; // illegal, need to provide a value
    abstract void sayHello();
    abstract void sayHello(String name);
}

class HelloClass implements HelloInterface {

    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }
}

interface FoobarInterface {
    abstract String foobar();
}

abstract class GreeterAbstract implements HelloInterface, FoobarInterface {

    private String defaultName = "Alice";
    String name;

    public GreeterAbstract() {
        this.name = defaultName;
    }

    public GreeterAbstract(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    public void sayHelloName() {
        System.out.println("Hello " + name);
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }

    @Override
    public String foobar() {
        return "foobar";
    }

    abstract void sayHelloWorld();
}

class HelloWorldClass extends GreeterAbstract {

    public HelloWorldClass() {
        super();
    }

    public HelloWorldClass(String name) {
        super(name);
    }

    @Override
    public void sayHelloWorld() {
        System.out.println("Hello world!");
    }

    @Override
    public void sayHelloName() {
        System.out.println("Hello " + name + "!");
    }
}