package delta.rpg.objects;

import java.util.HashMap;

import org.apache.log4j.Logger;

import delta.rpg.utils.RPGLoggers;

public class RPGObjectFactory
{
  private static final Logger _logger=RPGLoggers.getRPGLogger();

  private static RPGObjectFactory _instance=null;
  private HashMap<Integer, Class<RPGObject>> _entries;

  public static RPGObjectFactory getInstance()
  {
    if(_instance==null)
    {
      _instance=new RPGObjectFactory();
    }
    return _instance;
  }

  protected RPGObjectFactory()
  {
    _entries=new HashMap<Integer, Class<RPGObject>>();
  }

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
