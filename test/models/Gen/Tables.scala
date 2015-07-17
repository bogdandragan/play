package Gen
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Users.ddl
  
  /** Entity class storing rows of table Users
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param accesstoken Database column accessToken DBType(VARCHAR), Length(255,true)
   *  @param photo Database column photo DBType(VARCHAR), Length(255,true)
   *  @param name Database column name DBType(VARCHAR), Length(50,true)
   *  @param lastname Database column lastname DBType(VARCHAR), Length(50,true)
   *  @param email Database column email DBType(VARCHAR), Length(50,true)
   *  @param password Database column password DBType(VARCHAR), Length(255,true)
   *  @param timestamp Database column timestamp DBType(BIGINT)
   *  @param address Database column address DBType(VARCHAR), Length(255,true)
   *  @param isadmin Database column isAdmin DBType(BIT)
   *  @param passcode Database column passCode DBType(VARCHAR), Length(255,true) */
  case class UsersRow(id: Int, accesstoken: String, photo: String, name: String, lastname: String, email: String, password: String, timestamp: Long, address: String, isadmin: Boolean, passcode: String)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Long], e3: GR[Boolean]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Long], <<[String], <<[Boolean], <<[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends Table[UsersRow](_tableTag, "users") {
    def * = (id, accesstoken, photo, name, lastname, email, password, timestamp, address, isadmin, passcode) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, accesstoken.?, photo.?, name.?, lastname.?, email.?, password.?, timestamp.?, address.?, isadmin.?, passcode.?).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column accessToken DBType(VARCHAR), Length(255,true) */
    val accesstoken: Column[String] = column[String]("accessToken", O.Length(255,varying=true))
    /** Database column photo DBType(VARCHAR), Length(255,true) */
    val photo: Column[String] = column[String]("photo", O.Length(255,varying=true))
    /** Database column name DBType(VARCHAR), Length(50,true) */
    val name: Column[String] = column[String]("name", O.Length(50,varying=true))
    /** Database column lastname DBType(VARCHAR), Length(50,true) */
    val lastname: Column[String] = column[String]("lastname", O.Length(50,varying=true))
    /** Database column email DBType(VARCHAR), Length(50,true) */
    val email: Column[String] = column[String]("email", O.Length(50,varying=true))
    /** Database column password DBType(VARCHAR), Length(255,true) */
    val password: Column[String] = column[String]("password", O.Length(255,varying=true))
    /** Database column timestamp DBType(BIGINT) */
    val timestamp: Column[Long] = column[Long]("timestamp")
    /** Database column address DBType(VARCHAR), Length(255,true) */
    val address: Column[String] = column[String]("address", O.Length(255,varying=true))
    /** Database column isAdmin DBType(BIT) */
    val isadmin: Column[Boolean] = column[Boolean]("isAdmin")
    /** Database column passCode DBType(VARCHAR), Length(255,true) */
    val passcode: Column[String] = column[String]("passCode", O.Length(255,varying=true))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}