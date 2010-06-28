package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.spells.Spell;
import delta.rpg.spells.SpellsRegistry;

public class Scroll extends RPGObject
{
  private Spell _spell;
  private int _level;

  public Scroll()
  {
    super();
    _spell=null;
    _level=0;
  }

  /**
   * Get the object's family.
   * @return the object's family.
   */
  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.SCROLL;
  }

  public Spell getSpell()
  {
    return _spell;
  }

  public int getLevel()
  {
    return _level;
  }

  public void setSpell(Spell spell, int level)
  {
    _spell=spell;
    _level=level;
    setMagical(true);
  }

  public boolean isEmpty()
  {
    return(_spell!=null);
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
    }
  }
}
