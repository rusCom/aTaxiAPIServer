package User;


/**
 * Cache' Java Class Generated for class User.GEO on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO</A>
**/

public class GEO extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 6694;
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method GetAndroidAppHouseSearch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSearchString represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetAndroidAppHouseSearch"> Method GetAndroidAppHouseSearch</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetAndroidAppSearch"> Method GetAndroidAppSearch</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetDistance"> Method GetDistance</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetDistanceCache"> Method GetDistanceCache</A>
    */
    public static java.lang.String GetDistanceCache (com.intersys.objects.Database db, java.lang.String inOrigins, java.lang.String inDistantions) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inOrigins);
        args[1] = new com.intersys.cache.Dataholder(inDistantions);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetDistanceCache",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetLocationPoint in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#GetLocationPoint"> Method GetLocationPoint</A>
    */
    public static java.lang.String GetLocationPoint (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetLocationPoint",args,com.intersys.objects.Database.RET_PRIM);
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetAndroidAppHouseSearch"> Method SetAndroidAppHouseSearch</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetAndroidAppSearch"> Method SetAndroidAppSearch</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetDistance"> Method SetDistance</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetDistanceCache"> Method SetDistanceCache</A>
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
     <p>Runs method SetLocationPoint in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inClassID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetLocationPoint"> Method SetLocationPoint</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=GEO&CLASSNAME=User.GEO#SetObjectsFromGoogle"> Method SetObjectsFromGoogle</A>
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
}
