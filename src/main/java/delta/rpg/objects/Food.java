package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Food object.
 * @author DAM
 */
public class Food extends RPGObject
{
  private int _nutritionPower;

  /**
   * Constructor.
   */
  public Food()
  {
    super();
    _nutritionPower=0;
  }

  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.FOOD;
  }

  /**
   * Get the nutritive power of this food item.
   * @return A nutritive value.
   */
  public int getNutritionLevel()
  {
    return _nutritionPower;
  }

  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
    out.writeInt(_nutritionPower);
  }

  @Override
  protected void read(DataInputStream in)
      throws IOException
  {
    super.read(in);
    _nutritionPower=in.readInt();
  }
}
