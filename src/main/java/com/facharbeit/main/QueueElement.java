package com.facharbeit.main;

import com.facharbeit.tools.Logger;
import java.lang.reflect.Method;

/**
 * Element, das an die Warteschlange angehängt werden kann.
 */
public class QueueElement
{
    /**
     * Methode des Elements.
     */
    private Method method;

    /**
     * Initialisiert ein neues Element.
     *
     * @param method Methode
     */
    public QueueElement(Method method)
    {
        this.method = method;
    }

    /**
     * Führt die Methode des Elements aus.
     */
    public void invoke()
    {
        try
        {
            Logger.logIntern("\"" + method.getName() + "\"");
            method.invoke(null);
        }
        catch(Exception ex)
        {
            Logger.log(method.getName() + " konnte nicht ausgeführt werden", 2);
            Logger.error(ex);
        }
    }
}
