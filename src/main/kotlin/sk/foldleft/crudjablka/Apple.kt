package sk.foldleft.crudjablka

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Apple(var color: String, var size: Int) {

  constructor():this("", 0) { }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  override fun toString() : String {
    return "Color='$color', Size=$size";
  }
}

