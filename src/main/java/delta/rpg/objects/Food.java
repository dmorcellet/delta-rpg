package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Food extends RPGObject
{
  private int _nutritionPower;

  public Food()
  {
    super();
    _nutritionPower=0;
  }

  /**
   * Get the object's family.
   * @return the object's family.
   */
  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.FOOD;
  }

  public int getNutritionLevel()
  {
    return _nutritionPower;
  }

  /**
   * Write the contents of this object to the specified binary data stream.
   * @param out Output stream.
   * @throws IOException
   */
  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
    out.writeInt(_nutritionPower);
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
    _nutritionPower=in.readInt();
  }
}
