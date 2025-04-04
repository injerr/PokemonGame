package Objects;

public class OptionDuplicateException extends Exception {
  public OptionDuplicateException() {
    super("La opción ya existe");
  }

}