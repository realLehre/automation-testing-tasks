package OOPConcept;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
        super.name = name;
    }
    private String name = "Simba";

    private String breed = "German Shepherd";


    private String bark(){
        return (name + " barks");
    }

    public  String feed(){
        return ("When " + bark() + " feed him");
    }
}
