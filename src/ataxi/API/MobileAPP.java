package ataxi.API;


/**
 * Cache' Java Class Generated for class ataxi.API.MobileAPP on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP</A>
**/

public class MobileAPP extends com.intersys.classes.Persistent {
    private static final long serialVersionUID = 7607;
    private static String CACHE_CLASS_NAME = "ataxi.API.MobileAPP";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>ataxi.API.MobileAPP.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public MobileAPP (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public MobileAPP (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "ataxi.API.MobileAPP" in Cache
       database and corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public MobileAPP (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
    * Calls method
    * {@link com.intersys.objects.Database#createObjects(String, java.util.Collection)}
    * to save a collection of previously created new objects in Cache
    * Database. No object in collection could been saved before. All
    * objects must be instances of <code>ataxi.API.MobileAPP</code> and not of its
    * subclasses. To save changes in objects that already exist in
    * the database use <code>saveObjects</code> method or instance
    * method <code>save</code> on the object itself.
    *
    * @param db <code>Database</code> object used for connection with
    * Cache database.
    *
    * @param objects A collection of newly created objects. None of
    * the objects in the collection may already exist in database.
    *
    * @see #saveObjects(com.intersys.objects.Database, java.util.Collection)
    * @see com.intersys.objects.Database#createObjects(String, java.util.Collection)
    *
    */
    public static void createObjects (com.intersys.objects.Database db, java.util.Collection objects) throws com.intersys.objects.CacheException {
        db.createObjects (CACHE_CLASS_NAME, objects);
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        return open(db, id);
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, id.toString()));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        return open(db, id, concurrency);
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, id.toString(), concurrency));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        return open(db, oid);
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, oid.getData()));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

      @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Oid oid, int concurrency) throws com.intersys.objects.CacheException {
        return open(db, oid, concurrency);
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>ataxi.API.MobileAPP</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

      @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Oid oid, int concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, oid.getData(), concurrency));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
    * Calls method
    * {@link com.intersys.objects.Database#openByQuery(String, String, Object[])}
    * to open all instances of class ataxi.API.MobileAPP
    * that satisfy given simple
    * condition, specified in SQL syntax.
    *
    * @param db <code>Database</code> object used for connection with
    * Cache database.
    *
    * @param condition Simple condition on objects, in SQL syntax. It
    * can refer only to properties of a single object.
    *
    * @param args Parameters to replace "?" in
    * <code>condition</code>. If there are no parameters in condition
    * may be null or empty array.
    *
    * @return Iterator in the form of
    * <code>java.util.Iterator</code>, that iterates over all opened
    * objects in specified order.
    *
    * @see #openByQuery(com.intersys.objects.Database, String)
    * @see com.intersys.objects.Database#openByQuery(String, String, Object[])
    * @see com.intersys.objects.Database#openByQuery(String, String)
    * @see com.intersys.objects.Database#openByQuery(String, Object[])
    * @see com.intersys.objects.Database#openByQuery(String)
    *
    */
    public static java.util.Iterator openByQuery (com.intersys.objects.Database db, String condition, Object[] args) throws com.intersys.objects.CacheException {
        return db.openByQuery (CACHE_CLASS_NAME, condition, args);
    }
    /**
    * Calls method
    * {@link com.intersys.objects.Database#openByQuery(String, String)}
    * to open all instances of class Sample.Person
    * that satisfy given simple
    * condition, specified in SQL syntax.
    *
    * @param db <code>Database</code> object used for connection with
    * Cache database.
    *
    * @param condition Simple condition on objects, in SQL syntax. It
    * can refer only to properties of a single object.
    *
    * @return Iterator in the form of
    * <code>java.util.Iterator</code>, that iterates over all opened
    * objects in specified order.
    *
    * @see #openByQuery(com.intersys.objects.Database, String, Object[])
    * @see com.intersys.objects.Database#openByQuery(String, String)
    * @see com.intersys.objects.Database#openByQuery(String, String, Object[])
    * @see com.intersys.objects.Database#openByQuery(String, Object[])
    * @see com.intersys.objects.Database#openByQuery(String)
    *
    */
    public static java.util.Iterator openByQuery (com.intersys.objects.Database db, String condition) throws com.intersys.objects.CacheException {
        return db.openByQuery (CACHE_CLASS_NAME, condition);
    }
    /**
    * Calls method
    * {@link com.intersys.objects.Database#saveObjects(String,
    java.util.Collection)}
    * to save a collection of previously created new objects in Cache
    * Database. All object in
    * collection must already exist in database. All
    * objects must be instances of <code>ataxi.API.MobileAPP</code> and not of its
    * subclasses. To save
    * changes in newly created objects use <code>createObjects</code>
    * method or instance method <code>save</code> on the object
    * itself.
    *
    * @param db <code>Database</code> object used for connection with
    * Cache database.
    *
    * @param objects A collection of newly created objects. None of
    * the objects in the collection may already exist in database.
    *
    * @see #saveObjects(com.intersys.objects.Database, java.util.Collection)
    * @see com.intersys.objects.Database#createObjects(String, java.util.Collection)
    *
    */
    public static void saveObjects (com.intersys.objects.Database db, java.util.Collection objects) throws com.intersys.objects.CacheException {
        db.saveObjects (CACHE_CLASS_NAME, objects);
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #MobileAPP
     */
    public static void delete (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        ((com.intersys.cache.SysDatabase)db).deleteObject(CACHE_CLASS_NAME, id);
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.
       @param concurrency Concurrency level.  represented as
       <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #MobileAPP
     */
    public static void delete (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        ((com.intersys.cache.SysDatabase)db).deleteObject(CACHE_CLASS_NAME, id, concurrency);
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #MobileAPP
     */
    public static void _deleteId (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        delete(db, id);
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.
       @param concurrency Concurrency level.  represented as
       <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #MobileAPP
     */
    public static void _deleteId (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        delete(db, id, concurrency);
    }
    /**
       Runs method <code> %Exists </code> in Cache to see if an object exists.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_existsId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #MobileAPP
     */
    public static boolean exists (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        return ((com.intersys.cache.SysDatabase)db).existsObject(CACHE_CLASS_NAME, id);
    }
    /**
       Runs method <code> %Exists </code> in Cache to see if an object exists.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_existsId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #MobileAPP
     */
    public static Boolean _existsId (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        return new Boolean(exists(db, id));
    }
    /**
       Returns class name of the class ataxi.API.MobileAPP as it is in
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
       Runs method <code> %Exists </code> in Cache to see if an object exists.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>ataxi.API.MobileAPP</code> or of
      any of its subclasses. Cast to <code>ataxi.API.MobileAPP</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #MobileAPP
     */
    public static boolean exists (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        return exists (db, oid, CACHE_CLASS_NAME);
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
        checkAllMethods(db, CACHE_CLASS_NAME, MobileAPP.class);
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%ClassName"> Method %ClassName</A>
    */
    public static java.lang.String sys_ClassName (com.intersys.objects.Database db, java.lang.Boolean fullname) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(fullname);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%ClassName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method %ComposeOid in Cache.</p>
     <p>Description: %ComposeOid()

		This class method accepts an ID and returns a fully qualified OID, containing the most specific type class of the object identified by the
		<var>id</var> argument. If default storage is used then the %%CLASSNAME value is used to determine the most specific type class, otherwise call
		%OnDetermineClass to determine the most specific type class. If neither case is true then the current class is
		used. If there is a problem determining the most specific type class then null ("") is returned.</p>
     @param db represented as com.intersys.objects.Database
     @param id represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%ComposeOid"> Method %ComposeOid</A>
    */
    public static void sys_ComposeOid (com.intersys.objects.Database db, java.lang.String id) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(id);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%ComposeOid",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method %Delete in Cache.</p>
     <p>Description: Deletes the stored version of the object with OID <var>oid</var> from the database. 
It does not remove any in-memory versions of the object that may be present.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.

<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.

<p>Internally, <METHOD>%Delete</METHOD> initiates a transaction and then invokes the storage 
interface method <METHOD>%DeleteData</METHOD>. If <METHOD>%DeleteData</METHOD> succeeds, the 
transaction is committed, otherwise it is rolled back. </p>
     @param db represented as com.intersys.objects.Database
     default argument oid set to ""
     default argument concurrency set to -1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_Delete(com.intersys.objects.Database,com.intersys.objects.Oid,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%Delete"> Method %Delete</A>
    */
    public static void sys_Delete (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Delete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %Delete in Cache.</p>
     <p>Description: Deletes the stored version of the object with OID <var>oid</var> from the database. 
It does not remove any in-memory versions of the object that may be present.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.

<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.

<p>Internally, <METHOD>%Delete</METHOD> initiates a transaction and then invokes the storage 
interface method <METHOD>%DeleteData</METHOD>. If <METHOD>%DeleteData</METHOD> succeeds, the 
transaction is committed, otherwise it is rolled back. </p>
     @param db represented as com.intersys.objects.Database
     @param oid represented as com.intersys.objects.Oid
     default argument concurrency set to -1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_Delete(com.intersys.objects.Database,com.intersys.objects.Oid,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%Delete"> Method %Delete</A>
    */
    public static void sys_Delete (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(oid);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Delete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %Delete in Cache.</p>
     <p>Description: Deletes the stored version of the object with OID <var>oid</var> from the database. 
It does not remove any in-memory versions of the object that may be present.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.

<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.

<p>Internally, <METHOD>%Delete</METHOD> initiates a transaction and then invokes the storage 
interface method <METHOD>%DeleteData</METHOD>. If <METHOD>%DeleteData</METHOD> succeeds, the 
transaction is committed, otherwise it is rolled back. </p>
     @param db represented as com.intersys.objects.Database
     @param oid represented as com.intersys.objects.Oid
     @param concurrency represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%Delete"> Method %Delete</A>
    */
    public static void sys_Delete (com.intersys.objects.Database db, com.intersys.objects.Oid oid, java.lang.Integer concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(oid);
        args[1] = new com.intersys.cache.Dataholder(concurrency);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Delete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %DeleteExtent in Cache.</p>
     <p>Description: Delete all instances of this class from its extent. On exit <var>instancecount</var> 
contains the original number of instances while <var>deletecount</var> contains 
the number of instances actually deleted.

<p>Internally, <METHOD>%DeleteExtent</METHOD> iterates over the set of instances in the 
collection and invokes the <METHOD>%Delete</METHOD> method.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.

<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.</p>
     @param db represented as com.intersys.objects.Database
     @param concurrency represented as java.lang.Integer
     @param deletecount represented as com.intersys.objects.StringHolder
     @param instancecount represented as com.intersys.objects.StringHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%DeleteExtent"> Method %DeleteExtent</A>
    */
    public static void sys_DeleteExtent (com.intersys.objects.Database db, java.lang.Integer concurrency, com.intersys.objects.StringHolder deletecount, com.intersys.objects.StringHolder instancecount) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[2];
        args[0] = new com.intersys.cache.Dataholder(concurrency);
        args[1] = com.intersys.cache.Dataholder.create (deletecount.value);
        _refs[0] = 2;
        args[2] = com.intersys.cache.Dataholder.create (instancecount.value);
        _refs[1] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"%DeleteExtent",_refs,args,com.intersys.objects.Database.RET_PRIM);
        deletecount.set(res[1].getString());
        instancecount.set(res[2].getString());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method %DeleteId in Cache.</p>
     <p>Description: Deletes the stored version of the object with ID <var>id</var> from the database. 

<p><METHOD>%DeleteId</METHOD> is identical in operation to the <METHOD>%Delete</METHOD> method except 
that it uses and Id value instead of an OID value to find an object.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.</p>
     @param db represented as com.intersys.objects.Database
     @param id represented as java.lang.String
     default argument concurrency set to -1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_DeleteId(com.intersys.objects.Database,java.lang.String,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%DeleteId"> Method %DeleteId</A>
    */
    public static void sys_DeleteId (com.intersys.objects.Database db, java.lang.String id) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(id);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%DeleteId",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %DeleteId in Cache.</p>
     <p>Description: Deletes the stored version of the object with ID <var>id</var> from the database. 

<p><METHOD>%DeleteId</METHOD> is identical in operation to the <METHOD>%Delete</METHOD> method except 
that it uses and Id value instead of an OID value to find an object.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.</p>
     @param db represented as com.intersys.objects.Database
     @param id represented as java.lang.String
     @param concurrency represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%DeleteId"> Method %DeleteId</A>
    */
    public static void sys_DeleteId (com.intersys.objects.Database db, java.lang.String id, java.lang.Integer concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(id);
        args[1] = new com.intersys.cache.Dataholder(concurrency);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%DeleteId",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %Exists in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument oid set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_Exists(com.intersys.objects.Database,com.intersys.objects.Oid)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%Exists"> Method %Exists</A>
    */
    public static java.lang.Boolean sys_Exists (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Exists",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method %Exists in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param oid represented as com.intersys.objects.Oid
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%Exists"> Method %Exists</A>
    */
    public static java.lang.Boolean sys_Exists (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(oid);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Exists",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method %ExistsId in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param id represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%ExistsId"> Method %ExistsId</A>
    */
    public static java.lang.Boolean sys_ExistsId (com.intersys.objects.Database db, java.lang.String id) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(id);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%ExistsId",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method %IsA in Cache.</p>
     <p>Description: Returns true (1) if instances of this class are also instances of the isclass parameter.
That is 'isclass' is a primary superclass of this object.</p>
     @param db represented as com.intersys.objects.Database
     @param isclass represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method %KillExtent in Cache.</p>
     <p>Description: %KillExtent performs a physical kill of the extent. No constraints are enforced. This method should not be
used in place of %DeleteExtent. Only physical storage occupied by this extent will be killed. If this extent
is a subextent of another class then no data is killed. Indexes that originate with this extent will be killed.
%KillExtent will be called on any subextents and on any child extents (the extent of the type class of a
relationship whose cardinality = children is a 'child' extent) of this extent.

This method is not meant for production applications. It is meant to be a development utility to quickly clear
extent physical data.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%KillExtent"> Method %KillExtent</A>
    */
    public static void sys_KillExtent (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%KillExtent",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %SaveIndices in Cache.</p>
     <p>Description: Files the indices for all objects whose ID is in the range defined by <var>pStartId</var> and <var>pEndId</var>.
If <var>pEndId</var> is null then it defaults to <var>pStartId</var>. If <var>pStartId</var> is null then the
range is empty and no filing will occur.

If <var>lockExtent</var> is true then an extent lock will be acquired before the indices
are built. If the lock cannot be acquired then an error is returned. The lock is released
after the index filing is completed.



<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.</p>
     @param db represented as com.intersys.objects.Database
     default argument pStartId set to ""
     default argument pEndId set to ""
     default argument lockExtent set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_SaveIndices(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.Boolean)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%SaveIndices"> Method %SaveIndices</A>
    */
    public static void sys_SaveIndices (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%SaveIndices",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %SaveIndices in Cache.</p>
     <p>Description: Files the indices for all objects whose ID is in the range defined by <var>pStartId</var> and <var>pEndId</var>.
If <var>pEndId</var> is null then it defaults to <var>pStartId</var>. If <var>pStartId</var> is null then the
range is empty and no filing will occur.

If <var>lockExtent</var> is true then an extent lock will be acquired before the indices
are built. If the lock cannot be acquired then an error is returned. The lock is released
after the index filing is completed.



<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.</p>
     @param db represented as com.intersys.objects.Database
     @param pStartId represented as java.lang.String
     default argument pEndId set to ""
     default argument lockExtent set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_SaveIndices(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.Boolean)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%SaveIndices"> Method %SaveIndices</A>
    */
    public static void sys_SaveIndices (com.intersys.objects.Database db, java.lang.String pStartId) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(pStartId);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%SaveIndices",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %SaveIndices in Cache.</p>
     <p>Description: Files the indices for all objects whose ID is in the range defined by <var>pStartId</var> and <var>pEndId</var>.
If <var>pEndId</var> is null then it defaults to <var>pStartId</var>. If <var>pStartId</var> is null then the
range is empty and no filing will occur.

If <var>lockExtent</var> is true then an extent lock will be acquired before the indices
are built. If the lock cannot be acquired then an error is returned. The lock is released
after the index filing is completed.



<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.</p>
     @param db represented as com.intersys.objects.Database
     @param pStartId represented as java.lang.String
     @param pEndId represented as java.lang.String
     default argument lockExtent set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_SaveIndices(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.Boolean)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%SaveIndices"> Method %SaveIndices</A>
    */
    public static void sys_SaveIndices (com.intersys.objects.Database db, java.lang.String pStartId, java.lang.String pEndId) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(pStartId);
        args[1] = new com.intersys.cache.Dataholder(pEndId);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%SaveIndices",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %SaveIndices in Cache.</p>
     <p>Description: Files the indices for all objects whose ID is in the range defined by <var>pStartId</var> and <var>pEndId</var>.
If <var>pEndId</var> is null then it defaults to <var>pStartId</var>. If <var>pStartId</var> is null then the
range is empty and no filing will occur.

If <var>lockExtent</var> is true then an extent lock will be acquired before the indices
are built. If the lock cannot be acquired then an error is returned. The lock is released
after the index filing is completed.



<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.</p>
     @param db represented as com.intersys.objects.Database
     @param pStartId represented as java.lang.String
     @param pEndId represented as java.lang.String
     @param lockExtent represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#%SaveIndices"> Method %SaveIndices</A>
    */
    public static void sys_SaveIndices (com.intersys.objects.Database db, java.lang.String pStartId, java.lang.String pEndId, java.lang.Boolean lockExtent) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(pStartId);
        args[1] = new com.intersys.cache.Dataholder(pEndId);
        args[2] = new com.intersys.cache.Dataholder(lockExtent);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%SaveIndices",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method ClientTokenReplace in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ClientTokenReplace"> Method ClientTokenReplace</A>
    */
    public static java.lang.String ClientTokenReplace (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ClientTokenReplace",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Data in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#Data"> Method Data</A>
    */
    public static java.lang.String Data (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Data",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetCategory in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.Integer
     @param inCityID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetCategory"> Method GetCategory</A>
    */
    public static java.lang.String GetCategory (com.intersys.objects.Database db, java.lang.Integer inDispatchingID, java.lang.Integer inCityID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inCityID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetCategory",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetClientProfile in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inClientID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetClientProfile"> Method GetClientProfile</A>
    */
    public static java.lang.String GetClientProfile (com.intersys.objects.Database db, java.lang.Integer inClientID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inClientID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetClientProfile",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetDriver in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDriverID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetDriver"> Method GetDriver</A>
    */
    public static java.lang.String GetDriver (com.intersys.objects.Database db, java.lang.Integer inDriverID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inDriverID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetDriver",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetDrivers in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inCityID represented as java.lang.Integer
     @param inLatitude represented as java.lang.Double
     @param inLongitude represented as java.lang.Double
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetDrivers"> Method GetDrivers</A>
    */
    public static java.lang.String GetDrivers (com.intersys.objects.Database db, java.lang.Integer inCityID, java.lang.Double inLatitude, java.lang.Double inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inCityID);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetDrivers",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetHisOrder in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inOrderID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetHisOrder"> Method GetHisOrder</A>
    */
    public static java.lang.String GetHisOrder (com.intersys.objects.Database db, java.lang.Integer inOrderID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inOrderID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetHisOrder",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetOrder in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetOrder"> Method GetOrder</A>
    */
    public static java.lang.String GetOrder (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetOrder",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetPayTypes in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.Integer
     @param inCityID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetPayTypes"> Method GetPayTypes</A>
    */
    public static java.lang.String GetPayTypes (com.intersys.objects.Database db, java.lang.Integer inDispatchingID, java.lang.Integer inCityID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inCityID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetPayTypes",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetPrefernces in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.Integer
     @param inCityID represented as java.lang.Integer
     default argument inClientID set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #GetPrefernces(com.intersys.objects.Database,java.lang.Integer,java.lang.Integer,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetPrefernces"> Method GetPrefernces</A>
    */
    public static java.lang.String GetPrefernces (com.intersys.objects.Database db, java.lang.Integer inDispatchingID, java.lang.Integer inCityID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inCityID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetPrefernces",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetPrefernces in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.Integer
     @param inCityID represented as java.lang.Integer
     @param inClientID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetPrefernces"> Method GetPrefernces</A>
    */
    public static java.lang.String GetPrefernces (com.intersys.objects.Database db, java.lang.Integer inDispatchingID, java.lang.Integer inCityID, java.lang.Integer inClientID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inCityID);
        args[2] = new com.intersys.cache.Dataholder(inClientID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetPrefernces",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetRoutePoint in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inRouteID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetRoutePoint"> Method GetRoutePoint</A>
    */
    public static java.lang.String GetRoutePoint (com.intersys.objects.Database db, java.lang.Integer inRouteID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inRouteID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetRoutePoint",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetTaxiWish in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inDispatchingID represented as java.lang.Integer
     @param inCityID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#GetTaxiWish"> Method GetTaxiWish</A>
    */
    public static java.lang.String GetTaxiWish (com.intersys.objects.Database db, java.lang.Integer inDispatchingID, java.lang.Integer inCityID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inDispatchingID);
        args[1] = new com.intersys.cache.Dataholder(inCityID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetTaxiWish",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method IDKEYDelete in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param K1 represented as java.lang.String
     default argument concurrency set to -1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #IDKEYDelete(com.intersys.objects.Database,java.lang.String,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#IDKEYDelete"> Method IDKEYDelete</A>
    */
    public static void IDKEYDelete (com.intersys.objects.Database db, java.lang.String K1) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(K1);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IDKEYDelete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method IDKEYDelete in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param K1 represented as java.lang.String
     @param concurrency represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#IDKEYDelete"> Method IDKEYDelete</A>
    */
    public static void IDKEYDelete (com.intersys.objects.Database db, java.lang.String K1, java.lang.Integer concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(K1);
        args[1] = new com.intersys.cache.Dataholder(concurrency);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IDKEYDelete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method IDKEYExists in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param K1 represented as java.lang.String
     default argument id set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #IDKEYExists(com.intersys.objects.Database,java.lang.String,com.intersys.objects.StringHolder)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#IDKEYExists"> Method IDKEYExists</A>
    */
    public static java.lang.Boolean IDKEYExists (com.intersys.objects.Database db, java.lang.String K1) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(K1);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IDKEYExists",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method IDKEYExists in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param K1 represented as java.lang.String
     @param id represented as com.intersys.objects.StringHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#IDKEYExists"> Method IDKEYExists</A>
    */
    public static java.lang.Boolean IDKEYExists (com.intersys.objects.Database db, java.lang.String K1, com.intersys.objects.StringHolder id) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(K1);
        args[1] = com.intersys.cache.Dataholder.create (id.value);
        _refs[0] = 2;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"IDKEYExists",_refs,args,com.intersys.objects.Database.RET_PRIM);
        id.set(res[1].getString());
        return res[0].getBoolean();
    }
    /**
     <p>Runs method IDKEYOpen in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param K1 represented as java.lang.String
     default argument concurrency set to -1
     default argument sc set to $$$OK
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #IDKEYOpen(com.intersys.objects.Database,java.lang.String,java.lang.Integer,com.intersys.objects.StatusCodeHolder)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#IDKEYOpen"> Method IDKEYOpen</A>
    */
    public static ataxi.API.MobileAPP IDKEYOpen (com.intersys.objects.Database db, java.lang.String K1) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(K1);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IDKEYOpen",args,com.intersys.objects.Database.RET_OBJECT);
        com.intersys.cache.CacheObject cobj = res.getCacheObject();
        if (cobj == null)
            return null;
        return (ataxi.API.MobileAPP)(cobj.newJavaInstance());
    }
    /**
     <p>Runs method IDKEYOpen in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param K1 represented as java.lang.String
     @param concurrency represented as java.lang.Integer
     default argument sc set to $$$OK
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #IDKEYOpen(com.intersys.objects.Database,java.lang.String,java.lang.Integer,com.intersys.objects.StatusCodeHolder)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#IDKEYOpen"> Method IDKEYOpen</A>
    */
    public static ataxi.API.MobileAPP IDKEYOpen (com.intersys.objects.Database db, java.lang.String K1, java.lang.Integer concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(K1);
        args[1] = new com.intersys.cache.Dataholder(concurrency);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IDKEYOpen",args,com.intersys.objects.Database.RET_OBJECT);
        com.intersys.cache.CacheObject cobj = res.getCacheObject();
        if (cobj == null)
            return null;
        return (ataxi.API.MobileAPP)(cobj.newJavaInstance());
    }
    /**
     <p>Runs method IDKEYOpen in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param K1 represented as java.lang.String
     @param concurrency represented as java.lang.Integer
     @param sc represented as com.intersys.objects.StatusCodeHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#IDKEYOpen"> Method IDKEYOpen</A>
    */
    public static ataxi.API.MobileAPP IDKEYOpen (com.intersys.objects.Database db, java.lang.String K1, java.lang.Integer concurrency, com.intersys.objects.StatusCodeHolder sc) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(K1);
        args[1] = new com.intersys.cache.Dataholder(concurrency);
        args[2] = com.intersys.cache.Dataholder.create (sc.value);
        _refs[0] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"IDKEYOpen",_refs,args,com.intersys.objects.Database.RET_OBJECT);
        sc.set(res[1].getStatusCode());
        com.intersys.cache.CacheObject cobj = res[0].getCacheObject();
        if (cobj == null)
            return null;
        return (ataxi.API.MobileAPP)(cobj.newJavaInstance());
    }
    /**
     <p>Runs method OrdersAdd in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inCalcID represented as java.lang.String
     @param inNote represented as java.lang.String
     @param inPrice represented as java.lang.String
     default argument inIsTest set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #OrdersAdd(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#OrdersAdd"> Method OrdersAdd</A>
    */
    public static java.lang.String OrdersAdd (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inCalcID, java.lang.String inNote, java.lang.String inPrice) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[6];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inCalcID);
        args[4] = new com.intersys.cache.Dataholder(inNote);
        args[5] = new com.intersys.cache.Dataholder(inPrice);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersAdd",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersAdd in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inCalcID represented as java.lang.String
     @param inNote represented as java.lang.String
     @param inPrice represented as java.lang.String
     @param inIsTest represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#OrdersAdd"> Method OrdersAdd</A>
    */
    public static java.lang.String OrdersAdd (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inCalcID, java.lang.String inNote, java.lang.String inPrice, java.lang.Integer inIsTest) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[7];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inCalcID);
        args[4] = new com.intersys.cache.Dataholder(inNote);
        args[5] = new com.intersys.cache.Dataholder(inPrice);
        args[6] = new com.intersys.cache.Dataholder(inIsTest);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersAdd",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersCalc in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inData represented as java.lang.String
     @param inWish represented as java.lang.String
     @param inRoute represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#OrdersCalc"> Method OrdersCalc</A>
    */
    public static java.lang.String OrdersCalc (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inData, java.lang.String inWish, java.lang.String inRoute) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[6];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inData);
        args[4] = new com.intersys.cache.Dataholder(inWish);
        args[5] = new com.intersys.cache.Dataholder(inRoute);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersCalc",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersDeny in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inReason represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#OrdersDeny"> Method OrdersDeny</A>
    */
    public static java.lang.String OrdersDeny (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inReason, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inReason);
        args[2] = new com.intersys.cache.Dataholder(inLatitude);
        args[3] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersDeny",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersFeedback in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inGUID represented as java.lang.String
     @param inRating represented as java.lang.String
     @param inNote represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#OrdersFeedback"> Method OrdersFeedback</A>
    */
    public static java.lang.String OrdersFeedback (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inGUID, java.lang.String inRating, java.lang.String inNote) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inGUID);
        args[2] = new com.intersys.cache.Dataholder(inRating);
        args[3] = new com.intersys.cache.Dataholder(inNote);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersFeedback",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OrdersHistory in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLastGUID represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#OrdersHistory"> Method OrdersHistory</A>
    */
    public static java.lang.String OrdersHistory (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLastGUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLastGUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OrdersHistory",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Preferences in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     default argument inProfile set to 0
     default argument inData set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Preferences(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#Preferences"> Method Preferences</A>
    */
    public static java.lang.String Preferences (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Preferences",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Preferences in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inProfile represented as java.lang.String
     default argument inData set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Preferences(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#Preferences"> Method Preferences</A>
    */
    public static java.lang.String Preferences (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inProfile) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inProfile);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Preferences",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Preferences in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inProfile represented as java.lang.String
     @param inData represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#Preferences"> Method Preferences</A>
    */
    public static java.lang.String Preferences (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inProfile, java.lang.String inData) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inLatitude);
        args[2] = new com.intersys.cache.Dataholder(inLongitude);
        args[3] = new com.intersys.cache.Dataholder(inProfile);
        args[4] = new com.intersys.cache.Dataholder(inData);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Preferences",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileCheckPhone in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inPhone represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ProfileCheckPhone"> Method ProfileCheckPhone</A>
    */
    public static java.lang.String ProfileCheckPhone (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inPhone) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileCheckPhone",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileCheckPhoneCode in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inPhone represented as java.lang.String
     @param inCode represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ProfileCheckPhoneCode"> Method ProfileCheckPhoneCode</A>
    */
    public static java.lang.String ProfileCheckPhoneCode (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inPhone, java.lang.String inCode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        args[2] = new com.intersys.cache.Dataholder(inCode);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileCheckPhoneCode",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ProfileGet"> Method ProfileGet</A>
    */
    public static java.lang.String ProfileGet (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileLogin in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inPhone represented as java.lang.String
     default argument inType set to "sms"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #ProfileLogin(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ProfileLogin"> Method ProfileLogin</A>
    */
    public static java.lang.String ProfileLogin (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inPhone) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileLogin",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileLogin in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inPhone represented as java.lang.String
     @param inType represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ProfileLogin"> Method ProfileLogin</A>
    */
    public static java.lang.String ProfileLogin (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inPhone, java.lang.String inType) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        args[2] = new com.intersys.cache.Dataholder(inType);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileLogin",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileRegistration in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inKey represented as java.lang.String
     @param inPhone represented as java.lang.String
     @param inCode represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ProfileRegistration"> Method ProfileRegistration</A>
    */
    public static java.lang.String ProfileRegistration (com.intersys.objects.Database db, java.lang.String inKey, java.lang.String inPhone, java.lang.String inCode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inKey);
        args[1] = new com.intersys.cache.Dataholder(inPhone);
        args[2] = new com.intersys.cache.Dataholder(inCode);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileRegistration",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProfileSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inName represented as java.lang.String
     @param inEMail represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#ProfileSet"> Method ProfileSet</A>
    */
    public static java.lang.String ProfileSet (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inName, java.lang.String inEMail) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inName);
        args[2] = new com.intersys.cache.Dataholder(inEMail);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProfileSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SravnitaxiEstimate in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     @param inDistance represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#SravnitaxiEstimate"> Method SravnitaxiEstimate</A>
    */
    public static java.lang.String SravnitaxiEstimate (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude, java.lang.String inDistance) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[6];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[2] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[4] = new com.intersys.cache.Dataholder(inEndLongitude);
        args[5] = new com.intersys.cache.Dataholder(inDistance);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SravnitaxiEstimate",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SravnitaxiHistory in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @param inBeginDate represented as java.lang.String
     @param inEndDate represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#SravnitaxiHistory"> Method SravnitaxiHistory</A>
    */
    public static java.lang.String SravnitaxiHistory (com.intersys.objects.Database db, java.lang.String inToken, java.lang.String inBeginDate, java.lang.String inEndDate) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        args[1] = new com.intersys.cache.Dataholder(inBeginDate);
        args[2] = new com.intersys.cache.Dataholder(inEndDate);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SravnitaxiHistory",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SravnitaxiManifest in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inToken represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.MobileAPP#SravnitaxiManifest"> Method SravnitaxiManifest</A>
    */
    public static java.lang.String SravnitaxiManifest (com.intersys.objects.Database db, java.lang.String inToken) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inToken);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SravnitaxiManifest",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Returns a CallableStatement for query Extent.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
    */
    public static com.intersys.objects.CacheQuery query_Extent (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        return new com.intersys.objects.CacheQuery(db, "ataxi.API.MobileAPP_Extent", 0, 0);
    }

    public static Object addToBatchInsert (Object batch, java.sql.Connection con) throws java.sql.SQLException {
        if (batch == null) {
            com.intersys.jdbc.CacheConnection c = null;
            if (con != null) {
                try {
                    c = com.intersys.cache.jdbcutil.JDBCAdapter.getCacheConnection (con);
                } catch (com.intersys.objects.CacheException x) {
                    throw new java.sql.SQLException ("Connection is not a CacheConnection.");
                }
            }
            batch = new com.intersys.jdbc.QuickStatement.Batch (c.getConnectionInfo ());
        }
        com.intersys.jdbc.QuickStatement.Batch qbatch = (com.intersys.jdbc.QuickStatement.Batch) batch;
        com.intersys.jdbc.SysListProxy.setInteger (qbatch.list, 1); // number of columns
        com.intersys.jdbc.SysListProxy.setUndefined(qbatch.list); // for x__classname
        qbatch.flushRecord ();
        return qbatch;
    }
    
    public static java.util.List executeBatchInsert (java.sql.Connection con, Object batch, int nolock) throws java.sql.SQLException {
        Object ids = com.intersys.jdbc.QuickStatement.Batch.execute ("API", "MobileAPP", 4, batch, con, nolock);
        return new com.intersys.objects.SList (ids);
        }
}
