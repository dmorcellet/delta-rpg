package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Temple extends Place
{
  public Temple()
  {
  	// Nothing special to do
  }

  @Override
  public int getPlaceType()
  {
    return PlaceType.TEMPLE;
  }

  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
  }

  /**
   * Read the contents of this object from the specified binary data stream.
   * @param in Input stream.
   * @throws IOException
   */
  @Override
  protected void read(DataInputStream in)
      throws IOException
  {
    super.read(in);
  }

  @Override
  public String toString()
  {
    return "Temple '"+getName()+"'";
  }
}
