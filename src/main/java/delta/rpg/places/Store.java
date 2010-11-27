package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import delta.rpg.objects.RPGObject;

public class Store extends Place
{
  private ArrayList<RPGObject> _objects;

  public Store()
  {
    super();
    _objects=new ArrayList<RPGObject>();
  }

  @Override
  public int getPlaceType()
  {
    return PlaceType.STORE;
  }

  public void addObject(RPGObject object)
  {
    _objects.add(object);
  }

  /*
   Booleen
   JRMagasin::Achat(JRPersonnage* p, JRObjet* objet)
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRMagasin","Achat");
   #endif

    Booleen codeRetour;

    // Calcul du prix d'achat
    JRMontant prixDAchat=objet->LireValeur();

    // Le personnage peut-il payer ??
    if (objet->LireValeur()<=p->LireBourse())
      {
        p->Payer(prixDAchat);
        codeRetour=VRAI;
      }
    else
      {
        codeRetour=FAUX;
      }

    return codeRetour;
   }

   Booleen
   JRMagasin::Vente(JRPersonnage* p, JRObjet* objet)
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRMagasin","Achat");
   #endif

    Booleen codeRetour=VRAI;

    // Calcul du prix de vente
    JRMontant prixDeVente=objet->LireValeur();
    p->Recevoir(prixDeVente);

    return codeRetour;
   }

   void
   JRMagasin::Ecrire(EcrivainDonnees& ed) const
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRMagasin","Ecrire");
   #endif

    JRLieu::Ecrire(ed);
    ed << _objets.LireNombreDElements();

    for(IterateurListe il(_objets);il==FAUX;il.Suivant())
      {
        JRObjet* o=(JRObjet*)(il.ObjetCourant());
        ed << (*o);
      }
   }

   void
   JRMagasin::Lire(LecteurDonnees& ld)
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRMagasin","Lire");
   #endif

    JRLieu::Lire(ld);
    EntierNaturel32Bits nbObjets; ld >> nbObjets;

    for(EntierNaturel32Bits i=0;i<nbObjets;i++)
      {
        JRObjet* objet=JRObjet::Fabriquer(ld);
        AjouterObjet(objet);
      }
   }

   void
   JRMagasin::ImprimerContenu(EcrivainTexte& et) const
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRMagasin","ImprimerContenu");
   #endif

    JRLieu::ImprimerContenu(et);
    if (_objets.LireNombreDElements()>0)
      {
        et << "Liste des objets :" << EcrivainTexte::FinDeLigne;
        for(IterateurListe il(_objets);il==FAUX;il.Suivant())
          {
            JRObjet* o=(JRObjet*)(il.ObjetCourant());
            et.IncrementerDecalage(3);
            o->ImprimerContenu(et);
            et.DecrementerDecalage(3);
          }
      }
   }
   */
  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
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
  }

  @Override
  public String toString()
  {
    return "Store '"+getName()+"'";
  }
}
