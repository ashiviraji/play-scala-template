package controllers.Authentication

import javax.inject.Inject
import play.api.mvc.Results._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class AuthenticatedUserAction @Inject() (parser: BodyParsers.Default) (implicit ec: ExecutionContext)
  extends ActionBuilderImpl(parser) {
  private val logger = play.api.Logger(this.getClass)

  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    logger.info("ENTERED AuthenticatedUserAction:: invokedBlock ...")

    val maybeUsername = request.session.get(models.Global.SESSION_USERNAME_KEY)
    maybeUsername match {
      case None => {
        Future.successful(Redirect(routes.UserController.showLoginForm))
      }
      case Some(u) => {
        val res: Future[Result] = block(request)
        res
      }
    }
  }
}
