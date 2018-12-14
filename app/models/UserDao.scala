package models

import javax.inject.Inject

class UserDao @Inject()() {
  def lookUpUser(u: User): Boolean = {
    if(u.username == "foo" && u.password == "foo") true else false
  }
}
