package delta.rpg.spells;

import java.util.HashMap;

/**
 * Registry of known spells.
 * @author DAM
 */
public final class SpellsRegistry
{
  private static SpellsRegistry _instance;

  private HashMap<String, Spell> _knownSpells;

  /**
   * Get the sole instance of this class.
   * @return the sole instance of this class.
   */
  public static SpellsRegistry getInstance()
  {
    if(_instance==null)
    {
      _instance=new SpellsRegistry();
    }
    return _instance;
  }

  /**
   * Private constructor.
   */
  private SpellsRegistry()
  {
    _knownSpells=new HashMap<String, Spell>();
  }

  /**
   * Get a spell instance by its internal code.
   * @param spellCode Internal code of searched spell.
   * @return A spell instance or <code>null</code> if not found.
   */
  public Spell getSpellByCode(String spellCode)
  {
    return _knownSpells.get(spellCode);
  }

  /**
   * Register a new spell instance.
   * @param spell Spell to register.
   */
  public void registerSpell(Spell spell)
  {
    _knownSpells.put(spell.getCode(), spell);
  }
}
