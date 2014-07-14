package com.epam.jjp.sjspt.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

public class MessageSourcePropertyEditor extends PropertyEditorSupport {

    private MessageSourceAccessor messageSourceAccessor;

    public MessageSourcePropertyEditor(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource,new Locale("hu_Hu"));
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String value = text;

        if (text.startsWith("i18n:")) {
            value = messageSourceAccessor.getMessage(text.substring(5));
        }

        setValue(value);
    }
}