package controllers.Authentication

import controllers.AssetsFinder
import javax.inject._
import play.api.mvc._

@Singleton
class LandingPageController @Inject()(
  cc: ControllerComponents,
  authenticatedUserAction: AuthenticatedUserAction
) (implicit assetsFinder: AssetsFinder) extends AbstractController(cc) {
  private val logoutUrl = routes.AuthenticatedUserController.logout

  def showLandingPage() = authenticatedUserAction { implicit request: Request[AnyContent] =>
    Ok(views.html.LoginForms.profile(logoutUrl))
  }
}
