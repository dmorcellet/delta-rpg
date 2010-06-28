package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.spells.Spell;
import delta.rpg.spells.SpellsRegistry;

public class MagicWand extends RPGObject
{
  private Spell _spell;
  private int _level;
  private int _charges;
  private int _maxCharges;

  public MagicWand()
  {
    super();
    _spell=null;
    _level=0;
    _charges=0;
    _maxCharges=0;
  }

  /**
   * Get the object's family.
   * @return the object's family.
   */
  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.MAGIC_WAND;
  }

  public void load(Spell spell, int level, int charges)
  {
    _spell=spell;
    _level=level;
    _charges=charges;
    _maxCharges=charges;
    setMagical(true);
  }

  public boolean isEmpty()
  {
    return((_spell==null)||(_charges==0));
  }

  public Spell getSpell()
  {
    return _spell;
  }

  public int getLevel()
  {
    return _level;
  }

  public int getCharges()
  {
    return _charges;
  }

  /**
   * Write the contents of this object to the specified binary data stream.
   * @param out Output stream.
   * @throws IOException
   */
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

  /**
   * Read the contents of this object from the specified binary data stream.
   * @param in Input stream.
   * @throws IOException
   */
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