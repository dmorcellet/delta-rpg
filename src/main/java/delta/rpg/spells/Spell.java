package delta.rpg.spells;

/**
 * Spell.
 * @author DAM
 */
public class Spell
{
  /**
   * Maximum level for spells.
   */
  public static final int MAX_SPELL_LEVEL=12;
  private String _code;
  private String _name;
  private int _level;
  private SpellType _spellType;

  /**
   * Constructor.
   * @param code Internal code.
   * @param name Spell name.
   * @param level Spell level.
   * @param spellType Spell type.
   */
  public Spell(String code, String name, int level, SpellType spellType)
  {
    _code=code;
    _name=name;
    _level=level;
    _spellType=spellType;
  }

  /**
   * Get the internal code for this spell.
   * @return an internal code.
   */
  public String getCode()
  {
    return _code;
  }

  /**
   * Get the name of this spell.
   * @return the name of this spell.
   */
  public String getName()
  {
    return _name;
  }

  /**
   * Get the type of this spell.
   * @return the type of this spell.
   */
  public SpellType getSpellType()
  {
    return _spellType;
  }

  /**
   * Get the level of this spell.
   * @return A level.
   */
  public int getLevel()
  {
    return _level;
  }

  @Override
  public String toString()
  {
    StringBuilder sb=new StringBuilder();
    sb.append("Spell '").append(_name).append('\'');
    sb.append(" (level ").append(_level).append(')');
    if (_spellType!=null)
    {
      sb.append(" (").append(_spellType.getI18NKey()).append(')');
    }
    String ret=sb.toString();
    return ret;
  }
}
