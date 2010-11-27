package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Base class for places.
 * @author DAM
 */
public abstract class Place
{
  private static final String EMPTY_PLACE_NAME="";
  private String _name;

  /**
   * Constructor.
   */
  public Place()
  {
    _name=EMPTY_PLACE_NAME;
  }

  /**
   * Get the name of this place.
   * @return the name of this place.
   */
  public String getName()
  {
    return _name;
  }

  /**
   * Set the name of this place.
   * @param name Name to set.
   */
  public void setName(String name)
  {
    _name=name;
  }

  /**
   * Get the place type.
   * @return the place type.
   */
  public abstract int getPlaceType();

  @Override
  public String toString()
  {
    return "Place : "+_name;
  }

  protected void write(DataOutputStream out)
      throws IOException
  {
    out.writeUTF(_name);
  }

  /**
   * Read the contents of this object from the specified binary data stream.
   * @param in Input stream.
   * @throws IOException
   */
  protected void read(DataInputStream in)
      throws IOException
  {
    _name=in.readUTF();
  }
}
