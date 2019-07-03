// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/volodymyrbilyi/Downloads/play-samples-2.7.x/play-scala-rest-api-example/conf/routes
// @DATE:Tue Jul 02 15:11:13 EEST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
