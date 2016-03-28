package eu.convertron.applib.etc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.nio.charset.StandardCharsets.UTF_8;

public class SerializeUtils
{
    public static String serializeAsString(Serializable obj)
    {
        return new String(serialize(obj), UTF_8);
    }

    public static byte[] serialize(Serializable obj)
    {
        try
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream objStream = new ObjectOutputStream(out);
            objStream.writeObject(obj);
            return out.toByteArray();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Failed to serialize Object of type "
                                       + (obj == null ? "null" : obj.getClass().getName()), ex);
        }
    }

    public static <T> T deserialize(String s)
    {
        return deserialize(s.getBytes(UTF_8));
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] buf)
    {
        try
        {
            ByteArrayInputStream in = new ByteArrayInputStream(buf);
            ObjectInputStream objStream = new ObjectInputStream(in);
            Object o = objStream.readObject();
            return (T)o;
        }
        catch(ClassCastException ex)
        {
            throw new RuntimeException("The serialized Object is of wrong type", ex);
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Failed to deserialize ChangeSet Entry", ex);
        }
    }

    private SerializeUtils()
    {
    }
}
