package delta.rpg.spells;

import java.util.ArrayList;
import java.util.List;

public final class SpellType
{
  private static int _counter=0;
  public static final List<SpellType> ALL=new ArrayList<SpellType>();
  public static final SpellType MAGICIAN=new SpellType("MAGICIAN");
  public static final SpellType PRIEST=new SpellType("PRIEST");
  public static final int NB_SPELL_TYPES=ALL.size();

  private int _code;
  private String _i18nKey;

  private SpellType(String label)
  {
    _code=_counter;
    _i18nKey=label;
    _counter++;
    ALL.add(this);
  }

  public int getCode()
  {
    return _code;
  }

  public String getI18NKey()
  {
    return _i18nKey;
  }
}
