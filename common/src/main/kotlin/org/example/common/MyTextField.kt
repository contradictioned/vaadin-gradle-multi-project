package org.example.common

import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.textfield.TextField

@CssImport(value = "./styles/mytextfield.scss", themeFor = "vaadin-text-field")
class MyTextField : TextField() {
}