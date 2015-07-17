package controllers

import play.api.db.slick._
import play.api.mvc._
import models.Tables._
import scala.slick.driver.MySQLDriver.simple._
import play.api.libs.json.Json

object Dashboard extends Controller{

  def index = Action{
    Ok(views.html.dashboard())
  }


  def checkToken = DBAction{ implicit request =>
    val json = request.body.asJson.get

    val action = (json \ "action").as[String]
    val accessToken = (json \ "params" \ "accessToken").as[String]

      if(action == "checkToken"){
      val user =  Users.filter(p=>p.accesstoken === accessToken).list.length

      if(user > 0){
        val response = Map("error"->"")
        Ok(Json.stringify(Json.toJson(response)))
      }
      else{
        val response = Map("error"->"invalid access token")
        Ok(Json.stringify(Json.toJson(response)))
      }
    }
    else
      BadRequest("incorrect patameter")
  }


  case class User(error: String, data: Map[String, String])
  implicit val userWrites = Json.writes[User]

  def getUserByToken = DBAction{ implicit request =>
    val json = request.body.asJson.get

    val action = (json \ "action").as[String]
    val accessToken = (json \ "params" \ "accessToken").as[String]

    if(action == "getUserByToken"){
      val user = Users.filter(p=>p.accesstoken === accessToken).firstOption.map(p=>(p.name, p.lastname, p.email, p.address, p.photo, p.timestamp, p.isadmin)).get._1

      Ok(user)



      if(user != null){
        //val id = user.get()

        Ok(user)
      }
      else{
        Ok("tete")
      }
    }
    else
      BadRequest("incorrect patameter")
  }

  def getUserById = DBAction{
    Ok("")
  }

  def getUsers = DBAction{
    Ok("")
  }

  def updateUser = DBAction{
    Ok("")
  }

  def checkRole = DBAction{
    Ok("")
  }
}
