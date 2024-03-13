package jonhoare;

public class BadInput extends RuntimeException {

  private static final String MESSAGE = "Single argument required, in range A-Z";

  public BadInput() {
    super(MESSAGE);
  }
}
