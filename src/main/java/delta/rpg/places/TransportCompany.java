package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Transport company.
 * @author DAM
 */
public class TransportCompany extends Place
{
  /**
   * Constructor.
   */
  public TransportCompany()
  {
  	// Nothing special to do
  }

  @Override
  public int getPlaceType()
  {
    return PlaceType.TRANSPORT_COMPANY;
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
    return "Transport company '"+getName()+"'";
  }
}
