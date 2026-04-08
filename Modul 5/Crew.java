public class Crew implements ICrew, IKickable {
    
    private String name;
    private boolean isAlive = true;

    public void setAlive(boolean status) {
        this.isAlive = status;
    }

    public Crew(String name) {
        this.name = name;
    }
    
    @Override
    public void doWork() {
        System.out.println("Crew " + this.name + " is doing work.");
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    public void callMeeting() {
        if (!isAlive) {
            System.out.println(this.name + " is dead and cannot call meeting.");
            return;
        }

        System.out.print(this.name + " found a corpse ");
        System.out.print("and calls a meeting. ");
        System.out.println("Let's find the impostor!");
    }

    @Override
    public void kick() {
        System.out.println(this.name + " was kicked from the ship.");
    }
    
}