package cn.no7player.controller

import cn.no7player.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

/**
 * Created by hank on 2017/6/9.
 */

var a = 0
var b = ""
var c: String = "hello"
var d = null
var arrs = Array(3) { Array(2) { IntArray(1) } }
var x = 10
var list = ArrayList<String>()

@Autowired
private val userService: UserService? = null

@RequestMapping("")
fun login(model: Model): String {

    when(x) {
        2-> println("等于2")
        if (x>0) 1 else -1 -> println("1")
        in 1..5 -> println("1~5")
        is Int -> println("type")
        else -> println("else")
    }

    for (i in list.indices) { print(list[i]) }

    for (i in 2..list.size-1) { print(list[i]) }

    for (item in list) { print(item) }

    list.forEach { print(it) }

    class User {
        var name: String? = null
        var age: String? = null
    }

    val user = User()
    user.name = "tutu"
    user.age = "23"

    val name = user.name
    val age = user.age

    var userInfo = "name:$name, age:${user.age}"

    return "log_in"
}