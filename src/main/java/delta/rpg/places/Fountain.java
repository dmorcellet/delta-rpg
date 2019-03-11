package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Fountain.
 * @author DAM
 */
public class Fountain extends Place
{
  /**
   * Constructor.
   */
  public Fountain()
  {
    // Nothing to do !!
  }

  @Override
  public int getPlaceType()
  {
    return PlaceType.FOUNTAIN;
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
    return "Fountain '"+getName()+"'";
  }
}
