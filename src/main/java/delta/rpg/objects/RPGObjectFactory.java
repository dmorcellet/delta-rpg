package delta.rpg.objects;

import java.util.HashMap;

import org.apache.log4j.Logger;

import delta.rpg.utils.RPGLoggers;

/**
 * Factory for RPG objects.
 * @author DAM
 */
public class RPGObjectFactory
{
  private static final Logger _logger=RPGLoggers.getRPGLogger();

  private static RPGObjectFactory _instance=null;
  private HashMap<Integer, Class<RPGObject>> _entries;

  /**
   * Get the sole instance of this class.
   * @return the sole instance of this class.
   */
  public static RPGObjectFactory getInstance()
  {
    if(_instance==null)
    {
      _instance=new RPGObjectFactory();
    }
    return _instance;
  }

  /**
   * Constructor.
   */
  protected RPGObjectFactory()
  {
    _entries=new HashMap<Integer, Class<RPGObject>>();
  }

  /**
   * Add an object type.
   * @param objectType Object type.
   * @param implementation Associated implementation class.
   */
  public void add(int objectType, Class<RPGObject> implementation)
  {
    if(RPGObject.class.isAssignableFrom(implementation))
    {
      _entries.put(Integer.valueOf(objectType), implementation);
    }
    else
    {
      _logger.error("Class"+implementation.getName()+" is not a subclass of RPGObject");
    }
  }

  /**
   * Build an object instance.
   * @param objectType Object type.
   * @return the newly built object instance, or <code>null</code> if a problem occurred.
   */
  public RPGObject build(int objectType)
  {
    RPGObject ret=null;
    Integer key=Integer.valueOf(objectType);
    Class<RPGObject> clazz=_entries.get(key);
    if(clazz!=null)
    {
      try
      {
        ret=clazz.newInstance();
      }
      catch(Exception e)
      {
        _logger.error("Cannot build RPG object",e);
      }
    }
    return ret;
  }
}
