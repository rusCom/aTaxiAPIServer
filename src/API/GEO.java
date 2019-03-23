package API;


/**
 * Cache' Java Class Generated for class API.GEO on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO</A>
**/

public class GEO extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 1155;
    private static String CACHE_CLASS_NAME = "API.GEO";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>API.GEO.open</code> instead!</br></p>
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
       Creates a new instance of object "API.GEO" in Cache
       database and corresponding object of class
       <code>API.GEO</code>.

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
       Returns class name of the class API.GEO as it is in
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO#DistanceGet"> Method DistanceGet</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO#DistanceSet"> Method DistanceSet</A>
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
     <p>Runs method PlacesCityGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inDispatching represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO#PlacesCityGet"> Method PlacesCityGet</A>
    */
    public static java.lang.String PlacesCityGet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inDispatching, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inDispatching);
        args[2] = new com.intersys.cache.Dataholder(inLatitude);
        args[3] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesCityGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PlacesParkingGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inCity represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO#PlacesParkingGet"> Method PlacesParkingGet</A>
    */
    public static java.lang.String PlacesParkingGet (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inCity, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inCity);
        args[2] = new com.intersys.cache.Dataholder(inLatitude);
        args[3] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PlacesParkingGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
}
