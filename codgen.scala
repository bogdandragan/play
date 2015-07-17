object MySQLPlayground {
  def main(args: Array[String]) {
    slick.codegen.SourceCodeGenerator.main(
    Array("scala.slick.driver.MySQLDriver", "com.mysql.jdbc.Driver",
      "jdbc:mysql://localhost/play", "test/models", "Gen", "root", "123"))
  }
}