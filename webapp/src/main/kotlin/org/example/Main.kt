package org.example

import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import org.example.common.MyButton
import org.example.common.MyTextField
import org.example.common.MyLit

@Route("/")
class Main : VerticalLayout() {
    init {
        add(Span("Oh hi, Marc!"))
        add(MyButton().apply {
            text = "A button!"
        })
        add(MyLit())
        add(MyTextField())
    }
}