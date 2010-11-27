package delta.rpg.spells;

public class Spell
{
  public static final int MAX_SPELL_LEVEL=12;
  private String _code;
  private String _name;
  private int _level;
  private SpellType _spellType;

  public Spell(String code, String name, int level, SpellType spellType)
  {
    _code=code;
    _name=name;
    _level=level;
    _spellType=spellType;
  }

  public String getCode()
  {
    return _code;
  }

  public String getName()
  {
    return _name;
  }

  public SpellType getSpellType()
  {
    return _spellType;
  }

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
