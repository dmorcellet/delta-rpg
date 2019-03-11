package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.spells.Spell;
import delta.rpg.spells.SpellsRegistry;

/**
 * Potion object.
 * @author DAM
 */
public class Potion extends RPGObject
{
  private Spell _spell;
  private int _level;
  private int _doses;

  /**
   * Constructor.
   */
  public Potion()
  {
    super();
    _spell=null;
    _level=0;
    _doses=0;
  }

  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.POTION;
  }

  /**
   * Fill this potion with a spell.
   * @param spell Spell to put.
   * @param level Level of spell.
   * @param doses Number of doses.
   */
  public void fill(Spell spell, int level, int doses)
  {
    _spell=spell;
    _level=level;
    _doses=doses;
    setMagical(true);
  }

  /**
   * Indicates if this potion is empty or not.
   * @return <code>true</code> if it is empty.
   */
  public boolean isEmpty()
  {
    return((_spell==null)||(_doses==0));
  }

  /**
   * Get the spell loaded in this potion.
   * @return A spell or <code>null</code> if no loaded spell.
   */
  public Spell getSpell()
  {
    return _spell;
  }

  /**
   * Get the level of the loaded spell.
   * @return A level.
   */
  public int getLevel()
  {
    return _level;
  }

  /**
   * Get the number of doses in the potion.
   * @return A number of doses.
   */
  public int getDoses()
  {
    return _doses;
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
      out.writeInt(_doses);
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
      _doses=in.readInt();
    }
  }
}
