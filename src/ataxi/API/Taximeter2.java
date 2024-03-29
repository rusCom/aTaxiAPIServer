package ataxi.API;


/**
 * Cache' Java Class Generated for class ataxi.API.Taximeter2 on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2</A>
**/

public class Taximeter2 extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 3782;
    private static String CACHE_CLASS_NAME = "ataxi.API.Taximeter2";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>ataxi.API.Taximeter2.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public Taximeter2 (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public Taximeter2 (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "ataxi.API.Taximeter2" in Cache
       database and corresponding object of class
       <code>ataxi.API.Taximeter2</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public Taximeter2 (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class ataxi.API.Taximeter2 as it is in
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
        checkAllMethods(db, CACHE_CLASS_NAME, Taximeter2.class);
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method Data in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#Data"> Method Data</A>
    */
    public static java.lang.String Data (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Data",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataProfile in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDriverID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#DataProfile"> Method DataProfile</A>
    */
    public static java.lang.String DataProfile (com.intersys.objects.Database db, java.lang.Integer inDriverID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inDriverID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataProfile",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetOrderJSON in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inOrderID represented as java.lang.Integer
     @param inDriverID represented as java.lang.Integer
     @param inDistance represented as java.lang.Double
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#GetOrderJSON"> Method GetOrderJSON</A>
    */
    public static java.lang.String GetOrderJSON (com.intersys.objects.Database db, java.lang.Integer inOrderID, java.lang.Integer inDriverID, java.lang.Double inDistance) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inOrderID);
        args[1] = new com.intersys.cache.Dataholder(inDriverID);
        args[2] = new com.intersys.cache.Dataholder(inDistance);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetOrderJSON",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDriverID represented as java.lang.Integer
     default argument inType set to 0
     default argument isView set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #GetOrders(com.intersys.objects.Database,java.lang.Integer,java.lang.Integer,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#GetOrders"> Method GetOrders</A>
    */
    public static java.lang.String GetOrders (com.intersys.objects.Database db, java.lang.Integer inDriverID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inDriverID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDriverID represented as java.lang.Integer
     @param inType represented as java.lang.Integer
     default argument isView set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #GetOrders(com.intersys.objects.Database,java.lang.Integer,java.lang.Integer,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#GetOrders"> Method GetOrders</A>
    */
    public static java.lang.String GetOrders (com.intersys.objects.Database db, java.lang.Integer inDriverID, java.lang.Integer inType) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inDriverID);
        args[1] = new com.intersys.cache.Dataholder(inType);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDriverID represented as java.lang.Integer
     @param inType represented as java.lang.Integer
     @param isView represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#GetOrders"> Method GetOrders</A>
    */
    public static java.lang.String GetOrders (com.intersys.objects.Database db, java.lang.Integer inDriverID, java.lang.Integer inType, java.lang.Integer isView) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inDriverID);
        args[1] = new com.intersys.cache.Dataholder(inType);
        args[2] = new com.intersys.cache.Dataholder(isView);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Initialize in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#Initialize"> Method Initialize</A>
    */
    public static void Initialize (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Initialize",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method PreferencesDriversTopics in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDriverID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#PreferencesDriversTopics"> Method PreferencesDriversTopics</A>
    */
    public static java.lang.String PreferencesDriversTopics (com.intersys.objects.Database db, java.lang.Integer inDriverID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inDriverID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PreferencesDriversTopics",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileAuth in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inVersion represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#ProfileAuth"> Method ProfileAuth</A>
    */
    public static java.lang.String ProfileAuth (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inVersion) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inVersion);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileAuth",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileBusy in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#ProfileBusy"> Method ProfileBusy</A>
    */
    public static java.lang.String ProfileBusy (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileBusy",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileFree in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#ProfileFree"> Method ProfileFree</A>
    */
    public static java.lang.String ProfileFree (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileFree",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileLogin in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inPhone represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#ProfileLogin"> Method ProfileLogin</A>
    */
    public static java.lang.String ProfileLogin (com.intersys.objects.Database db, java.lang.String inPhone) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inPhone);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileLogin",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfilePreferences in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#ProfilePreferences"> Method ProfilePreferences</A>
    */
    public static java.lang.String ProfilePreferences (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfilePreferences",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfilePush in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inFCMToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#ProfilePush"> Method ProfilePush</A>
    */
    public static java.lang.String ProfilePush (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inFCMToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inFCMToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfilePush",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileRegistration in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inPhone represented as java.lang.String
     @param inCode represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#ProfileRegistration"> Method ProfileRegistration</A>
    */
    public static java.lang.String ProfileRegistration (com.intersys.objects.Database db, java.lang.String inPhone, java.lang.String inCode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inPhone);
        args[1] = new com.intersys.cache.Dataholder(inCode);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileRegistration",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetData in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inDeviceID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Taximeter2#SetData"> Method SetData</A>
    */
    public static java.lang.String SetData (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inDeviceID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inDeviceID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetData",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
}
