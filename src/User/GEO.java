package User;


/**
 * Cache' Java Class Generated for class User.GEO on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO</A>
**/

public class GEO extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 3792;
    private static String CACHE_CLASS_NAME = "User.GEO";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>User.GEO.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public GEO (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public GEO (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "User.GEO" in Cache
       database and corresponding object of class
       <code>User.GEO</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public GEO (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class User.GEO as it is in
      Cache Database. Note, that this is a static method, so no
      object specific information can be returned. Use
      <code>getCacheClass().getName()</code> to get the class name
      for specific object.
       @return Cache class name as a <code>String</code>
      @see #getCacheClass()
      @see com.intersys.objects.reflect.CacheClass#getName()
     */
    public static String getCacheClassName( ) {
        return CACHE_CLASS_NAME;
    }

   /**
           Allows access metadata information about type of this object
           in Cache database. Also can be used for dynamic binding (accessing
           properties and calling methods without particular class known).

           @return <code>CacheClass</code> object for this object type.
   */
    public com.intersys.objects.reflect.CacheClass getCacheClass( ) throws com.intersys.objects.CacheException {
        return mInternal.getCacheClass();
    }

    public static void checkAllFieldsValid(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
    }

    /**
       Verifies that all fields from Cache class are exposed with
       accessor methods in Java class and that values for indexes in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p>But if there is any inconsistency in zObjVal indexes this is fatal and class can not work correctly and must be regenerated

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see com.intersys.objects.InvalidPropertyException

     */
    public static void checkAllMethods(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
        checkAllMethods(db, CACHE_CLASS_NAME, GEO.class);
    }
    /**
     <p>Runs method %ClassName in Cache.</p>
     <p>Description: Returns the object's class name. The <var>fullname</var> determines how the
class name is represented. If it is 1 then it returns the full class name
including any package qualifier. If it is 0 (the default) then it returns the
name of the class without the package, this is mainly for backward compatibility
with the pre-package behaviour of %ClassName.</p>
     @param db represented as com.intersys.objects.Database
     @param fullname represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#%ClassName"> Method %ClassName</A>
    */
    public static java.lang.String sys_ClassName (com.intersys.objects.Database db, java.lang.Boolean fullname) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(fullname);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%ClassName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method %IsA in Cache.</p>
     <p>Description: Returns true (1) if instances of this class are also instances of the isclass parameter.
That is 'isclass' is a primary superclass of this object.</p>
     @param db represented as com.intersys.objects.Database
     @param isclass represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method Dispathcer in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inCityUID represented as java.lang.String
     @param inLastID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#Dispathcer"> Method Dispathcer</A>
    */
    public static java.lang.String Dispathcer (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inCityUID, java.lang.String inLastID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inCityUID);
        args[2] = new com.intersys.cache.Dataholder(inLastID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Dispathcer",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceCalcGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#DistanceCalcGet"> Method DistanceCalcGet</A>
    */
    public static java.lang.String DistanceCalcGet (com.intersys.objects.Database db, java.lang.String inKey) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceCalcGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#DistanceGet"> Method DistanceGet</A>
    */
    public static java.lang.String DistanceGet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[2] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[4] = new com.intersys.cache.Dataholder(inEndLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     @param inDistance represented as java.lang.String
     @param inDuration represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#DistanceSet"> Method DistanceSet</A>
    */
    public static java.lang.String DistanceSet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude, java.lang.String inDistance, java.lang.String inDuration) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[7];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[2] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[4] = new com.intersys.cache.Dataholder(inEndLongitude);
        args[5] = new com.intersys.cache.Dataholder(inDistance);
        args[6] = new com.intersys.cache.Dataholder(inDuration);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method EditAirports in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inUID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#EditAirports"> Method EditAirports</A>
    */
    public static java.lang.String EditAirports (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"EditAirports",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GEOAutocomplete in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inCity represented as java.lang.String
     @param inSearch represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GEOAutocomplete"> Method GEOAutocomplete</A>
    */
    public static java.lang.String GEOAutocomplete (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inCity, java.lang.String inSearch) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inCity);
        args[2] = new com.intersys.cache.Dataholder(inSearch);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GEOAutocomplete",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GEOHouses in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inStreet represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GEOHouses"> Method GEOHouses</A>
    */
    public static java.lang.String GEOHouses (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inStreet) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inStreet);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GEOHouses",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GeocodeCache in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GeocodeCache"> Method GeocodeCache</A>
    */
    public static java.lang.String GeocodeCache (com.intersys.objects.Database db, java.lang.String inKey) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeocodeCache",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GeocodeGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GeocodeGet"> Method GeocodeGet</A>
    */
    public static java.lang.String GeocodeGet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeocodeGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GeocodeSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inUID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GeocodeSet"> Method GeocodeSet</A>
    */
    public static java.lang.String GeocodeSet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeocodeSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetAndroidAppHouseSearch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSearchString represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetAndroidAppHouseSearch"> Method GetAndroidAppHouseSearch</A>
    */
    public static java.lang.String GetAndroidAppHouseSearch (com.intersys.objects.Database db, java.lang.String inSearchString, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inSearchString);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetAndroidAppHouseSearch",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetAndroidAppSearch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSearchString represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetAndroidAppSearch"> Method GetAndroidAppSearch</A>
    */
    public static java.lang.String GetAndroidAppSearch (com.intersys.objects.Database db, java.lang.String inSearchString, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inSearchString);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetAndroidAppSearch",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetDistance in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param bLatitude represented as java.lang.String
     @param bLongitude represented as java.lang.String
     @param eLatitude represented as java.lang.String
     @param eLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetDistance"> Method GetDistance</A>
    */
    public static java.lang.String GetDistance (com.intersys.objects.Database db, java.lang.String bLatitude, java.lang.String bLongitude, java.lang.String eLatitude, java.lang.String eLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(bLatitude);
        args[1] = new com.intersys.cache.Dataholder(bLongitude);
        args[2] = new com.intersys.cache.Dataholder(eLatitude);
        args[3] = new com.intersys.cache.Dataholder(eLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetDistance",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetDistanceCache in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inOrigins represented as java.lang.String
     @param inDistantions represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetDistanceCache"> Method GetDistanceCache</A>
    */
    public static java.lang.String GetDistanceCache (com.intersys.objects.Database db, java.lang.String inOrigins, java.lang.String inDistantions) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inOrigins);
        args[1] = new com.intersys.cache.Dataholder(inDistantions);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetDistanceCache",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetForDistanceMatrix in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetForDistanceMatrix"> Method GetForDistanceMatrix</A>
    */
    public static java.lang.String GetForDistanceMatrix (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetForDistanceMatrix",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetForYandexGeoCoder in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetForYandexGeoCoder"> Method GetForYandexGeoCoder</A>
    */
    public static java.lang.String GetForYandexGeoCoder (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetForYandexGeoCoder",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetForYandexSearch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetForYandexSearch"> Method GetForYandexSearch</A>
    */
    public static java.lang.String GetForYandexSearch (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetForYandexSearch",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetForYandexSearchOper in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetForYandexSearchOper"> Method GetForYandexSearchOper</A>
    */
    public static java.lang.String GetForYandexSearchOper (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetForYandexSearchOper",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetLocationPoint in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetLocationPoint"> Method GetLocationPoint</A>
    */
    public static java.lang.String GetLocationPoint (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetLocationPoint",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetStreetForFind in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetStreetForFind"> Method GetStreetForFind</A>
    */
    public static void GetStreetForFind (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetStreetForFind",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method LoadStreetsFromFile in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#LoadStreetsFromFile"> Method LoadStreetsFromFile</A>
    */
    public static void LoadStreetsFromFile (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"LoadStreetsFromFile",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method ObjectsSetGoogle in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inPlaceID represented as java.lang.String
     @param inName represented as java.lang.String
     @param inDescription represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inPlaceType represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#ObjectsSetGoogle"> Method ObjectsSetGoogle</A>
    */
    public static java.lang.String ObjectsSetGoogle (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inPlaceID, java.lang.String inName, java.lang.String inDescription, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inPlaceType) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[7];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inPlaceID);
        args[2] = new com.intersys.cache.Dataholder(inName);
        args[3] = new com.intersys.cache.Dataholder(inDescription);
        args[4] = new com.intersys.cache.Dataholder(inLatitude);
        args[5] = new com.intersys.cache.Dataholder(inLongitude);
        args[6] = new com.intersys.cache.Dataholder(inPlaceType);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ObjectsSetGoogle",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ParserForSearch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#ParserForSearch"> Method ParserForSearch</A>
    */
    public static void ParserForSearch (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ParserForSearch",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method PlacesAutoComplete in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inLocality represented as java.lang.String
     @param inSearch represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesAutoComplete"> Method PlacesAutoComplete</A>
    */
    public static java.lang.String PlacesAutoComplete (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inLocality, java.lang.String inSearch, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inLocality);
        args[2] = new com.intersys.cache.Dataholder(inSearch);
        args[3] = new com.intersys.cache.Dataholder(inLatitude);
        args[4] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesAutoComplete",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesGoogleGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inText represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesGoogleGet"> Method PlacesGoogleGet</A>
    */
    public static java.lang.String PlacesGoogleGet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inText, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inText);
        args[2] = new com.intersys.cache.Dataholder(inLatitude);
        args[3] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesGoogleGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesGoogleSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inText represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inResult represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesGoogleSet"> Method PlacesGoogleSet</A>
    */
    public static java.lang.String PlacesGoogleSet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inText, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inResult) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inText);
        args[2] = new com.intersys.cache.Dataholder(inLatitude);
        args[3] = new com.intersys.cache.Dataholder(inLongitude);
        args[4] = new com.intersys.cache.Dataholder(inResult);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesGoogleSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesHouses in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inStreet represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesHouses"> Method PlacesHouses</A>
    */
    public static java.lang.String PlacesHouses (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inStreet) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inStreet);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesHouses",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesPopular in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inLocality represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesPopular"> Method PlacesPopular</A>
    */
    public static java.lang.String PlacesPopular (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inLocality) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inLocality);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesPopular",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesYandexGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesYandexGet"> Method PlacesYandexGet</A>
    */
    public static java.lang.String PlacesYandexGet (com.intersys.objects.Database db, java.lang.String inKey) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesYandexGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesYandexOpers in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inClassID represented as java.lang.String
     @param inText represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesYandexOpers"> Method PlacesYandexOpers</A>
    */
    public static java.lang.String PlacesYandexOpers (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inClassID, java.lang.String inText) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inClassID);
        args[2] = new com.intersys.cache.Dataholder(inText);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesYandexOpers",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesYandexSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inData represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#PlacesYandexSet"> Method PlacesYandexSet</A>
    */
    public static java.lang.String PlacesYandexSet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inData) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inData);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesYandexSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetAndroidAppHouseSearch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSearchString represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inResultString represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetAndroidAppHouseSearch"> Method SetAndroidAppHouseSearch</A>
    */
    public static void SetAndroidAppHouseSearch (com.intersys.objects.Database db, java.lang.String inSearchString, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inResultString) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inSearchString);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inResultString);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetAndroidAppHouseSearch",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetAndroidAppSearch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSearchString represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inResultString represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetAndroidAppSearch"> Method SetAndroidAppSearch</A>
    */
    public static void SetAndroidAppSearch (com.intersys.objects.Database db, java.lang.String inSearchString, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inResultString) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inSearchString);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inResultString);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetAndroidAppSearch",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetDistance in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param bLatitude represented as java.lang.String
     @param bLongitude represented as java.lang.String
     @param eLatitude represented as java.lang.String
     @param eLongitude represented as java.lang.String
     @param Distance represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetDistance"> Method SetDistance</A>
    */
    public static void SetDistance (com.intersys.objects.Database db, java.lang.String bLatitude, java.lang.String bLongitude, java.lang.String eLatitude, java.lang.String eLongitude, java.lang.String Distance) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(bLatitude);
        args[1] = new com.intersys.cache.Dataholder(bLongitude);
        args[2] = new com.intersys.cache.Dataholder(eLatitude);
        args[3] = new com.intersys.cache.Dataholder(eLongitude);
        args[4] = new com.intersys.cache.Dataholder(Distance);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetDistance",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetDistanceCache in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inOrigins represented as java.lang.String
     @param inDistantions represented as java.lang.String
     @param inResult represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetDistanceCache"> Method SetDistanceCache</A>
    */
    public static void SetDistanceCache (com.intersys.objects.Database db, java.lang.String inOrigins, java.lang.String inDistantions, java.lang.String inResult) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inOrigins);
        args[1] = new com.intersys.cache.Dataholder(inDistantions);
        args[2] = new com.intersys.cache.Dataholder(inResult);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetDistanceCache",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetForYandexSearchOper in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inClassID represented as java.lang.String
     @param inText represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetForYandexSearchOper"> Method SetForYandexSearchOper</A>
    */
    public static void SetForYandexSearchOper (com.intersys.objects.Database db, java.lang.String inClassID, java.lang.String inText) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inClassID);
        args[1] = new com.intersys.cache.Dataholder(inText);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetForYandexSearchOper",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetFromUandexGeoCoder in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inText represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetFromUandexGeoCoder"> Method SetFromUandexGeoCoder</A>
    */
    public static java.lang.String SetFromUandexGeoCoder (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inText) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        args[2] = new com.intersys.cache.Dataholder(inText);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetFromUandexGeoCoder",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetLocationPoint in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inClassID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetLocationPoint"> Method SetLocationPoint</A>
    */
    public static void SetLocationPoint (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inClassID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        args[2] = new com.intersys.cache.Dataholder(inClassID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetLocationPoint",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetObjectsFromGoogle in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inPlaceID represented as java.lang.String
     @param inName represented as java.lang.String
     @param inDescription represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inPlaceType represented as java.lang.String
     @param inPlaceTypes represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetObjectsFromGoogle"> Method SetObjectsFromGoogle</A>
    */
    public static java.lang.String SetObjectsFromGoogle (com.intersys.objects.Database db, java.lang.String inPlaceID, java.lang.String inName, java.lang.String inDescription, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inPlaceType, java.lang.String inPlaceTypes) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[7];
        args[0] = new com.intersys.cache.Dataholder(inPlaceID);
        args[1] = new com.intersys.cache.Dataholder(inName);
        args[2] = new com.intersys.cache.Dataholder(inDescription);
        args[3] = new com.intersys.cache.Dataholder(inLatitude);
        args[4] = new com.intersys.cache.Dataholder(inLongitude);
        args[5] = new com.intersys.cache.Dataholder(inPlaceType);
        args[6] = new com.intersys.cache.Dataholder(inPlaceTypes);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetObjectsFromGoogle",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetYandexObject in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inData represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetYandexObject"> Method SetYandexObject</A>
    */
    public static java.lang.String SetYandexObject (com.intersys.objects.Database db, java.lang.String inData) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inData);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetYandexObject",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method TimerTask in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#TimerTask"> Method TimerTask</A>
    */
    public static void TimerTask (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"TimerTask",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
}
