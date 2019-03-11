package delta.rpg.objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import delta.rpg.spells.Spell;
import delta.rpg.spells.SpellsRegistry;

/**
 * Spells book.
 * @author DAM
 */
public class SpellBook extends RPGObject
{
  private ArrayList<Spell> _spells;

  /**
   * Constructor.
   */
  public SpellBook()
  {
    super();
    _spells=new ArrayList<Spell>();
  }

  @Override
  public ObjectFamily getObjectType()
  {
    return ObjectFamily.SPELLBOOK;
  }

  /**
   * Add a spell.
   * @param spell Spell to add.
   */
  public void addSpell(Spell spell)
  {
    _spells.add(spell);
    setMagical(true);
  }

  /**
   * Remove a spell.
   * @param spell
   */
  public void removeSpell(Spell spell)
  {
    _spells.remove(spell);
    if(_spells.size()==0)
    {
      setMagical(false);
    }
  }

  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
    int n=_spells.size();
    out.writeInt(n);
    Spell spell;
    for(int i=0;i<n;i++)
    {
      spell=_spells.get(i);
      out.writeUTF(spell.getCode());
    }
  }

  @Override
  protected void read(DataInputStream in)
      throws IOException
  {
    super.read(in);
    _spells.clear();
    int n=in.readInt();
    Spell spell;
    String code;
    for(int i=0;i<n;i++)
    {
      code=in.readUTF();
      spell=SpellsRegistry.getInstance().getSpellByCode(code);
      addSpell(spell);
    }
  }
  /*
   Booleen
   JRLivreDeSorts::Utiliser(JRPersonnage& p)
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRLivreDeSorts","Utiliser");
   #endif

    // Recopie les sorts qui se trouvent sur le livre de sorts
    // dans le grimoire du personnage spécifié.
    // Si le personnage dispose déjà d'un sort du livre, ce sort n'est pas recopié.
    // Tout sort recopié disparaît du livre de sorts.

    Liste* listeSortsUtilises=POINTEUR_NUL;

    {
      for(IterateurListe il(_listeSorts);il==FAUX;il.Suivant())
        {
          JRSort* s=(JRSort*)(il.ObjetCourant());
          if (p._grimoire.ContientSort(s)==FAUX)
            {
              p._grimoire.AjouterSort(s);
              if (listeSortsUtilises==POINTEUR_NUL)
                {
                  listeSortsUtilises=new Liste();
                  listeSortsUtilises->FixerModePossession(Conteneur::NON_POSSESSIF);
                }
              listeSortsUtilises->Ajouter(s);
            }
        }
    }

    if (listeSortsUtilises!=POINTEUR_NUL)
      {
        for(IterateurListe il(_listeSorts);il==FAUX;il.Suivant())
          {
            JRSort* s=(JRSort*)(il.ObjetCourant());
            SupprimerSort(s);
          }
        delete listeSortsUtilises;
      }

    return VRAI;
   }
   */
}
