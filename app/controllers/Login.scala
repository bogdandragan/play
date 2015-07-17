package controllers
import org.mindrot.jbcrypt.BCrypt
import play.api.db.slick._
import play.api.libs.json.Json
import play.api.mvc._
import models.Tables._
import scala.slick.driver.MySQLDriver.simple._

object Login extends Controller {

  def index = DBAction { implicit request =>
    Redirect(routes.Dashboard.index())
  }

  def login = DBAction { implicit request =>
    Ok(views.html.login())
  }

  case class Login(error: String, data: Map[String, String])
  implicit val loginWrites = Json.writes[Login]

  def doLogin = DBAction{ implicit request =>
    val json = request.body.asJson.get

    val action = (json \ "action").as[String]

    if(action == "login"){
      val params = json \ "params"
      val email = (params \ "email").as[String]

      val pass = (params \ "pass").as[String]

      try{
        val passFromDb : String = Users.filter(p=>p.email === email).map(p=>p.password).first
       // Ok(passFromDb)
        if(BCrypt.checkpw(pass, passFromDb)){
          val accessToken : String = BCrypt.hashpw(System.currentTimeMillis.toString, BCrypt.gensalt())
          val user = Users.filter(p=>p.email === email).map(p=> p.accesstoken).update(accessToken)

          val  response = Json.toJson(Login("",Map("accessToken"->accessToken)))
          Ok(Json.stringify(response))
        }
        else{
          val  response = Json.toJson(Login("incorrect email or password", Map(""->"")))
          Ok(Json.stringify(response))
        }
      }
      catch {
        case e: Exception => {
          val  response = Json.toJson(Login("incorrect email or password", Map(""->"")))
          Ok(Json.stringify(response))
        }
      }
    }
    else{
      Ok("-1")
    }
  }

  def newPost() = DBAction { implicit request =>
    //val t = new Timestamp
   // Posts.forceInsert(PostsRow(0,"dte","dhhhhed", new java.sql.Timestamp(System.currentTimeMillis())))
    Ok("newPost")
  }

  def newUser() = DBAction {  implicit request =>
    var s:String = "123456"

    val passwordHash : String = BCrypt.hashpw(s, BCrypt.gensalt())

   // Users.forceInsert(UsersRow(0,"Bogdan","Dragan","admin@admin",passwordHash))
    Ok("newUser")
  }


}


