package delta.rpg.objects;

/**
 * Symbolic constants for object locations.
 * @author DAM
 */
public final class ObjectLocation
{
  private static int _counter=0;
  
  private int _code;
  private String _i18nKey;

  /**
   * Private constructor.
   * @param i18nkey Key used for i18n.
   */
  private ObjectLocation(String i18nkey)
  {
    _i18nKey=i18nkey;
    _code=_counter;
    _counter++;
  }

  /**
   * Head.
   */
  public static final ObjectLocation HEAD=new ObjectLocation("HEAD");
  /**
   * Neck.
   */
  public static final ObjectLocation NECK=new ObjectLocation("NECK");
  /**
   * Torso.
   */
  public static final ObjectLocation TORSO=new ObjectLocation("TORSO");
  /**
   * Back.
   */
  public static final ObjectLocation BACK=new ObjectLocation("BACK");
  /**
   * Belt.
   */
  public static final ObjectLocation BELT=new ObjectLocation("BELT");
  /**
   * Left wrist.
   */
  public static final ObjectLocation LEFT_WRIST=new ObjectLocation("LEFT_WRIST");
  /**
   * Right wrist.
   */
  public static final ObjectLocation RIGHT_WRIST=new ObjectLocation("RIGHT_WRIST");
  /**
   * Legs.
   */
  public static final ObjectLocation LEGS=new ObjectLocation("LEGS");
  /**
   * Feet.
   */
  public static final ObjectLocation FEET=new ObjectLocation("FEET");
  /**
   * Left hand.
   */
  public static final ObjectLocation LEFT_HAND=new ObjectLocation("LEFT_HAND");
  /**
   * Right hand.
   */
  public static final ObjectLocation RIGHT_HAND=new ObjectLocation("RIGHT_HAND");
  /**
   * Rucksack.
   */
  public static final ObjectLocation RUCKSACK=new ObjectLocation("RUCKSACK");
  /**
   * Quiver.
   */
  public static final ObjectLocation QUIVER=new ObjectLocation("QUIVER");
  /**
   * Dagger holder.
   */
  public static final ObjectLocation DAGGER_HOLDER=new ObjectLocation("DAGGER_HOLDER");
  /**
   * Left little finger.
   */
  public static final ObjectLocation LEFT_LITTLE_FINGER=new ObjectLocation("LEFT_LITTLE_FINGER");
  /**
   * Left ring finger.
   */
  public static final ObjectLocation LEFT_RING_FINGER=new ObjectLocation("LEFT_RING_FINGER");
  /**
   * Left middle finger.
   */
  public static final ObjectLocation LEFT_MIDDLE_FINGER=new ObjectLocation("LEFT_MIDDLE_FINGER");
  /**
   * Left index finger.
   */
  public static final ObjectLocation LEFT_INDEX_FINGER=new ObjectLocation("LEFT_INDEX_FINGER");
  /**
   * Left thumb.
   */
  public static final ObjectLocation LEFT_THUMB=new ObjectLocation("LEFT_THUMB");
  /**
   * Right thumb.
   */
  public static final ObjectLocation RIGHT_THUMB=new ObjectLocation("RIGHT_THUMB");
  /**
   * Right index finger.
   */
  public static final ObjectLocation RIGHT_INDEX_FINGER=new ObjectLocation("RIGHT_INDEX_FINGER");
  /**
   * Right middle finger.
   */
  public static final ObjectLocation RIGHT_MIDDLE_FINGER=new ObjectLocation("RIGHT_MIDDLE_FINGER");
  /**
   * Right ring finger.
   */
  public static final ObjectLocation RIGHT_RING_FINGER=new ObjectLocation("RIGHT_RING_FINGER");
  /**
   * Right little finger.
   */
  public static final ObjectLocation RIGHT_LITTLE_FINGER=new ObjectLocation("RIGHT_LITTLE_FINGER");
  /**
   * Hands.
   */
  public static final ObjectLocation HANDS=new ObjectLocation("HANDS");

  /**
   * Get the internal code of this object location.
   * @return the internal code of this object location.
   */
  public int getCode()
  {
    return _code;
  }

  /**
   * Get the i18n key for this object location.
   * @return the i18n key for this object location.
   */
  public String getKey()
  {
    return _i18nKey;
  }
}
