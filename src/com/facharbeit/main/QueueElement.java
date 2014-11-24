package com.facharbeit.main;

import com.facharbeit.tools.*;
import java.lang.reflect.*;

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
