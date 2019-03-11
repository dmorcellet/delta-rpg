package delta.rpg.maps;

/**
 * Represents a map.
 * @author DAM
 */
public class Map
{
  private String _name;

  /**
   * Constrcutor.
   * @param name Map name.
   */
  public Map(String name)
  {
    _name=name;
  }

  /**
   * Get the name of this map.
   * @return a name.
   */
  public String getName()
  {
    return _name;
  }
}
