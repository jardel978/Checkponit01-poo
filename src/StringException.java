public class StringException extends Exception{

    public StringException() { }

    public StringException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "A seguinte excessão ocorreu: " + getClass().getName() + "Mensagem: " + getMessage();
    }
}