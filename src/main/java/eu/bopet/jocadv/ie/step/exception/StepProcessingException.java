package eu.bopet.jocadv.ie.step.exception;

public class StepProcessingException extends Exception {
    private final String errorLine;

    public StepProcessingException(String errorLine) {
        this.errorLine = errorLine;
    }

    @Override
    public String getMessage() {
        return "\n***\n*** Step processing exception in line: " + errorLine + "\n***";
    }

    @Override
    public String getLocalizedMessage() {
        // TODO localize message
        return getMessage();
    }
}
