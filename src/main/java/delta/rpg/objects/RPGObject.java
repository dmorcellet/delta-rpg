package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.base.Amount;

/**
 * Base class for objects.
 * @author DAM
 */
public abstract class RPGObject
{
  protected static final String EMPTY_OBJECT_NAME="";

  private String _name;
  private int _volume;
  private int _weight;
  private Amount _value;
  private boolean _magical;
  private int _locations;
  //protected int _id;  (model)
  //Matière : Organique, bois, métal

  /**
   * Constructor.
   */
  public RPGObject()
  {
    _name=EMPTY_OBJECT_NAME;
    _volume=0;
    _weight=0;
    _value=new Amount();
    _magical=false;
    _locations=0;
  }

  /**
   * Get the object's family.
   * @return the object's family.
   */
  public abstract ObjectFamily getObjectType();

  /**
   * Get the name of this object.
   * @return a displayable name.
   */
  public String getName()
  {
    return _name;
  }

  /**
   * Get the volume of this object.
   * @return a volume.
   */
  public int getVolume()
  {
    return _volume;
  }

  /**
   * Get the weight of this object.
   * @return a weight.
   */
  public int getWeight()
  {
    return _weight;
  }

  /**
   * Get the total volume of this object.
   * @return a volume.
   */
  public int getTotalVolume()
  {
    return _volume;
  }

  /**
   * Get the total weight of this object.
   * @return a weight.
   */
  public int getTotalWeight()
  {
    return _weight;
  }

  /**
   * Get the value of this object.
   * @return a value.
   */
  public Amount getValue()
  {
    return _value;
  }

  /**
   * Indicates if this object is magical or not.
   * @return <code>true</code> if it is, <code>false</code> otherwise.
   */
  public boolean isMagical()
  {
    return _magical;
  }

  /**
   * Set the 'magical' flag.
   * @param isMagical Value to set.
   */
  protected void setMagical(boolean isMagical)
  {
    _magical=isMagical;
  }

  /**
   * Get the possible locations.
   * @return the possible locations.
   */
  public int getLocations()
  {
    return _locations;
  }

  /**
   * Write the contents of this object to the given data stream.
   * @param out Output data stream.
   * @throws IOException If an I/O error occurs.
   */
  protected void write(DataOutputStream out)
      throws IOException
  {
    out.writeUTF(_name);
    out.writeInt(_weight);
    out.writeInt(_volume);
    out.writeBoolean(_magical);
    out.writeInt(_locations);
    _value.write(out);
  }

  /**
   * Read the contents of this object from the given data stream.
   * @param in Input data stream.
   * @throws IOException If an I/O error occurs.
   */
  protected void read(DataInputStream in)
      throws IOException
  {
    _name=in.readUTF();
    _weight=in.readInt();
    _volume=in.readInt();
    _magical=in.readBoolean();
    _locations=in.readInt();
    _value.read(in);
  }

  @Override
  public String toString()
  {
    return _name;
  }

  /*
    #ifdef ENCHANTEMENTS
      //<group Gestion des enchantements>
    public:
      const Liste* LireListeEnchantements() const;
      EntierNaturel32Bits LireNombreDEnchantements() const;
      void AjouterEnchantement(const JREnchantement* enchantement);
      void RetirerEnchantement(const JREnchantement* enchantement);
    private:
      Liste* _enchantements;
      //</group>
    #endif
   */
}
