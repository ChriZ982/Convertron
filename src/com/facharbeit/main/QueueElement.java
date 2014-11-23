package com.facharbeit.main;

import com.facharbeit.tools.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QueueElement
{
    private Method method;
    private Object[] args;

    public QueueElement(Method method, Object[] args)
    {
        this.method = method;
        this.args = args;
    }

    public void invoke()
    {
        try
        {
            method.invoke(null, args);
        } catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            Logger.log(method.getName() + " konnte nicht ausgeführt werden.", 2);
        }
    }
}
