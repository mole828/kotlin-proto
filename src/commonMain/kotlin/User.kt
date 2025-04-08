package model

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

typealias UserId = Int

@JsExport
data class User (
    val userId: UserId
)

@JsExport
data class UserList(
    val value: List<User>
)

@JsExport
fun userFlat() {
    val list = listOf(
        User(1),
        User(2),
        User(2),
        User(3),
    )
    val newList = list.filter { it.userId%2 == 1 }
    println(newList)
}

@JsExport
class MyClient(
    val session: String = "",
    val baseUrl: String = "",
) {

    val ktorClient = HttpClient {  }
//    val signService =  object {
//        fun login(username: String) {
//            run {
//                when (username) {
//                    "123" -> return@login
//                    else -> throw Error("")
//                }
//            }
//            return
//        }
//    }
    interface I0 {
        fun sayMyName() {
            println("")
        }
    }
    interface H {
        val name: String
        fun login(username: String) {
            run {
                when (username) {
                    "123" -> return@login
                    else -> throw Error("")
                }
            }
            return
        }
        fun sayMyName() {
            println(": $name")
        }
    }
    val signService = run {
        object : H {
            override val name: String = "bob"
        }
    }
    val customerService = object {

    }
    companion object {
        fun from(session: String) = MyClient(baseUrl = session, session = session)

        interface Dog {
            val name: String
        }
        enum class DogEnum(val d: Dog) {
            DARK_DOG(object : Dog {
                override val name: String = "DarkDog"
            }),
            WHITE_DOT(object : Dog {
                override val name: String = "nigger"
            })
        }
    }

    fun fetchUser() : MyClient {
        val ktorClient = HttpClient {  }
        scope.launch {
            val resp = ktorClient.get("https://www.baidu.com") {
                parameters {
                    set("a", "b")
                }
            }
            ktorClient.post {
                url.set("")

            }
            println(resp.bodyAsText())
        }
        return MyClient()
    }
}
val scope = CoroutineScope(Dispatchers.Main)


@JsExport
fun fetchUser_2() : MyClient {
    val ktorClient = HttpClient {  }
    scope.launch {
        val resp = ktorClient.get("https://www.baidu.com") {
            parameters {
                set("a", "b")
            }
        }
        ktorClient.post {
            url.set("")

        }
        println(resp.bodyAsText())
    }
    return MyClient()
}