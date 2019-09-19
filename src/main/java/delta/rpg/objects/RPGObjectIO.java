package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * I/O methods for RPG objects.
 * @author DAM
 */
public class RPGObjectIO
{
  private static final Logger LOGGER=Logger.getLogger(RPGObjectIO.class);

  /**
   * Write the contents of the given object to the given data stream.
   * @param out Output data stream.
   * @param o Object to write.
   * @throws IOException If an I/O error occurs.
   */
  public static void write(DataOutputStream out, RPGObject o)
      throws IOException
  {
    ObjectFamily family=o.getObjectType();
    out.writeInt(family.getCode());
    o.write(out);
  }

  /**
   * Read the contents of an object from the given data stream.
   * @param in Input data stream.
   * @throws IOException If an I/O error occurs.
   * @return the newly built object.
   */
  public static RPGObject read(DataInputStream in)
      throws IOException
  {
    RPGObject ret=null;
    int type=in.readInt();
    ret=RPGObjectFactory.getInstance().build(type);
    if(ret!=null)
    {
      ret.read(in);
    }
    else
    {
      LOGGER.error("Cannot build an object of type : "+type);
    }
    return ret;
  }
}
