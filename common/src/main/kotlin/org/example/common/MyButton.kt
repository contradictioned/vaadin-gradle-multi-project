package org.example.common

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.CssImport

@CssImport(value = "./styles/mybutton.css", themeFor = "vaadin-button")
class MyButton : Button() {
}