package delta.rpg.places;

import java.util.HashMap;

import org.apache.log4j.Logger;

import delta.rpg.utils.RPGLoggers;

public class PlaceFactory
{
  private static final Logger _logger=RPGLoggers.getRPGLogger();

  private static PlaceFactory _instance=null;
  private HashMap<Integer,Class<Place>> _entries;

  public static PlaceFactory getInstance()
  {
    if(_instance==null)
    {
      _instance=new PlaceFactory();
    }
    return _instance;
  }

  protected PlaceFactory()
  {
    _entries=new HashMap<Integer,Class<Place>>();
  }

  public void add(int placeType, Class<Place> implementation)
  {
    if(Place.class.isAssignableFrom(implementation))
    {
      _entries.put(Integer.valueOf(placeType), implementation);
    }
    else
    {
      _logger.error("Class"+implementation.getName()+" is not a subclass of Place");
    }
  }

  public Place build(int placeType)
  {
    Place ret=null;
    Integer key=Integer.valueOf(placeType);
    Class<Place> clazz=_entries.get(key);
    if(clazz!=null)
    {
      try
      {
        ret=clazz.newInstance();
      }
      catch(Exception e)
      {
        _logger.error("Cannot build place", e);
      }
    }
    return ret;
  }
}
