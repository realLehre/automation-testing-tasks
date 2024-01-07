package OOPConcept;

public class Dog {
    private String name = "Simba";

    private String breed = "German Shepherd";

    private String bark(){
        return (name + " barks");
    }

    public  String feed(){
        return ("When " + bark() + " feed him");
    }
}
