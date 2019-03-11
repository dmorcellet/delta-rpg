package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Tavern.
 * @author DAM
 */
public class Tavern extends Place
{
  /**
   * Constructor.
   */
  public Tavern()
  {
  	// Nothing special to do
  }

  @Override
  public int getPlaceType()
  {
    return PlaceType.TAVERN;
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
    return "Tavern '"+getName()+"'";
  }
}
