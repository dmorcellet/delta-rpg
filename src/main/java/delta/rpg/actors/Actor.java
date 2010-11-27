package delta.rpg.actors;

/**
 * Base class for all RPG actors.
 * @author DAM
 */
public abstract class Actor
{
  private String _name;

  /**
   * Constructor.
   *
   */
  public Actor()
  {
    _name="";
  }

  /**
   * Get actor's name.
   * @return a name;
   */
  public String getName()
  {
    return _name;
  }
  /*
   #include "JRTypes.hxx"
   #include "JREtatActeur.hxx"
   #include "JRAlignement.hxx"
   #include "JREquipement.hxx"

    //<group Alignement>
   public:
   protected:
    JRAlignement _alignement;
    //</group>

    //<group Points de vie>
   protected:
    JRPoints _pointsDeVie,_pointsDeVieBase;
    //</group>

    //<group Bourse>
   public:
    const JRMontant& LireBourse() const { return _argent; };
    void Payer(const JRMontant& montant);
    void Recevoir(const JRMontant& montant);
   protected:
    JRMontant _argent;
    //</group>

    //<group Niveau>
   public:
   protected:
    Octet _niveau;
    //</group>

    //<group Degrés de protection>
   protected:
    JRDegreDeProtection _protections[JRConstantes::NombreDeTypesDAttaque];
    JRDegreDeProtection _protectionsBase[JRConstantes::NombreDeTypesDAttaque];
    //</group>

    //<group Etat de l'acteur>
   public:
    Booleen EstEmpoisonne() const { return ((EntierNaturel32Bits(_etat)&JREtatActeur::EMPOISONNE)?VRAI:FAUX); };
    Booleen EstEndormi() const { return ((EntierNaturel32Bits(_etat)&JREtatActeur::ENDORMI)?VRAI:FAUX); };
    Booleen EstParalyse() const { return ((EntierNaturel32Bits(_etat)&JREtatActeur::PARALYSE)?VRAI:FAUX); };
    Booleen EstEnPleineForme() const { return ((_etat==0)?VRAI:FAUX); };
   protected:
    JREtatActeur _etat;
    //</group>

    //<group Equipement>
   public:
    JREquipement _equipement;
    //</group>

    //<group E/S sur les flux>
   public:
    virtual void EcrireContenu(EcrivainDonnees& ed) const;
    virtual void LireContenu(LecteurDonnees& ld);
    //</group>
   };

   #endif
// Include de la classe
   #include "JRActeur.hxx"

// Traces !!!
   #ifdef TRACES
   #include "TraceDeMethode.hxx"
   #endif

// Includes des classes utilisées
// ...

// Internationalisation
   #include "ServeurDeMessages.hxx"
   typedef enum CONSTANTE_MESSAGE
   {
    MSG_NOM_PAR_DEFAUT
   };

// Includes JR
   #include "JRConstantes.hxx"

   JRActeur::JRActeur()
    : Objet()
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRActeur","Constructeur");
   #endif

    _nom=ServeurDeMessages::LireInstance().LireMessage("libJR","JRActeur",MSG_NOM_PAR_DEFAUT);
    _pointsDeVieBase=8;_pointsDeVie=_pointsDeVieBase;
    _argent=0;
    _niveau=1;

    // Protections
    {
      for(EntierNaturel32Bits i=0;i<JRConstantes::NombreDeTypesDAttaque;i++)
        {
          _protectionsBase[i]=127;
          _protections[i]=_protectionsBase[i];
        }
    }
   }

   JRActeur::~JRActeur()
   {
   #ifdef TRACES
    TraceDeMethode maTrace("JRActeur","Destructeur");
   #endif
   }

   void
   JRActeur::Payer(const JRMontant& montant)
   {
    _argent=_argent-montant;
   }

   void
   JRActeur::Recevoir(const JRMontant& montant)
   {
    _argent=_argent+montant;
   }

   void
   JRActeur::EcrireContenu(EcrivainDonnees& ed) const
   {
    // Nom
    ed << _nom;
    // Alignement
    ed << _alignement;
    // Points de vie
    ed << _pointsDeVieBase << _pointsDeVie;
    // Bourse
    ed << _argent;
    // Niveau
    ed << _niveau;
    // Protections
    {
      for(EntierNaturel32Bits i=0;i<JRConstantes::NombreDeTypesDAttaque;i++)
        {
          ed << _protectionsBase[i] << _protections[i];
        }
    }
    // Etat
    ed << _etat;
    // Equipement
    ed << _equipement;
   }

   void
   JRActeur::LireContenu(LecteurDonnees& ld)
   {
    // Nom
    ld >> _nom;
    // Alignement
    EntierNaturel32Bits alignement=0;
    ld >> alignement; _alignement=JRAlignement((JRAlignement::ALIGNEMENT)alignement);
    // Points de vie
    ld >> _pointsDeVieBase >> _pointsDeVie;
    // Bourse
    ld >> _argent;
    // Niveau
    ld >> _niveau;
    // Protections
    {
      for(EntierNaturel32Bits i=0;i<JRConstantes::NombreDeTypesDAttaque;i++)
        {
          ld >> _protectionsBase[i] >> _protections[i];
        }
    }
    // Etat
    EntierNaturel32Bits etat=0;
    ld >> etat; _etat=JREtatActeur((JREtatActeur::ETAT)etat);
    // Equipement
    ld >> _equipement;
   }
   */
}
