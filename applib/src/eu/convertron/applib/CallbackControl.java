package eu.convertron.applib;

import java.util.function.Consumer;

public abstract class CallbackControl<T>
{
    private final Consumer<T> listener;

    private T result;
    private boolean resultSet = false;

    private final Object sync = new Object();

    public CallbackControl(Consumer<T> listener)
    {
        this.listener = listener;
    }

    protected void finishDialog(T result)
    {
        if(resultSet)
            throw new UnsupportedOperationException("Result set already");

        this.result = result;
        resultSet = true;

        synchronized(sync)
        {
            sync.notifyAll();
        }

        if(listener != null)
        {
            listener.accept(result);
        }
    }

    public T getResult()
    {
        if(!resultSet)
            throw new UnsupportedOperationException("Result not set yet");

        return result;
    }

    public T waitForResult() throws InterruptedException
    {
        return waitForResult(0);
    }

    public T waitForResult(int timeout) throws InterruptedException
    {
        if(!resultSet)
            sync.wait(timeout);

        return getResult();
    }
}
