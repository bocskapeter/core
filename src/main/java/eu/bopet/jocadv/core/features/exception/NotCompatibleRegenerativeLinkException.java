package eu.bopet.jocadv.core.features.exception;

import eu.bopet.jocadv.core.features.RegenerativeLink;

public class NotCompatibleRegenerativeLinkException extends Exception {
    private final RegenerativeLink regenerativeLink;
    private final RegenerativeLink newRegenerativeLink;

    public NotCompatibleRegenerativeLinkException(RegenerativeLink regenerativeLink, RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = regenerativeLink;
        this.newRegenerativeLink = newRegenerativeLink;
    }

    @Override
    public String toString() {
        return "NotCompatibleRegenerativeLinkException{" +
                "regenerativeLink=" + regenerativeLink +
                ", newRegenerativeLink=" + newRegenerativeLink +
                '}';
    }
}
