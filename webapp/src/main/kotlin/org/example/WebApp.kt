package org.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class WebApp {

}

fun main(vararg args: String) {
    SpringApplication.run(WebApp::class.java, *args)
}