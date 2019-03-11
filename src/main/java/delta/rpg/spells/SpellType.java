package delta.rpg.spells;

import java.util.ArrayList;
import java.util.List;

/**
 * Spell family.
 * @author DAM
 */
public final class SpellType
{
  private static int _counter=0;
  /**
   * List of all spell types.
   */
  public static final List<SpellType> ALL=new ArrayList<SpellType>();

  /**
   * Magician spells.
   */
  public static final SpellType MAGICIAN=new SpellType("MAGICIAN");
  /**
   * Priest spells.
   */
  public static final SpellType PRIEST=new SpellType("PRIEST");
  /**
   * Number of spell types.
   */
  public static final int NB_SPELL_TYPES=ALL.size();

  private int _code;
  private String _i18nKey;

  /**
   * Private constructor.
   * @param label Type name.
   */
  private SpellType(String label)
  {
    _code=_counter;
    _i18nKey=label;
    _counter++;
    ALL.add(this);
  }

  /**
   * Get the internal code for this spell type.
   * @return An internal integer code.
   */
  public int getCode()
  {
    return _code;
  }

  /**
   * Get the i18n key for this spell type.
   * @return An i18n key.
   */
  public String getI18NKey()
  {
    return _i18nKey;
  }
}
