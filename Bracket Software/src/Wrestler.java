/**
 * Contains info about a wrestler.
 */
public record Wrestler(String name, String record, String school, Integer seed) {
    @Override
    public String toString() { return "(" + seed + ") " + name + " (" + school + ") " + record; }
}