package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Place
{
  private static final String EMPTY_PLACE_NAME="";
  private String _name;

  public Place()
  {
    _name=EMPTY_PLACE_NAME;
  }

  public String getName()
  {
    return _name;
  }

  public void setName(String name)
  {
    _name=name;
  }

  public abstract int getPlaceType();

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
