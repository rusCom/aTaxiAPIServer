package API;


/**
 * Cache' Java Class Generated for class API.Dispatcher on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher</A>
**/

public class Dispatcher extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 2180;
    private static String CACHE_CLASS_NAME = "API.Dispatcher";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>API.Dispatcher.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public Dispatcher (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public Dispatcher (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "API.Dispatcher" in Cache
       database and corresponding object of class
       <code>API.Dispatcher</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public Dispatcher (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class API.Dispatcher as it is in
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
        checkAllMethods(db, CACHE_CLASS_NAME, Dispatcher.class);
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method ClientCardGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inCard represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#ClientCardGet"> Method ClientCardGet</A>
    */
    public static java.lang.String ClientCardGet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inCard) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inCard);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ClientCardGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ClientGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inCard represented as java.lang.String
     @param inPhone represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#ClientGet"> Method ClientGet</A>
    */
    public static java.lang.String ClientGet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inCard, java.lang.String inPhone) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inCard);
        args[2] = new com.intersys.cache.Dataholder(inPhone);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ClientGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ClientPhoneGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inPhone represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#ClientPhoneGet"> Method ClientPhoneGet</A>
    */
    public static java.lang.String ClientPhoneGet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inPhone) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ClientPhoneGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataCurOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     default argument inLastID set to "0"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #DataCurOrders(com.intersys.objects.Database,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataCurOrders"> Method DataCurOrders</A>
    */
    public static java.lang.String DataCurOrders (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataCurOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataCurOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLastID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataCurOrders"> Method DataCurOrders</A>
    */
    public static java.lang.String DataCurOrders (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLastID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLastID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataCurOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataDoneOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     default argument inLastID set to "0"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #DataDoneOrders(com.intersys.objects.Database,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataDoneOrders"> Method DataDoneOrders</A>
    */
    public static java.lang.String DataDoneOrders (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataDoneOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataDoneOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLastID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataDoneOrders"> Method DataDoneOrders</A>
    */
    public static java.lang.String DataDoneOrders (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLastID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLastID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataDoneOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataDrivers in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     default argument inLastID set to "0"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #DataDrivers(com.intersys.objects.Database,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataDrivers"> Method DataDrivers</A>
    */
    public static java.lang.String DataDrivers (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataDrivers",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataDrivers in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLastID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataDrivers"> Method DataDrivers</A>
    */
    public static java.lang.String DataDrivers (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLastID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLastID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataDrivers",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataHisOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataHisOrders"> Method DataHisOrders</A>
    */
    public static java.lang.String DataHisOrders (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataHisOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataPriorOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     default argument inLastID set to "0"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #DataPriorOrders(com.intersys.objects.Database,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataPriorOrders"> Method DataPriorOrders</A>
    */
    public static java.lang.String DataPriorOrders (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataPriorOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DataPriorOrders in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLastID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DataPriorOrders"> Method DataPriorOrders</A>
    */
    public static java.lang.String DataPriorOrders (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLastID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLastID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DataPriorOrders",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DriversGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inCityUID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#DriversGet"> Method DriversGet</A>
    */
    public static java.lang.String DriversGet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inCityUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inCityUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DriversGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrderGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inOrderID represented as java.lang.String
     @param inPhone represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#OrderGet"> Method OrderGet</A>
    */
    public static java.lang.String OrderGet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inOrderID, java.lang.String inPhone) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inOrderID);
        args[2] = new com.intersys.cache.Dataholder(inPhone);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrderGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrderReestrGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inOrderID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#OrderReestrGet"> Method OrderReestrGet</A>
    */
    public static java.lang.String OrderReestrGet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inOrderID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inOrderID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrderReestrGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inCityUID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#OrdersGet"> Method OrdersGet</A>
    */
    public static java.lang.String OrdersGet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inCityUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inCityUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method PreferensesGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#PreferensesGet"> Method PreferensesGet</A>
    */
    public static java.lang.String PreferensesGet (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"PreferensesGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileLogin in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inPhone represented as java.lang.String
     @param inPassword represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-V7V133H897X:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.Dispatcher#ProfileLogin"> Method ProfileLogin</A>
    */
    public static java.lang.String ProfileLogin (com.intersys.objects.Database db, java.lang.String inPhone, java.lang.String inPassword) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inPhone);
        args[1] = new com.intersys.cache.Dataholder(inPassword);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileLogin",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
}
