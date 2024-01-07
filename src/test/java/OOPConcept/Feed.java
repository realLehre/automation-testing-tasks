package OOPConcept;

public class Feed {

    public static void main(String[] args){
        feed();
    }
    private static Dog dog = new Dog();

    public static   void feed(){
        System.out.println(dog.feed());
    }
}
