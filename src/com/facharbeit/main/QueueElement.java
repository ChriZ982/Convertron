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
     * Parameter zur Methode.
     */
    private Object[] args;

    /**
     * Initialisiert ein neues Element.
     *
     * @param method Methode
     * @param args   Parameter
     */
    public QueueElement(Method method, Object[] args)
    {
        this.method = method;
        this.args = args;
    }

    /**
     * Führt die Methode des Elements aus.
     */
    public void invoke()
    {
        try
        {
            String toLog = method.getName() + "\n        args:";
            for(Object o : args)
                toLog += "  " + o.toString();
            Logger.logIntern(toLog);

            method.invoke(null, args);
        } catch(Exception ex)
        {
            Logger.log(method.getName() + " konnte nicht ausgeführt werden", 2);
            Logger.error(ex);
        }
    }
}
