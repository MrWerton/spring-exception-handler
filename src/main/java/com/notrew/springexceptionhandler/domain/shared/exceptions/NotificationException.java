package com.notrew.springexceptionhandler.domain.shared.exceptions;

import com.notrew.springexceptionhandler.domain.shared.validations.Notification;

public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }
}