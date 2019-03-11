package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import delta.rpg.spells.Spell;
import delta.rpg.spells.SpellsRegistry;
import delta.rpg.spells.SpellStatistics;

/**
 * Spell-book for a character. It contains:
 * <ul>
 * <li>the usage statistics for each spell.
 * </ul>
 * @author DAM
 */
public class PlayerSpellBook
{
  private HashMap<String,SpellStatistics> _spellStats;

  /**
   * Constructor.
   */
  public PlayerSpellBook()
  {
    super();
    _spellStats=new HashMap<String,SpellStatistics>();
  }

  /**
   * Add a spell.
   * @param spell Spell to add.
   * @param success Number of successful usages for this spell.
   * @param failures Number of failed usages for this spell.
   */
  public void addSpell(Spell spell, int success, int failures)
  {
    String spellCode=spell.getCode();
    SpellStatistics stat=_spellStats.get(spellCode);
    if(stat!=null)
    {
      _spellStats.remove(spellCode);
    }
    _spellStats.put(spellCode, new SpellStatistics(spell, success, failures));
  }

  /**
   * Write the contents of this object to the given data stream.
   * @param out Output data stream.
   * @throws IOException If an I/O error occurs.
   */
  public void write(DataOutputStream out)
      throws IOException
  {
    SpellStatistics stats;
    int nb=_spellStats.size();
    out.writeInt(nb);
    if(nb>0)
    {
      Set<Map.Entry<String, SpellStatistics>> set=_spellStats.entrySet();
      Map.Entry<String, SpellStatistics> entry;
      for(Iterator<Map.Entry<String, SpellStatistics>> it=set.iterator();it.hasNext();)
      {
        entry=it.next();
        stats=entry.getValue();
        out.writeUTF(entry.getKey());
        out.writeInt(stats.getSuccess());
        out.writeInt(stats.getFailures());
      }
    }
  }

  /**
   * Read the contents of this object from the given data stream.
   * @param in Input data stream.
   * @throws IOException If an I/O error occurs.
   */
  public void read(DataInputStream in)
      throws IOException
  {
    String spellCode;
    Spell spell;
    _spellStats.clear();
    int nb=in.readInt();
    for(int k=0;k<nb;k++)
    {
      spellCode=in.readUTF();
      int success=in.readInt();
      int failures=in.readInt();
      spell=SpellsRegistry.getInstance().getSpellByCode(spellCode);
      addSpell(spell, success, failures);
    }
  }

  /**
   * Indicates if it contains the designated spell or not.
   * @param spellCode Code of spell to use.
   * @return <code>true</code> if the spell was found, <code>false</code> otherwise.
   */
  public boolean containsSpell(String spellCode)
  {
    SpellStatistics stats=_spellStats.get(spellCode);
    return (stats!=null);
  }
}
