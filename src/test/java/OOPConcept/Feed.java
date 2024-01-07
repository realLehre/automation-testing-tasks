package OOPConcept;

public class Feed extends Animal{

    public Feed(String name) {
        super(name);
    }

    public static void main(String[] args){
        feed();
    }
    private static Dog dog = new Dog("Jacqueline");

    public static   void feed(){
        System.out.println(dog.feed());
    }
}
