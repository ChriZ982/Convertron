package eu.convertron.interlib.util;

public class Bundle<A, B>
{
    private A a;
    private B b;

    public Bundle()
    {
    }

    public Bundle(A a, B b)
    {
        this.a = a;
        this.b = b;
    }

    public A getA()
    {
        return a;
    }

    public void setA(A a)
    {
        this.a = a;
    }

    public B getB()
    {
        return b;
    }

    public void setB(B b)
    {
        this.b = b;
    }
}
