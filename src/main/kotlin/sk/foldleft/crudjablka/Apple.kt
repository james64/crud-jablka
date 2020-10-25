package sk.foldleft.crudjablka

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Apple(var color: String, var size: Int) {
  @Id
  @GeneratedValue
  var id: Long? = null

  override fun toString() : String {
    return "Color='$color', Size=$size";
  }
}

