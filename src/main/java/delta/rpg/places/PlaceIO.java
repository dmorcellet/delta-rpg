package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import delta.rpg.utils.RPGLoggers;

/**
 * I/O methods for RPG places.
 * @author DAM
 */
public class PlaceIO
{
  private static final Logger _logger=RPGLoggers.getRPGLogger();

  /**
   * Write the contents of the given object to the given data stream.
   * @param out Output data stream.
   * @param p Place to write.
   * @throws IOException If an I/O error occurs.
   */
  public static void write(DataOutputStream out, Place p)
      throws IOException
  {
    out.writeInt(p.getPlaceType());
    p.write(out);
  }

  /**
   * Read the contents of a place from the given data stream.
   * @param in Input data stream.
   * @throws IOException If an I/O error occurs.
   * @return the newly built place.
   */
  public static Place read(DataInputStream in)
      throws IOException
  {
    Place ret=null;
    int type=in.readInt();
    ret=PlaceFactory.getInstance().build(type);
    if(ret!=null)
    {
      ret.read(in);
    }
    else
    {
      _logger.error("Cannot build a place of type : "+type);
    }
    return ret;
  }
}
