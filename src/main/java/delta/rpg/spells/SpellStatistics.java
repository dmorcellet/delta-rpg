package delta.rpg.spells;

/**
 * Statistics on the usage of a spell by a single player.
 * @author DAM
 */
public class SpellStatistics
{
  /**
   * Involved spell.
   */
  private Spell _spell;
  /**
   * Number of successful casts.
   */
  private int _success;
  /**
   * Number of failed casts.
   */
  private int _failures;

  /**
   * Constructor.
   * @param spell Involved spell.
   */
  public SpellStatistics(Spell spell)
  {
    _spell=spell;
  }

  /**
   * Full constructor.
   * @param spell Involved spell.
   * @param success Number of successful casts.
   * @param failures Number of failed casts.
   */
  public SpellStatistics(Spell spell, int success, int failures)
  {
    _spell=spell;
    _success=success;
    _failures=failures;
  }

  /**
   * Get the involved spell.
   * @return the involved spell.
   */
  public Spell getSpell()
  {
    return _spell;
  }

  /**
   * Add a new successful cast.
   */
  public void addSuccess()
  {
    _success++;
  }

  /**
   * Add a new failed cast.
   */
  public void addFailure()
  {
    _failures++;
  }

  /**
   * Get the number of successful casts.
   * @return the number of successful casts.
   */
  public int getSuccess()
  {
    return _success;
  }

  /**
   * Get the number of failed casts.
   * @return the number of failed casts.
   */
  public int getFailures()
  {
    return _failures;
  }
}
