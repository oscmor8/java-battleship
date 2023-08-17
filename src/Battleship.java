public class Battleship {
    private String name;
    private String location;
    private boolean isSunk;

    public Battleship(String name, String location) {
        this.name = name;
        this.location = location;
        this.isSunk = false;
    }

    public String getName() {
        return name;
    }

    public boolean checkGuess(String guess) {
        return location.equals(guess);
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void sink() {
        isSunk = true;
    }
}


