package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.spells.Spell;
import delta.rpg.spells.SpellsRegistry;

/**
 * Scroll object.
 * @author DAM
 */
public class Scroll extends RPGObject
{
  private Spell _spell;
  private int _level;

  /**
   * Constructor.
   */
  public Scroll()
  {
    super();
    _spell=null;
    _level=0;
  }

  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.SCROLL;
  }

  /**
   * Get the spell inscribed on this scroll.
   * @return A spell or <code>null</code> if nothing inscribed.
   */
  public Spell getSpell()
  {
    return _spell;
  }

  /**
   * Get the level of the spell inscribed on this scroll.
   * @return A level or 0 is no spell.
   */
  public int getLevel()
  {
    return _level;
  }

  /**
   * Set the spell inscribed on this scroll.
   * @param spell Spell to write.
   * @param level Level of the spell.
   */
  public void setSpell(Spell spell, int level)
  {
    _spell=spell;
    _level=level;
    setMagical(true);
  }

  /**
   * Indicates if this potion is empty or not.
   * @return <code>true</code> if it is empty.
   */
  public boolean isEmpty()
  {
    return(_spell!=null);
  }

  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
    if(_spell!=null)
    {
      out.writeBoolean(true);
      out.writeUTF(_spell.getCode());
      out.writeInt(_level);
    }
    else
    {
      out.writeBoolean(false);
    }
  }

  @Override
  protected void read(DataInputStream in)
      throws IOException
  {
    super.read(in);
    boolean hasSpell=in.readBoolean();
    if(hasSpell)
    {
      String code=in.readUTF();
      _spell=SpellsRegistry.getInstance().getSpellByCode(code);
      _level=in.readInt();
    }
  }
}
