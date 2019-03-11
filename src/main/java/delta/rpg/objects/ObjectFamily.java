package delta.rpg.objects;

/**
 * Symbolic constants for object families.
 * @author DAM
 */
public final class ObjectFamily
{
  private static int _counter=0;

  private int _code;
  private String _i18nKey;

  /**
   * Private constructor.
   * @param i18nkey Key used for i18n.
   */
  private ObjectFamily(String i18nkey)
  {
    _i18nKey=i18nkey;
    _code=_counter;
    _counter++;
  }

  /**
   * Melee weapon.
   */
  public static final ObjectFamily MELEE_WEAPON=new ObjectFamily("MELEE_WEAPON");
  /**
   * Thrown weapon.
   */
  public static final ObjectFamily THROWN_WEAPON=new ObjectFamily("THROWN_WEAPON");
  /**
   * Armor.
   */
  public static final ObjectFamily ARMOR=new ObjectFamily("ARMOR");
  /**
   * Potion.
   */
  public static final ObjectFamily POTION=new ObjectFamily("POTION");
  /**
   * Scroll.
   */
  public static final ObjectFamily SCROLL=new ObjectFamily("SCROLL");
  /**
   * Ring.
   */
  public static final ObjectFamily RING=new ObjectFamily("RING");
  /**
   * Magic wand.
   */
  public static final ObjectFamily MAGIC_WAND=new ObjectFamily("MAGIC_WAND");
  /**
   * Food.
   */
  public static final ObjectFamily FOOD=new ObjectFamily("FOOD");
  /**
   * Container.
   */
  public static final ObjectFamily CONTAINER=new ObjectFamily("CONTAINER");
  /**
   * Spells book.
   */
  public static final ObjectFamily SPELLBOOK=new ObjectFamily("SPELLBOOK");
  /**
   * Light source.
   */
  public static final ObjectFamily LIGHT_SOURCE=new ObjectFamily("LIGHT_SOURCE");
  /**
   * Jewel.
   */
  public static final ObjectFamily JEWEL=new ObjectFamily("JEWEL");

  /**
   * Get the internal code of this object family.
   * @return the internal code of this object family.
   */
  public int getCode()
  {
    return _code;
  }

  /**
   * Get the i18n key for this object family.
   * @return the i18n key for this object family.
   */
  public String getKey()
  {
    return _i18nKey;
  }
}
