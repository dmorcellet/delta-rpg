package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import delta.rpg.utils.RPGLoggers;

public class RPGObjectIO
{
  private static final Logger _logger=RPGLoggers.getRPGLogger();

  public static void write(DataOutputStream out, RPGObject o)
      throws IOException
  {
    ObjectFamily family=o.getObjectType();
    out.writeInt(family.getCode());
    o.write(out);
  }

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
      _logger.error("Cannot build an object of type : "+type);
    }
    return ret;
  }
}
