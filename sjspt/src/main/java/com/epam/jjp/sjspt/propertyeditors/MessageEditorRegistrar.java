package com.epam.jjp.sjspt.propertyeditors;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.context.MessageSource;

public class MessageEditorRegistrar implements PropertyEditorRegistrar {

    private MessageSource messageSource;

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(String.class, new MessageSourcePropertyEditor(messageSource));

    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}