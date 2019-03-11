package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.spells.Spell;
import delta.rpg.spells.SpellsRegistry;

/**
 * Magic wand.
 * @author DAM
 */
public class MagicWand extends RPGObject
{
  private Spell _spell;
  private int _level;
  private int _charges;
  private int _maxCharges;

  /**
   * Constructor.
   */
  public MagicWand()
  {
    super();
    _spell=null;
    _level=0;
    _charges=0;
    _maxCharges=0;
  }

  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.MAGIC_WAND;
  }

  /**
   * Load a spell into this wand.
   * @param spell Spell to load.
   * @param level Spell level.
   * @param charges Number of charges to load.
   */
  public void load(Spell spell, int level, int charges)
  {
    _spell=spell;
    _level=level;
    _charges=charges;
    _maxCharges=charges;
    setMagical(true);
  }

  /**
   * Indicates if this wand is empty or not.
   * @return <code>true</code> if it is, <code>false</code> otherwise.
   */
  public boolean isEmpty()
  {
    return((_spell==null)||(_charges==0));
  }

  /**
   * Get the loaded spell.
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
   * Get the number of charges in the wand.
   * @return A number of charges.
   */
  public int getCharges()
  {
    return _charges;
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
      out.writeInt(_charges);
      out.writeInt(_maxCharges);
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
      _charges=in.readInt();
      _maxCharges=in.readInt();
    }
  }
}
