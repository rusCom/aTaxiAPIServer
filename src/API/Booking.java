package API;


/**
 * Cache' Java Class Generated for class API.Booking on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking</A>
**/

public class Booking extends API.JSON implements java.io.Serializable {
    private static final long serialVersionUID = 4760;
    private static String CACHE_CLASS_NAME = "API.Booking";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>API.Booking.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public Booking (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public Booking (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "API.Booking" in Cache
       database and corresponding object of class
       <code>API.Booking</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public Booking (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class API.Booking as it is in
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
        checkAllMethods(db, CACHE_CLASS_NAME, Booking.class);
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method Answer in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param GUID represented as java.lang.String
     default argument inCode set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Answer(com.intersys.objects.Database,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Answer"> Method Answer</A>
    */
    public static void Answer (com.intersys.objects.Database db, java.lang.String GUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(GUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Answer",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method Answer in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param GUID represented as java.lang.String
     @param inCode represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Answer"> Method Answer</A>
    */
    public static void Answer (com.intersys.objects.Database db, java.lang.String GUID, java.lang.String inCode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(GUID);
        args[1] = new com.intersys.cache.Dataholder(inCode);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Answer",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method Auth in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingToken represented as java.lang.String
     @param inClientToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Auth"> Method Auth</A>
    */
    public static java.lang.String Auth (com.intersys.objects.Database db, java.lang.String inDispatchingToken, java.lang.String inClientToken, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingToken);
        args[1] = new com.intersys.cache.Dataholder(inClientToken);
        args[2] = new com.intersys.cache.Dataholder(inLatitude);
        args[3] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Auth",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Data in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inClientID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Data"> Method Data</A>
    */
    public static java.lang.String Data (com.intersys.objects.Database db, java.lang.String inClientID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inClientID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Data",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GUID in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#GUID"> Method GUID</A>
    */
    public static java.lang.String GUID (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GUID",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GoogleKey in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#GoogleKey"> Method GoogleKey</A>
    */
    public static java.lang.String GoogleKey (com.intersys.objects.Database db, java.lang.String inDispatchingID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GoogleKey",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Initialize in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Initialize"> Method Initialize</A>
    */
    public static void Initialize (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Initialize",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method Order in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument inOrderID set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Order(com.intersys.objects.Database,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Order"> Method Order</A>
    */
    public static java.lang.String Order (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Order",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Order in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inOrderID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Order"> Method Order</A>
    */
    public static java.lang.String Order (com.intersys.objects.Database db, java.lang.Integer inOrderID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inOrderID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Order",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrderRoute in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inRouteID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#OrderRoute"> Method OrderRoute</A>
    */
    public static java.lang.String OrderRoute (com.intersys.objects.Database db, java.lang.Integer inRouteID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inRouteID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrderRoute",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Orders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inClientID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Orders"> Method Orders</A>
    */
    public static java.lang.String Orders (com.intersys.objects.Database db, java.lang.Integer inClientID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inClientID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Orders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersCalc in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inData represented as java.lang.String
     @param inRoute represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#OrdersCalc"> Method OrdersCalc</A>
    */
    public static java.lang.String OrdersCalc (com.intersys.objects.Database db, java.lang.String inData, java.lang.String inRoute) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inData);
        args[1] = new com.intersys.cache.Dataholder(inRoute);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersCalc",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersPickUp in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#OrdersPickUp"> Method OrdersPickUp</A>
    */
    public static java.lang.String OrdersPickUp (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersPickUp",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Preferences in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inCityID represented as java.lang.String
     default argument inClientID set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Preferences(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Preferences"> Method Preferences</A>
    */
    public static java.lang.String Preferences (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inCityID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inCityID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Preferences",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Preferences in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inCityID represented as java.lang.String
     @param inClientID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Preferences"> Method Preferences</A>
    */
    public static java.lang.String Preferences (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inCityID, java.lang.String inClientID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inCityID);
        args[2] = new com.intersys.cache.Dataholder(inClientID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Preferences",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Profile in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inCientID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#Profile"> Method Profile</A>
    */
    public static void Profile (com.intersys.objects.Database db, java.lang.Integer inCientID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inCientID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Profile",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method ProfileAuth in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inClientID represented as java.lang.String
     @param inCityID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#ProfileAuth"> Method ProfileAuth</A>
    */
    public static java.lang.String ProfileAuth (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inClientID, java.lang.String inCityID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inClientID);
        args[2] = new com.intersys.cache.Dataholder(inCityID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileAuth",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileLogin in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inPhone represented as java.lang.String
     default argument inType set to "sms"
     default argument isTest set to "0"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #ProfileLogin(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#ProfileLogin"> Method ProfileLogin</A>
    */
    public static java.lang.String ProfileLogin (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inPhone) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileLogin",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileLogin in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inPhone represented as java.lang.String
     @param inType represented as java.lang.String
     default argument isTest set to "0"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #ProfileLogin(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#ProfileLogin"> Method ProfileLogin</A>
    */
    public static java.lang.String ProfileLogin (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inPhone, java.lang.String inType) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        args[2] = new com.intersys.cache.Dataholder(inType);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileLogin",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileLogin in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inPhone represented as java.lang.String
     @param inType represented as java.lang.String
     @param isTest represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#ProfileLogin"> Method ProfileLogin</A>
    */
    public static java.lang.String ProfileLogin (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inPhone, java.lang.String inType, java.lang.String isTest) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        args[2] = new com.intersys.cache.Dataholder(inType);
        args[3] = new com.intersys.cache.Dataholder(isTest);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileLogin",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileRegistration in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.String
     @param inPhone represented as java.lang.String
     @param inCode represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#ProfileRegistration"> Method ProfileRegistration</A>
    */
    public static java.lang.String ProfileRegistration (com.intersys.objects.Database db, java.lang.String inDispatchingID, java.lang.String inPhone, java.lang.String inCode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        args[2] = new com.intersys.cache.Dataholder(inCode);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileRegistration",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetData in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inClientID represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#SetData"> Method SetData</A>
    */
    public static java.lang.String SetData (com.intersys.objects.Database db, java.lang.String inClientID, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inClientID);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetData",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method addField in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#addField"> Method addField</A>
    */
    public static void addField (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName, java.lang.String inFieldValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        args[2] = new com.intersys.cache.Dataholder(inFieldValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addField",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addToArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#addToArray"> Method addToArray</A>
    */
    public static void addToArray (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName, java.lang.String inFieldValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        args[2] = new com.intersys.cache.Dataholder(inFieldValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addToArray",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addToNamedArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inArrayName represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Booking#addToNamedArray"> Method addToNamedArray</A>
    */
    public static void addToNamedArray (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inArrayName, java.lang.String inFieldName, java.lang.String inFieldValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inArrayName);
        args[2] = new com.intersys.cache.Dataholder(inFieldName);
        args[3] = new com.intersys.cache.Dataholder(inFieldValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addToNamedArray",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
}
