/**
 * Contains info about a match.
 */
public record Match(Wrestler wrestlerOne, Integer scoreOne, Wrestler wrestlerTwo, Integer scoreTwo) {
    @Override
    public String toString() { return wrestlerOne + " (" + scoreOne + ") vs " + wrestlerTwo + " (" + scoreOne + ")"; }
}
