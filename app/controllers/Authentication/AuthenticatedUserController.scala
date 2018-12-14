package controllers.Authentication

import javax.inject._
import play.api.mvc._

@Singleton
class AuthenticatedUserController @Inject()(
    cc: ControllerComponents,
    authenticatedUserAction: AuthenticatedUserAction
) extends AbstractController(cc) {
  def logout = authenticatedUserAction { implicit request: Request[AnyContent] =>
    Redirect(routes.UserController.showLoginForm)
      .flashing("info" -> "You're logged in")
      .withNewSession
  }
}
