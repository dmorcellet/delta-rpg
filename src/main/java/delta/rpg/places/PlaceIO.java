package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import delta.rpg.utils.RPGLoggers;

public class PlaceIO
{
  private static final Logger _logger=RPGLoggers.getRPGLogger();

  public static void write(DataOutputStream out, Place p)
      throws IOException
  {
    out.writeInt(p.getPlaceType());
    p.write(out);
  }

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
