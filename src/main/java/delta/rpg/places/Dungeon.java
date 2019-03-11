package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Dungeon.
 * @author DAM
 */
public class Dungeon extends Place
{
  /**
   * Constructor.
   */
  public Dungeon()
  {
    // Nothing to do !!
  }

  @Override
  public int getPlaceType()
  {
    return PlaceType.DUNGEON;
  }

  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
  }

  @Override
  protected void read(DataInputStream in)
      throws IOException
  {
    super.read(in);
  }

  @Override
  public String toString()
  {
    return "Dungeon '"+getName()+"'";
  }
}
