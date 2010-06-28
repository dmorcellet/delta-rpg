package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Dungeon extends Place
{
  public Dungeon()
  {
    // Nothing to do !!
  }

  public int getPlaceType()
  {
    return PlaceType.DUNGEON;
  }

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

  public String toString()
  {
    return "Dungeon '"+getName()+"'";
  }
}
