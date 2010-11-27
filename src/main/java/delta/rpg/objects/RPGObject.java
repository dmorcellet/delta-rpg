package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.base.Amount;

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

  public RPGObject()
  {
    _name=EMPTY_OBJECT_NAME;
    _volume=0;
    _weight=0;
    _value=new Amount();
    _magical=false;
    _locations=0;
  }

  public abstract ObjectFamily getObjectType();

  public String getName()
  {
    return _name;
  }

  public int getVolume()
  {
    return _volume;
  }

  public int getWeight()
  {
    return _weight;
  }

  public int getTotalVolume()
  {
    return _volume;
  }

  public int getTotalWeight()
  {
    return _weight;
  }

  public Amount getValue()
  {
    return _value;
  }

  public boolean isMagical()
  {
    return _magical;
  }

  protected void setMagical(boolean isMagical)
  {
    _magical=isMagical;
  }

  public int getLocations()
  {
    return _locations;
  }

  /**
   * Write the contents of this object to the specified binary data stream.
   * @param out Output stream.
   * @throws IOException
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
   * Read the contents of this object from the specified binary data stream.
   * @param in Input stream.
   * @throws IOException
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
