package example

import ma.glasnost.orika.MapperFacade
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(proxyBeanMethods = false)
@RestController
class App(private val orikaMapperFacade: MapperFacade) {

    @GetMapping("person")
    fun getPerson(): PersonDestination {
        val src = PersonSource("John", "Smith", 23)
        val dest = orikaMapperFacade.map(src, PersonDestination::class.java)
        return dest
    }

}

fun main(vararg args: String) {
    runApplication<App>(*args)
}
