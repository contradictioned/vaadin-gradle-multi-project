package org.example.common

import com.vaadin.flow.component.Tag
import com.vaadin.flow.component.dependency.JsModule
import com.vaadin.flow.component.littemplate.LitTemplate

@Tag("my-lit")
@JsModule("./MyLit.ts")
class MyLit : LitTemplate() {
}