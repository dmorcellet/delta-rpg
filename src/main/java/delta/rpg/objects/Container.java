package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Container extends RPGObject
{
  private ArrayList<RPGObject> _objects;
  private int _totalVolume;
  private int _totalWeight;
  private int _maxObjects;
  private int _maxWeigth;
  private int _maxVolume;

  public Container()
  {
    super();
    _objects=new ArrayList<RPGObject>();
    _totalVolume=0;
    _totalWeight=0;
    _maxObjects=10;
    _maxWeigth=Integer.MAX_VALUE;
    _maxVolume=Integer.MAX_VALUE;
  }

  /**
   * Get the object's family.
   * @return the object's family.
   */
  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.CONTAINER;
  }

  public boolean addObject(RPGObject object)
  {
    boolean ret=false;

    int objectWeight=object.getWeight();
    int objectVolume=object.getVolume();

    if((_totalWeight+objectWeight<=_maxWeigth)&&(_totalVolume+objectVolume<=_maxVolume)&&(_objects.size()<_maxObjects))
    {
      _objects.add(object);
      _totalWeight+=objectWeight;
      _totalVolume+=objectVolume;
      ret=true;
    }

    return ret;
  }

  @Override
  public int getTotalVolume()
  {
    return _totalVolume;
  }

  @Override
  public int getTotalWeight()
  {
    return _totalWeight;
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
    out.writeInt(_maxObjects);
    out.writeInt(_maxWeigth);
    out.writeInt(_maxVolume);

    int n=_objects.size();
    out.writeInt(n);
    RPGObject o;
    for(int i=0;i<n;i++)
    {
      o=_objects.get(i);
      RPGObjectIO.write(out, o);
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
    _maxObjects=in.readInt();
    _maxWeigth=in.readInt();
    _maxVolume=in.readInt();

    int n=in.readInt();

    RPGObject o;
    for(int i=0;i<n;i++)
    {
      o=RPGObjectIO.read(in);
      addObject(o);
    }
  }
}
